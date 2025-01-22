package com.proyect.CodeShareSpace.controller;

import com.proyect.CodeShareSpace.service.interfaces.IS3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/s3")
public class StorageController {

    @Autowired
    private IS3Service is3Service;

    @GetMapping
    public ResponseEntity<List<String>> test(){
        return new ResponseEntity<>(is3Service.listObjectsS3("tasks"), HttpStatus.OK );
    }
}
