package com.proyect.CodeShareSpace.mapper;

import com.proyect.CodeShareSpace.dto.CourseDto;
import com.proyect.CodeShareSpace.persistence.model.Course;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICourseMapper {
    Course courseDtoToCourse(CourseDto courseDto);
    CourseDto courseToCourseDto(Course course);
    List<Course> mapToCourse(List<CourseDto> courses);
    List<CourseDto> coursesToCourseDtos(List<Course> courses);


}
