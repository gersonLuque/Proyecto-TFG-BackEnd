package com.proyect.CodeShareSpace.service.implementations;

import com.proyect.CodeShareSpace.exception.S3ObjectNotFoundException;
import com.proyect.CodeShareSpace.persistence.model.File.FileBase;
import com.proyect.CodeShareSpace.service.interfaces.IS3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.io.File;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class S3Service implements IS3Service {

    @Autowired
    private S3Client s3Client;

    @Value("${aws.bucket.name}")
    private String bucket;

    @Override
    public List<S3Object> listObjectsS3(String prefix) {
        ListObjectsV2Request request =  ListObjectsV2Request.builder()
                .bucket(bucket)
                .prefix(prefix)
                .build();

        ListObjectsV2Response response = s3Client.listObjectsV2(request);

        return response.contents();
    }

    @Override
    public S3Object getObjectS3(String prefix, String filename) {
        return listObjectsS3(prefix).stream()
                .filter(s3Object -> s3Object.key().endsWith(filename))
                .findFirst()
                .orElseThrow(() -> new S3ObjectNotFoundException("Fichero no encontrado : "+filename));
    }

    @Override
    public String getFileContent(String prefix, String fileName) {

        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                .bucket(bucket)
                .key(prefix + fileName)
                .build();

        ResponseBytes<GetObjectResponse> objectBytes = s3Client.getObjectAsBytes(getObjectRequest);

        return objectBytes.asUtf8String();
    }

    private boolean isFile(String route) {
        return !route.endsWith("/");
    }

    private String extractFileName(String route){
        return route.substring(route.lastIndexOf("/") + 1);
    }

}
