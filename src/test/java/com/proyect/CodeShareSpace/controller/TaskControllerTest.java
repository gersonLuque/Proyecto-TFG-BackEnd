package com.proyect.CodeShareSpace.controller;

import com.proyect.CodeShareSpace.DataProvider;
import com.proyect.CodeShareSpace.dto.SolutionDto;
import com.proyect.CodeShareSpace.dto.TaskDto;
import com.proyect.CodeShareSpace.service.interfaces.ISolutionService;
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
public class TaskControllerTest {

    @Mock
    private ITaskService iTaskService;

    @Mock
    private ISolutionService iSolutionService;

    @InjectMocks
    private TaskController taskController;

    @Test
    public void testGetTaskById(){
        // Given
        Long id = 1L;
        TaskDto taskDto = DataProvider.newTaskDtoMock();

        // When
        Mockito.when(iTaskService.findById(Mockito.anyLong())).thenReturn(taskDto);
        ResponseEntity<TaskDto> responseTaskDto = taskController.getTaskById(id);
        // Then
        Mockito.verify(iTaskService).findById(Mockito.anyLong());
        assertNotNull(responseTaskDto);

        assertEquals(HttpStatus.OK, responseTaskDto.getStatusCode());
        assertEquals(5L, responseTaskDto.getBody().getTaskId());
        assertEquals("File handling and JDBC", responseTaskDto.getBody().getDescription());
        assertEquals("Jose Sala Gutierrez", responseTaskDto.getBody().getNameTeacher());
    }

    @Test
    public void testGetSolucionsByTaskId(){
        // Given
        Long id = 1L;
        List<SolutionDto> solutionDtoList = DataProvider.newSolutionDtoListMock();

        // When
        Mockito.when(iSolutionService.getSolutionsByTaskId(Mockito.anyLong())).thenReturn(solutionDtoList);
        List<SolutionDto> responseSolutionDtoList = iSolutionService.getSolutionsByTaskId(id);

        // Then
        Mockito.verify(iSolutionService).getSolutionsByTaskId(Mockito.anyLong());
        assertNotNull(responseSolutionDtoList);

        assertFalse(responseSolutionDtoList.isEmpty());
        assertEquals(3, responseSolutionDtoList.size());
        assertEquals(2L, responseSolutionDtoList.get(1).getSolutionId());
        assertTrue(responseSolutionDtoList.get(0).isAnonymous());
        assertFalse(responseSolutionDtoList.get(2).isAnonymous());
    }

}
