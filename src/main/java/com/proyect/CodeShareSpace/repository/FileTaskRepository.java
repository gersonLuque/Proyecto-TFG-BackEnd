package com.proyect.CodeShareSpace.repository;

import com.proyect.CodeShareSpace.model.File.FileTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileTaskRepository  extends JpaRepository<FileTask,Long> {
    List<FileTask> findByTask_TaskId(Long taskId);
}
