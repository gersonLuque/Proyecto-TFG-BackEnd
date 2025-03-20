package com.proyect.CodeShareSpace.controller;

import com.proyect.CodeShareSpace.service.interfaces.IS3Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
@RequestMapping("api/storage")
public class StorageController {

    @Autowired
    private IS3Service is3Service;

    @Operation(
            summary = "Descargar un archivo",
            description = "Permite descargar un archivo especificado por la **key** proporcionada. **Roles requeridos: USER**",
            security = {
                    @SecurityRequirement(name = "bearerAuth")
            }
    )
    @GetMapping("/download")
    public ResponseEntity<InputStreamResource> download(@RequestParam String key) {
        InputStreamResource resource = is3Service.downloadFile(key);
        String fileName = is3Service.getFileName(key);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

    @Operation(
            summary = "Subir un archivo",
            description = "Permite subir un archivo utilizando la **clave** y el archivo proporcionado. **Roles requeridos: ADMIN**",
            security = {
                    @SecurityRequirement(name = "bearerAuth")
            }
    )
    @PostMapping("/upload")
    public ResponseEntity<Void> uploadFile(@RequestParam String key,
                                           @RequestPart MultipartFile file) throws IOException {
        is3Service.uploadFile(key,file);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
