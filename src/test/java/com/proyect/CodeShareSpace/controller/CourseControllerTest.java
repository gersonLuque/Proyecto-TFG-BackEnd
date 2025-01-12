package com.proyect.CodeShareSpace.controller;

import com.proyect.CodeShareSpace.DataProvider;
import com.proyect.CodeShareSpace.dto.CourseDto;
import com.proyect.CodeShareSpace.dto.TaskDto;
import com.proyect.CodeShareSpace.dto.UserDto;
import com.proyect.CodeShareSpace.persistence.model.Course;
import com.proyect.CodeShareSpace.persistence.model.Task;
import com.proyect.CodeShareSpace.service.interfaces.ICourseService;
import com.proyect.CodeShareSpace.service.interfaces.ITaskService;
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

    @Mock
    private ITaskService iTaskService;

    @InjectMocks
    private CourseController courseController;

    @Test
    public void testGetAllCourses(){
        // Given
        List<CourseDto> mockCourses = DataProvider.newCoursesDTOListMock();

        // When
        Mockito.when(iCourseService.findAll()).thenReturn(mockCourses);
        ResponseEntity<List<CourseDto>> responseCourses = courseController.getAllCourses();

        // Then
        Mockito.verify(iCourseService).findAll();
        assertNotNull(responseCourses);
        assertNotNull(responseCourses.getBody());

        assertEquals(mockCourses.size(), responseCourses.getBody().size());
        assertEquals("Algoritmia", responseCourses.getBody().get(0).getName());
        assertEquals(HttpStatus.OK, responseCourses.getStatusCode());
    }

    @Test
    public void testGetUsersByCourse() {
        // Given
        Long courseId = 1L;  // Definir el ID del curso
        List<UserDto> mockUsers = DataProvider.usersToSearchMock();  // Simular la lista de usuarios esperada

        // When
        Mockito.when(iCourseService.findUsersByCourseId(Mockito.anyLong())).thenReturn(mockUsers);  // Simular la respuesta del servicio
        ResponseEntity<List<UserDto>> response = courseController.getUsersByCourse(courseId);

        // Then
        Mockito.verify(iCourseService).findUsersByCourseId(courseId);
        assertNotNull(response);
        assertNotNull(response.getBody());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockUsers.size(), response.getBody().size());
        assertEquals("cristianoRonaldo7", response.getBody().get(0).getUsername());
    }

    @Test
    public void testGetCourseById(){
        // Given
        Long courseDtoId = 1L;
        CourseDto courseDtoMock = DataProvider.newCourseDTOMock();

        // When
        Mockito.when(iCourseService.findById(Mockito.anyLong())).thenReturn(courseDtoMock);
        ResponseEntity<CourseDto> responseCourseDto = courseController.getCourseById(courseDtoId);

        // Then
        Mockito.verify(iCourseService).findById(Mockito.anyLong());
        assertNotNull(responseCourseDto);

        assertEquals(HttpStatus.OK, responseCourseDto.getStatusCode());
        assertEquals(8L, responseCourseDto.getBody().getCourseId());
        assertEquals("Matemáticas", responseCourseDto.getBody().getName());
    }

    @Test
    public void testGetCoursesByUserId(){
        // Given
        Long userId = 1L;
        List<CourseDto> coursesDtoListMock = DataProvider.newCoursesDTOListMock();

        // When
        Mockito.when(iCourseService.findByUserId(Mockito.anyLong())).thenReturn(coursesDtoListMock);
        ResponseEntity<List<CourseDto>> responseCoursesDto = courseController.getCoursesByUserId(userId);

        // Then
        Mockito.verify(iCourseService).findByUserId(Mockito.anyLong());
        assertNotNull(responseCoursesDto);

        assertEquals(HttpStatus.OK, responseCoursesDto.getStatusCode());
        assertEquals("Algoritmia", responseCoursesDto.getBody().get(0).getName());
        assertEquals("Organización y Gestion", responseCoursesDto.getBody().get(2).getName());
        assertEquals(4, responseCoursesDto.getBody().size());
    }

    @Test
    public void testGetTaskByCourseId(){
        // Given
        Long courseId = 8L;
        List<TaskDto> taskListMock = DataProvider.newTaskDtoListMock();

        // When
        Mockito.when(iTaskService.findTasksByCourseId(Mockito.anyLong())).thenReturn(taskListMock);
        ResponseEntity<List<TaskDto>> responseTaskList = courseController.getTaskByCourseId(courseId);

        // Then
        Mockito.verify(iTaskService).findTasksByCourseId(Mockito.anyLong());
        assertNotNull(responseTaskList);

        assertEquals(HttpStatus.OK, responseTaskList.getStatusCode());
        assertEquals(2L, responseTaskList.getBody().get(1).getTaskId());
        assertEquals("Complete the course syllabus", responseTaskList.getBody().get(1).getDescription());
    }

}