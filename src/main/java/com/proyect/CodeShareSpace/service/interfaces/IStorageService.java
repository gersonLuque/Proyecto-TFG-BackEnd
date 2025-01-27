package com.proyect.CodeShareSpace.service.interfaces;

import com.proyect.CodeShareSpace.persistence.model.File.FileBase;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.function.Function;

public interface IStorageService {

    <T extends FileBase> List<T> upload(String prefix, List<MultipartFile> files, Function<MultipartFile, T> fileConstructor);
}
