package com.proyect.CodeShareSpace.dto;

import com.proyect.CodeShareSpace.persistence.model.Course;
import com.proyect.CodeShareSpace.persistence.model.Rol;
import lombok.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

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
    private Set<Course> courses;
}
