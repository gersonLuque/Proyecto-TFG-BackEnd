package com.proyect.CodeShareSpace.repository;

import com.proyect.CodeShareSpace.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findByCourse_CourseId(Long courseId);
}
