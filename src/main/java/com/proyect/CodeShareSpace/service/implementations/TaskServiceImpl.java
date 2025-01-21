package com.proyect.CodeShareSpace.service.implementations;

import com.proyect.CodeShareSpace.dto.task.CreateTaskDto;
import com.proyect.CodeShareSpace.dto.task.TaskDto;
import com.proyect.CodeShareSpace.exception.CourseNotFoundException;
import com.proyect.CodeShareSpace.exception.UserNotFoundException;
import com.proyect.CodeShareSpace.mapper.ITaskMapper;
import com.proyect.CodeShareSpace.persistence.model.Course;
import com.proyect.CodeShareSpace.persistence.model.Task;
import com.proyect.CodeShareSpace.persistence.model.User;
import com.proyect.CodeShareSpace.repository.CourseRepository;
import com.proyect.CodeShareSpace.repository.TaskRepository;
import com.proyect.CodeShareSpace.repository.UserRepository;
import com.proyect.CodeShareSpace.service.interfaces.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements ITaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ITaskMapper taskMapper;
    @Override
    public List<TaskDto> findTasksByCourseId(Long courseId) {
        List<Task> tasks = taskRepository.findByCourse_CourseId(courseId);
        return taskMapper.tasksToTasksDto(tasks);
    }
    @Override
    public TaskDto findById(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        return taskMapper.taskToTaskDto(task.get());
    }

    @Override
    public TaskDto createTask(CreateTaskDto createTaskDto) {
        Task task = taskMapper.mapToTask(createTaskDto);
        task.setStartDate(LocalDate.now());

        User teacher = userRepository.findById(createTaskDto.getTeacherId())
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado"));

        Course course = courseRepository.findById(createTaskDto.getCourseId())
                .orElseThrow(() -> new CourseNotFoundException("Curso no encontrado"));

        task.setCourse(course);
        task.setTeacher(teacher);

        return taskMapper.taskToTaskDto(taskRepository.save(task));
    }
}
