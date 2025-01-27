package com.proyect.CodeShareSpace.repository;

import com.proyect.CodeShareSpace.persistence.model.File.FileTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileTaskRepository  extends JpaRepository<FileTask,Long> {
    List<FileTask> findByTask_TaskId(Long taskId);
}
