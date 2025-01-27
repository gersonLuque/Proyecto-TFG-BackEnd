package com.proyect.CodeShareSpace.service.implementations;

import com.proyect.CodeShareSpace.persistence.model.File.FileBase;
import com.proyect.CodeShareSpace.service.interfaces.IS3Service;
import com.proyect.CodeShareSpace.service.interfaces.IStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Service
public class StorageServiceImpl implements IStorageService {


    @Autowired
    private IS3Service is3Service;

    @Override
    public <T extends FileBase> List<T> upload(String prefix,
                                               List<MultipartFile> files,
                                               Function<MultipartFile, T> fileConstructor) {
        List<T> result = new ArrayList<>();
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
}
