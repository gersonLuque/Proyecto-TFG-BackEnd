package com.proyect.CodeShareSpace.service.interfaces;

import com.proyect.CodeShareSpace.dto.CourseDto;
import com.proyect.CodeShareSpace.dto.UserDto;
import com.proyect.CodeShareSpace.persistence.model.User;

import java.util.List;

public interface ICourseService {
    List<UserDto> findUsersByCourseId(Long courseId);
    CourseDto findById(Long courseId);
    List<CourseDto> findAll();
}
