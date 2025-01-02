package com.proyect.CodeShareSpace.repository;

import com.proyect.CodeShareSpace.persistence.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {

}
