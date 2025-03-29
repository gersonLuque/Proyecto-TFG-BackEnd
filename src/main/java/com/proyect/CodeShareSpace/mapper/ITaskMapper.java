package com.proyect.CodeShareSpace.mapper;

import com.proyect.CodeShareSpace.dto.task.CreateTaskDto;
import com.proyect.CodeShareSpace.dto.task.TaskDto;
import com.proyect.CodeShareSpace.model.Task;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = IFileMapper.class,injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ITaskMapper {

    @Mapping(source = "course.name",target = "courseName")
    @Mapping(source = "teacher.completeName", target = "nameTeacher")
    TaskDto taskToTaskDto(Task task);
    Task mapToTask(CreateTaskDto createTaskDto);
    List<TaskDto> tasksToTasksDto(List<Task> tasks);

}
