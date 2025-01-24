package com.proyect.CodeShareSpace.service.interfaces;

import com.proyect.CodeShareSpace.persistence.model.File.FileBase;
import software.amazon.awssdk.services.s3.model.S3Object;

import java.io.File;
import java.util.List;

public interface IS3Service {
    List<S3Object> listObjectsS3(String prefix);
    S3Object getObjectS3(String prefix,String fileName);
    String getFileContent(String prefix,String fileName);

}
