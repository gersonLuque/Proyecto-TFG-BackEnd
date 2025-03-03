package com.proyect.CodeShareSpace.dto.task;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
public class CreateTaskDto {
    private String description;
    private String title;
    private LocalDate endDate;
    private LocalTime endTime;
    private boolean visible;
    private Long courseId;
    private Long teacherId;
    private List<MultipartFile> files;
}
