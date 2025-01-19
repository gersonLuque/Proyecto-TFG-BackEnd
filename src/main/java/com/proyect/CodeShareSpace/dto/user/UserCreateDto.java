package com.proyect.CodeShareSpace.dto.user;

import com.proyect.CodeShareSpace.dto.CourseDto;
import com.proyect.CodeShareSpace.persistence.model.Course;
import com.proyect.CodeShareSpace.persistence.model.Rol;
import lombok.*;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserCreateDto {
    private String username;
    private String password;
    private String completeName;
    private Rol rol;
    private List<CourseDto> courses;
}
