package com.proyect.CodeShareSpace.mappers;

import com.proyect.CodeShareSpace.dto.CourseDto;
import com.proyect.CodeShareSpace.mapper.ICourseMapper;
import com.proyect.CodeShareSpace.persistence.model.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CourserMapperTest {

    private ICourseMapper iCourseMapper = Mappers.getMapper(ICourseMapper.class);


    @Test
    void testCourseToCourseDto() {
        // Crear un objeto Course para probar
        Course course = createTestCourse();

        // Mapear el Course a CourseDto
        CourseDto courseDto = iCourseMapper.courseToCourseDto(course);

        // Verificar que el mapeo es correcto
        assertNotNull(courseDto, "El CourseDto no debe ser null");
        assertEquals(course.getCourseId(),courseDto.getCourseId());

    }

    @Test
    void testCourseDtoToCourse() {
        // Crear un objeto CourseDto para probar
        CourseDto courseDto = createTestCourseDto();

        // Mapear el CourseDto a Course
        Course course = iCourseMapper.courseDtoToCourse(courseDto);

        // Verificar que el mapeo es correcto
        assertNotNull(course, "El Course no debe ser null");
    }

    // Método de utilidad para crear un Course de prueba
    private Course createTestCourse() {
        Course course = new Course();
        course.setCourseId(1L);
        course.setName("Matemáticas");
        course.setUsers(new HashSet<>());  // Crear un conjunto vacío de usuarios
        return course;
    }

    // Método de utilidad para crear un CourseDto de prueba
    private CourseDto createTestCourseDto() {
        CourseDto courseDto = new CourseDto();
        courseDto.setCourseId(1L);
        courseDto.setName("Matemáticas");
        return courseDto;
    }

}
