package com.proyect.CodeShareSpace.controller;

import com.proyect.CodeShareSpace.DataProvider;
import com.proyect.CodeShareSpace.dto.course.CourseDto;
import com.proyect.CodeShareSpace.dto.task.TaskDto;
import com.proyect.CodeShareSpace.dto.user.UserDto;
import com.proyect.CodeShareSpace.service.interfaces.ICourseService;
import com.proyect.CodeShareSpace.service.interfaces.ITaskService;
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
        List<CourseDto> courseDtoList = DataProvider.newCoursesDTOListMock();

        // When
        Mockito.when(iCourseService.findAll()).thenReturn(courseDtoList);
        ResponseEntity<List<CourseDto>> responseCourseDtoList = courseController.getAllCourses();

        // Then
        Mockito.verify(iCourseService).findAll();
        assertNotNull(responseCourseDtoList);
        assertEquals(HttpStatus.OK, responseCourseDtoList.getStatusCode());
        assertNotNull(responseCourseDtoList.getBody());
        assertEquals(3, responseCourseDtoList.getBody().size());
        assertEquals("Programación", responseCourseDtoList.getBody().get(0).getName());
        assertEquals(3L, responseCourseDtoList.getBody().get(2).getCourseId());
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
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(mockUsers.size(), response.getBody().size());

        assertEquals("cristianoRonaldo7", response.getBody().get(0).getUsername());
    }

    @Test
    public void testGetCourseById() {
        // Given
        Long courseId = 1L;  // Definir el ID del curso
        CourseDto courseDto = DataProvider.newCourseDTOMock();  // Simular la lista de usuarios esperada

        // When
        Mockito.when(iCourseService.findById(Mockito.anyLong())).thenReturn(courseDto);  // Simular la respuesta del servicio
        ResponseEntity<CourseDto> responseCourseDto = courseController.getCourseById(courseId);

        // Then
        Mockito.verify(iCourseService).findById(Mockito.anyLong());
        assertNotNull(responseCourseDto);
        assertEquals(HttpStatus.OK, responseCourseDto.getStatusCode());
        assertNotNull(responseCourseDto.getBody());
        assertEquals(8L, responseCourseDto.getBody().getCourseId());
        assertEquals("Matemáticas", responseCourseDto.getBody().getName());
    }

    @Test
    public void testGetCoursesByUserId(){
        // Given
        Long id = 1L;
        List<CourseDto> courseDtoList = DataProvider.newCoursesDTOListMock();

        // When
        Mockito.when(iCourseService.findByUserId(Mockito.anyLong())).thenReturn(courseDtoList);
        ResponseEntity<List<CourseDto>> responseCourseDtoList = courseController.getCoursesByUserId(id);

        // Then
        Mockito.verify(iCourseService).findByUserId(Mockito.anyLong());
        assertNotNull(responseCourseDtoList);
        assertEquals(HttpStatus.OK, responseCourseDtoList.getStatusCode());
        assertEquals(3, responseCourseDtoList.getBody().size());
        assertEquals(2L, responseCourseDtoList.getBody().get(1).getCourseId());
        assertEquals("Procesos y Servicios", responseCourseDtoList.getBody().get(1).getName());
    }

    @Test
    public void testGetTaskByCourseId(){
        // Given
        Long taskId = 40L;
        List<TaskDto> taskDtoList = DataProvider.newTaskDtoListMock();

        // When
        Mockito.when(iTaskService.findTasksByCourseId(Mockito.anyLong(),Mockito.anyLong())).thenReturn(taskDtoList);
        ResponseEntity<List<TaskDto>> responseTaskDtoList = courseController.getTaskByCourseId(taskId,1L);

        // Then
//        Mockito.verify(iTaskService).findTasksByCourseId(Mockito.anyLong(),1L);
        assertNotNull(responseTaskDtoList);
        assertEquals(4, responseTaskDtoList.getBody().size());
        assertEquals("Complete the course syllabus", responseTaskDtoList.getBody().get(1).getDescription());
        assertEquals(3L, responseTaskDtoList.getBody().get(2).getTaskId());
    }

//    @Test
//    public void testDeleteCourseById(){
//        // Given
//        Long courseId = 3L;
//
//        // When
//        Mockito.doNothing().when(iCourseService).deleteCourseById(Mockito.anyLong());
//        ResponseEntity<Void> response = courseController.deleteCourseById(courseId);
//
//        // Then
//        Mockito.verify(iCourseService).deleteCourseById(Mockito.anyLong());
//        assertNotNull(response);
//        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
//    }


}