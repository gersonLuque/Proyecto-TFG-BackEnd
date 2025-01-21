package com.proyect.CodeShareSpace.dto.task;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
public class CreateTaskDto {
    private String description;
    private String title;
    private LocalDate endDate;
    private boolean visible;
    private Long courseId;
    private Long teacherId;
    private String filePath;
}
