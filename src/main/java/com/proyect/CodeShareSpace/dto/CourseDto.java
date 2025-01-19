package com.proyect.CodeShareSpace.dto;

import com.proyect.CodeShareSpace.persistence.model.User;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CourseDto {
    private Long courseId;
    private String name;
}
