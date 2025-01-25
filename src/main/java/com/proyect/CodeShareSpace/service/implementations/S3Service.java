package com.proyect.CodeShareSpace.service.implementations;

import com.proyect.CodeShareSpace.exception.S3ObjectNotFoundException;
import com.proyect.CodeShareSpace.service.interfaces.IS3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

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
    public String getFileContent(String key) {
        ResponseBytes<GetObjectResponse> objectBytes = getObjectBytes(key);
        return objectBytes.asUtf8String();
    }

    @Override
    public InputStreamResource downloadFile(String key){
        ResponseBytes<GetObjectResponse> objectBytes = getObjectBytes(key);
        return new InputStreamResource(objectBytes.asInputStream());
    }

    @Override
    public void uploadFile(String key, MultipartFile file) throws IOException {
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucket)
                .key(key)
                .build();

        RequestBody requestBody = RequestBody
                .fromInputStream(file.getInputStream(), file.getSize());

        s3Client.putObject(putObjectRequest,requestBody);

    }

    @Override
    public String getFileName(String key){
        return key.substring(key.lastIndexOf("/") + 1);
    }

    private ResponseBytes<GetObjectResponse> getObjectBytes(String key) {
        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                .bucket(bucket)
                .key(key)
                .build();


        ResponseBytes<GetObjectResponse> objectBytes = s3Client.getObjectAsBytes(getObjectRequest);
        return objectBytes;
    }

    private boolean isFile(String route) {
        return !route.endsWith("/");
    }

    private String extractFileName(String route){
        return route.substring(route.lastIndexOf("/") + 1);
    }

}
