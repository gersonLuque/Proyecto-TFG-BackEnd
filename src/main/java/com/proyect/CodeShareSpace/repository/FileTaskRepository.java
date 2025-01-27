package com.proyect.CodeShareSpace.repository;

import com.proyect.CodeShareSpace.persistence.model.File.FileTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileTaskRepository  extends JpaRepository<FileTask,Long> {
    Optional<FileTask> findByTask_TaskId(Long taskId);
}
