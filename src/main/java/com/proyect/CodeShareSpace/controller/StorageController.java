package com.proyect.CodeShareSpace.controller;

import com.proyect.CodeShareSpace.persistence.model.File.FileBase;
import com.proyect.CodeShareSpace.service.interfaces.IS3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.InputStream;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/storage")
public class StorageController {

    @Autowired
    private IS3Service is3Service;

    @GetMapping("{prefix}/{fileName}")
    public ResponseEntity<String> getContentFromFile(@PathVariable String prefix,@PathVariable String fileName){
        return new ResponseEntity<>( is3Service.getFileContent(prefix,fileName),HttpStatus.OK);
    }


}
