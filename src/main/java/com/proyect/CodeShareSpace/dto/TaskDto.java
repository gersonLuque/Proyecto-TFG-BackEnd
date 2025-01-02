package com.proyect.CodeShareSpace.dto;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode
@ToString
public class TaskDto {
    private Long taskId;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean visible;
    private CourseDto course;
    private UserDto teacher;
    private String filePath;
}
