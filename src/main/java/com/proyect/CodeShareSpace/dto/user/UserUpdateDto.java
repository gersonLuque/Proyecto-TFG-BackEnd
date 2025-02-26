package com.proyect.CodeShareSpace.dto.user;

import com.proyect.CodeShareSpace.dto.course.CourseDto;
import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserUpdateDto {
    private Long userId;
    private String completeName;
    private List<CourseDto> courses;
}
