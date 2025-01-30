package com.proyect.CodeShareSpace.model.File;

import jakarta.persistence.*;
import lombok.*;


@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class FileBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileId;
    private String fileName;
    private String prefix;
    private String type;
    private Long KBytes;

    public String extractExtension(String fileName){
        return fileName.substring(fileName.lastIndexOf(".")+ 1);
    }
    public String getKey(){
        return prefix + "/" + fileName;
    }
}

