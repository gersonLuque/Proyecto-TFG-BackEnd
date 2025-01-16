package com.proyect.CodeShareSpace.mappers;

import com.proyect.CodeShareSpace.mapper.ICourseMapper;
import com.proyect.CodeShareSpace.mapper.ITaskMapper;
import com.proyect.CodeShareSpace.persistence.model.Course;
import com.proyect.CodeShareSpace.persistence.model.Task;
import org.junit.jupiter.api.Test;
import com.proyect.CodeShareSpace.DataProvider;
import com.proyect.CodeShareSpace.dto.TaskDto;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

public class TaskMapperTest {

    private ITaskMapper iTaskMapper = Mappers.getMapper(ITaskMapper.class);

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

    @Test
    public void testTaskDtoToTask(){
        // TODO
    }

    @Test
    public void testTasksToTasksDto(){
        // TODO
    }

}
