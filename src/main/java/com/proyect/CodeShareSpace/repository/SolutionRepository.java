package com.proyect.CodeShareSpace.repository;

import com.proyect.CodeShareSpace.persistence.model.Solution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolutionRepository extends JpaRepository<Solution,Long> {
    List<Solution> findByTask_TaskId(Long taskId);
}