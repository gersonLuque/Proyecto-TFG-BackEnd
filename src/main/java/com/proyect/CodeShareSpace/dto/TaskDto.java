package com.proyect.CodeShareSpace.dto;

import com.proyect.CodeShareSpace.persistence.model.Course;
import com.proyect.CodeShareSpace.persistence.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private Long taskId;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean visible;
    private Course course;
    private User teacher;
    private String filePath;
}
