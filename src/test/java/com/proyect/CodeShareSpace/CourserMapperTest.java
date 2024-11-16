package com.proyect.CodeShareSpace;

import com.proyect.CodeShareSpace.persistence.model.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

public class CourserMapperTest {

    private ICourseMapper iCourseMapper;

    @BeforeEach
    void setUp() {
        // Inicializamos el mapper antes de cada test
        courseMapper = iCourseMapper.INSTANCE;
    }

    @Test
    void testCourseToCourseDto() {
        // Crear un objeto Course para probar
        Course course = createTestCourse();

        // Mapear el Course a CourseDto
        CourseDto courseDto = courseMapper.courseToCourseDto(course);

        // Verificar que el mapeo es correcto
        assertNotNull(courseDto, "El CourseDto no debe ser null");
        assertEquals(course.getCourseId(), courseDto.getCourseId(), "El ID del curso debe coincidir");
        assertEquals(course.getName(), courseDto.getName(), "El nombre del curso debe coincidir");
        assertEquals(course.getUsers().size(), courseDto.getUsers().size(), "El número de usuarios debe coincidir");
    }

    @Test
    void testCourseDtoToCourse() {
        // Crear un objeto CourseDto para probar
        CourseDto courseDto = createTestCourseDto();

        // Mapear el CourseDto a Course
        Course course = courseMapper.courseDtoToCourse(courseDto);

        // Verificar que el mapeo es correcto
        assertNotNull(course, "El Course no debe ser null");
        assertEquals(courseDto.getCourseId(), course.getCourseId(), "El ID del curso debe coincidir");
        assertEquals(courseDto.getName(), course.getName(), "El nombre del curso debe coincidir");
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
        courseDto.setUsers(new HashSet<>());  // Crear un conjunto vacío de usuarios
        return courseDto;
    }

}
