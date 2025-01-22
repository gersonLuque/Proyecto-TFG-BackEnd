package com.proyect.CodeShareSpace.service.implementations;

import com.proyect.CodeShareSpace.service.interfaces.IS3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Request;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Response;
import software.amazon.awssdk.services.s3.model.S3Object;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class S3Service implements IS3Service {

    @Autowired
    private S3Client s3Client;


    @Override
    public List<String> listObjectsS3(String prefix) {
        ListObjectsV2Request request =  ListObjectsV2Request.builder()
                .bucket("tasks-code-share-363636")
                .prefix(prefix)
                .build();

        ListObjectsV2Response response = s3Client.listObjectsV2(request);

        return response.contents().stream()
                .map(S3Object::key)
                .filter(this::isFile)
                .map(this::extractFileName)
                .collect(Collectors.toList());

    }

    private boolean isFile(String route) {
        return !route.endsWith("/");
    }

    private String extractFileName(String route){
        return route.substring(route.lastIndexOf("/") + 1);
    }

}
