package com.proyect.CodeShareSpace.mappers;

import com.proyect.CodeShareSpace.mapper.ITaskMapper;
import com.proyect.CodeShareSpace.model.Task;
import org.junit.jupiter.api.Test;
import com.proyect.CodeShareSpace.DataProvider;
import com.proyect.CodeShareSpace.dto.task.TaskDto;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskMapperTest {

//    @Autowired
//    private ITaskMapper iTaskMapper;
//
//    @Test
//    public void testTaskToTaskDto(){
//        // Given
//        Task task = DataProvider.newTaskMock();
//
//        // When - se mapea Task -> TaskDto
//        TaskDto taskDto = iTaskMapper.taskToTaskDto(task);
//
//        // Then
//        assertNotNull(taskDto);
//        assertEquals(task.getTaskId(), taskDto.getTaskId());
//        assertEquals(task.isVisible(), taskDto.isVisible());
//        assertEquals(task.getCourse().getName(), taskDto.getCourseName());
//        assertEquals(task.getTeacher().getCompleteName(), taskDto.getNameTeacher());
//    }
//
//    @Test
//    public void testTaskDtoToTask(){
//        // TODO
//    }
//
//    @Test
//    public void testTasksToTasksDto(){
//        // TODO
//    }

}
