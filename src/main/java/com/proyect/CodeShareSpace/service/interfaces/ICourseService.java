package com.proyect.CodeShareSpace.service.interfaces;

import com.proyect.CodeShareSpace.dto.course.CourseCreateDto;
import com.proyect.CodeShareSpace.dto.course.CourseDto;
import com.proyect.CodeShareSpace.dto.user.UserDto;

import java.util.List;

public interface ICourseService {
    List<UserDto> findUsersByCourseId(Long courseId);
    CourseDto findById(Long courseId);
    List<CourseDto> findAll();
    List<CourseDto> findByUserId(Long userId);

    CourseDto updateCourse(CourseDto courseDto);

    CourseDto createCourse(CourseCreateDto courseCreateDto, Long userId);
    void deleteCourse(Long courseId);
}
