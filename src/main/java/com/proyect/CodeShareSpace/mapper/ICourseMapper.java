package com.proyect.CodeShareSpace.mapper;

import com.proyect.CodeShareSpace.dto.CourseDto;
import com.proyect.CodeShareSpace.persistence.model.Course;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ICourseMapper {
    ICourseMapper INSTANCE = Mappers.getMapper(ICourseMapper.class);

    CourseDto courseToCourseDto(Course course);
    Course courseDtoToCourse(CourseDto courseDto);

}
