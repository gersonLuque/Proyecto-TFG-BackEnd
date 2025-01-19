package com.proyect.CodeShareSpace.service.interfaces;

import com.proyect.CodeShareSpace.dto.CourseCreateDto;
import com.proyect.CodeShareSpace.dto.CourseDto;
import com.proyect.CodeShareSpace.dto.user.UserDto;

import java.util.List;

public interface ICourseService {
    List<UserDto> findUsersByCourseId(Long courseId);
    CourseDto findById(Long courseId);
    List<CourseDto> findAll();
    List<CourseDto> findByUserId(Long userId);
    CourseDto createCourse(CourseCreateDto courseCreateDto);
}
