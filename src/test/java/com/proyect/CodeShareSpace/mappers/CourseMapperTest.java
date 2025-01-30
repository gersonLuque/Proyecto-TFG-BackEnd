package com.proyect.CodeShareSpace.mappers;

import java.util.List;

import com.proyect.CodeShareSpace.DataProvider;
import org.mapstruct.factory.Mappers;
import org.junit.jupiter.api.Test;
import com.proyect.CodeShareSpace.dto.course.CourseDto;
import com.proyect.CodeShareSpace.mapper.ICourseMapper;
import com.proyect.CodeShareSpace.model.Course;
import static org.junit.jupiter.api.Assertions.*;

public class CourseMapperTest {

    private ICourseMapper iCourseMapper = Mappers.getMapper(ICourseMapper.class);

    @Test
    public void testCourseToCourseDto() {
        // Given
        Course course = DataProvider.newCourseMock();


        // Mapea el Course -> CourseDto
        CourseDto courseDto = iCourseMapper.courseToCourseDto(course);

        // Then
        assertNotNull(courseDto, "El CourseDto no debe ser null");
        assertEquals(course.getCourseId(),courseDto.getCourseId());
        assertEquals(course.getName(), courseDto.getName());
    }

    @Test
    public void testCourseDtoToCourse() {
        // Given
        CourseDto courseDto = DataProvider.newCourseDTOMock();

        // Mapea el CourseDto -> Course
        Course course = iCourseMapper.courseDtoToCourse(courseDto);

        // Then
        assertNotNull(course, "El Course no debe ser null");
        assertEquals(courseDto.getCourseId(), course.getCourseId());
        assertEquals(courseDto.getName(), course.getName());
    }

    @Test
    public void testCoursesToCourseDtos(){
        // Given
        List<Course> courseList = DataProvider.newCoursesListMock();

        // Mapea una lista de Course -> CourseDto
        List<CourseDto> courseDtoList = iCourseMapper.coursesToCourseDtos(courseList);

        // Then
        assertNotNull(courseDtoList);
        assertEquals(courseList.size(), courseDtoList.size());
        assertEquals(courseList.get(2).getCourseId(), courseDtoList.get(2).getCourseId());
        assertEquals(courseList.get(1).getName(), courseDtoList.get(1).getName());
    }

}
