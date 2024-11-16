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

@Mapper
public interface ICourseMapper {
    ICourseMapper INSTANCE = Mappers.getMapper(ICourseMapper.class);
    Course courseDtoToCourse(CourseDto courseDto);
    CourseDto courseToCourseDto(Course course);

}
