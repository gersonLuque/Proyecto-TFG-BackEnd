package com.proyect.CodeShareSpace.dto.user;

import com.proyect.CodeShareSpace.dto.course.CourseDto;
import com.proyect.CodeShareSpace.model.Rol;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode
@ToString
public class UserDto {
    private Long userId;
    private String username;
    private String password;
    private String completeName;
    private Rol rol;
    private List<CourseDto> courses;
}
