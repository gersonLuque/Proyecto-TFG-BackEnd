package com.proyect.CodeShareSpace.service.implementations;

import com.proyect.CodeShareSpace.model.File.FileBase;
import com.proyect.CodeShareSpace.model.File.FileSolution;
import com.proyect.CodeShareSpace.model.File.FileTask;
import com.proyect.CodeShareSpace.repository.FileSolutionRepository;
import com.proyect.CodeShareSpace.repository.FileTaskRepository;
import com.proyect.CodeShareSpace.service.interfaces.IS3Service;
import com.proyect.CodeShareSpace.service.interfaces.IStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.services.s3.model.S3Exception;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

@Service
public class StorageServiceImpl implements IStorageService {


    @Autowired
    private IS3Service is3Service;

    @Autowired
    private FileTaskRepository fileTaskRepository;

    @Autowired
    private FileSolutionRepository fileSolutionRepository;

    @Override
    public <T extends FileBase> List<T> upload(List<MultipartFile> files,
                                               Function<MultipartFile, T> fileConstructor) {

        String prefix = UUID.randomUUID().toString();
        List<T> result = new ArrayList<>();
        if (files == null || files.isEmpty()) return result;
        for (MultipartFile file : files) {
            try {
                is3Service.uploadFile(prefix, file);
                T fileEntity = fileConstructor.apply(file);
                fileEntity.setPrefix(prefix);
                result.add(fileEntity);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }

    @Override
    public void delete(List<? extends FileBase> files) {
        try {
            if (files != null && !files.isEmpty()) {
                is3Service.deleteFiles(files);
                files.forEach(file -> {
                    if (file instanceof FileTask fileTask) {
                        fileTaskRepository.deleteById(fileTask.getFileId());
                    } else if (file instanceof FileSolution fileSolution) {
                        fileSolutionRepository.deleteById(fileSolution.getFileId());
                    }
                });
            }
        } catch (S3Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T extends FileBase> List<T> update(List<MultipartFile> filesDto,
                                               List<T> filesEntity,
                                               Function<MultipartFile, T> entityConstructor) {

        if (filesDto != null) {
            if (filesEntity != null && !filesEntity.isEmpty() ) {
                delete(filesEntity);
            }
            return upload(filesDto, entityConstructor);
        } else {
            delete(filesEntity);
            return new ArrayList<>();
        }
    }

}
