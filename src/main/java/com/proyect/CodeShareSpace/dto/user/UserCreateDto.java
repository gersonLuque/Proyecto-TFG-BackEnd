package com.proyect.CodeShareSpace.dto.user;

import com.proyect.CodeShareSpace.dto.course.CourseDto;
import com.proyect.CodeShareSpace.model.Rol;
import lombok.*;

import java.util.List;

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
