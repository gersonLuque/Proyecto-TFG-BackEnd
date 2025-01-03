package com.proyect.CodeShareSpace.controller;

import com.proyect.CodeShareSpace.DataProvider;
import com.proyect.CodeShareSpace.dto.UserDto;
import com.proyect.CodeShareSpace.service.interfaces.ICourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CourseControllerTest {

    @Mock
    private ICourseService iCourseService;

    @InjectMocks
    private CourseController courseController;

    @Test
    public void testGetUsersByCourse() {
        // Given
        Long courseId = 1L;  // Definir el ID del curso
        List<UserDto> mockUsers = DataProvider.usersToSearchMock();  // Simular la lista de usuarios esperada

        // When
        Mockito.when(iCourseService.findUsersByCourseId(courseId)).thenReturn(mockUsers);  // Simular la respuesta del servicio
        ResponseEntity<List<UserDto>> response = courseController.getUsersByCourse(courseId);

        // Then
        Mockito.verify(iCourseService).findUsersByCourseId(courseId);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(mockUsers.size(), response.getBody().size());

        assertEquals("cristianoRonaldo7", response.getBody().get(0).getUsername());
    }
}