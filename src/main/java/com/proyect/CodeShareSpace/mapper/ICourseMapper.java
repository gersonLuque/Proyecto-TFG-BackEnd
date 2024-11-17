package com.proyect.CodeShareSpace.mapper;

import com.proyect.CodeShareSpace.dto.CourseDto;
import com.proyect.CodeShareSpace.dto.UserDto;
import com.proyect.CodeShareSpace.persistence.model.Course;
import com.proyect.CodeShareSpace.persistence.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ICourseMapper {
    Course courseDtoToCourse(CourseDto courseDto);
    CourseDto courseToCourseDto(Course course);
    List<CourseDto> coursesToCourseDtos(List<Course> courses);

}
