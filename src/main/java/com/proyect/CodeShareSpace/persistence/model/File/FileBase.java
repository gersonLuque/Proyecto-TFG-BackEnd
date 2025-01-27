package com.proyect.CodeShareSpace.persistence.model.File;

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
    private Double KBytes;
}

