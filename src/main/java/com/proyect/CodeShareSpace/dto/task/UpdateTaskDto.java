package com.proyect.CodeShareSpace.dto.task;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UpdateTaskDto {
    private Long taskId;
    private String title;
    private String description;
    private LocalDate endDate;
    private boolean visible;
    private List<MultipartFile> files;
}
