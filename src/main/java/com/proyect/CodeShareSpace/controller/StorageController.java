package com.proyect.CodeShareSpace.controller;

import com.proyect.CodeShareSpace.persistence.model.File.FileBase;
import com.proyect.CodeShareSpace.service.implementations.S3Service;
import com.proyect.CodeShareSpace.service.interfaces.IS3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/storage")
public class StorageController {

    @Autowired
    private IS3Service is3Service;

    @GetMapping("{prefix}/{fileName}/content")
    public ResponseEntity<String> getContentFromFile(@PathVariable String prefix,
                                                     @PathVariable String fileName){
        return new ResponseEntity<>( is3Service.getFileContent("nose"),HttpStatus.OK);
    }

    @GetMapping("/download")
    public ResponseEntity<InputStreamResource> download(@RequestParam String key) {
        InputStreamResource resource = is3Service.downloadFile(key);
        String fileName = is3Service.getFileName(key);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
}
