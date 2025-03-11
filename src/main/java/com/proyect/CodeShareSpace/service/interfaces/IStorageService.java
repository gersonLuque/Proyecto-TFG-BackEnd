package com.proyect.CodeShareSpace.service.interfaces;

import com.proyect.CodeShareSpace.model.File.FileBase;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.function.Function;

public interface IStorageService {

    <T extends FileBase> List<T> upload(List<MultipartFile> files, Function<MultipartFile, T> fileConstructor);

    void delete(List<? extends FileBase> files);

    <T extends FileBase> List<T> update(List<MultipartFile> filesDto, List<T> filesEntity, Function<MultipartFile, T> entityConstructor);
}
