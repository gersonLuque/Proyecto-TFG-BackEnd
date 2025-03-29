package com.proyect.CodeShareSpace.mappers;

import com.proyect.CodeShareSpace.dto.task.CreateTaskDto;
import com.proyect.CodeShareSpace.mapper.ITaskMapper;
import com.proyect.CodeShareSpace.model.Task;
import org.junit.jupiter.api.Test;
import com.proyect.CodeShareSpace.DataProvider;
import com.proyect.CodeShareSpace.dto.task.TaskDto;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskMapperTest {

    @Autowired
    private ITaskMapper iTaskMapper;

    @Test
    public void testTaskToTaskDto(){
        // Given
        Task task = DataProvider.newTaskMock();
        // When - se mapea Task -> TaskDto
        TaskDto taskDto = iTaskMapper.taskToTaskDto(task);
        // Then
        assertNotNull(taskDto);
        assertEquals(task.getTaskId(), taskDto.getTaskId());
        assertEquals(task.isVisible(), taskDto.isVisible());
        assertEquals(task.getCourse().getName(), taskDto.getCourseName());
        assertEquals(task.getTeacher().getCompleteName(), taskDto.getNameTeacher());
    }

//    @Test
//    public void testTaskDtoToTask(){
//        // Given
//        CreateTaskDto createTaskDto = DataProvider.newCreateTaskDto();
//        // When - se mapea TaskDto -> Task
//        Task task = iTaskMapper.mapToTask(createTaskDto);
//        // Then
//        assertNotNull(task);
//        assertEquals(task.getTeacher().getUserId(), createTaskDto.getTeacherId());
//        assertEquals(task.getCourse().getCourseId(), createTaskDto.getCourseId());
//        assertEquals(task.getTitle(), createTaskDto.getTitle());
//        assertEquals(task.getDescription(), createTaskDto.getDescription());
//    }

    @Test
    public void testTasksToTasksDto(){
        // Given
        List<Task> taskList = DataProvider.newTaskListMock();
        // When - se mapean Tasks -> List<TaskDto>
        List<TaskDto> taskDtoList = iTaskMapper.tasksToTasksDto(taskList);
        // Then
        assertNotNull(taskDtoList);
        assertEquals(taskDtoList.size(), taskList.size());
        assertEquals(taskDtoList.get(0).getTaskId(), taskList.get(0).getTaskId());
        assertEquals(taskDtoList.get(0).isVisible(), taskList.get(0).isVisible());
        assertEquals(taskDtoList.get(1).getCourseName(), taskList.get(1).getCourse().getName());
        assertEquals(taskDtoList.get(1).getDescription(), taskList.get(1).getDescription());

    }

}
