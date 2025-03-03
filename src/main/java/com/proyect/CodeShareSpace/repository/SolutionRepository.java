package com.proyect.CodeShareSpace.repository;

import com.proyect.CodeShareSpace.model.Solution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SolutionRepository extends JpaRepository<Solution,Long> {
    List<Solution> findByTask_TaskId(Long taskId);
    Optional<Solution> findByTask_TaskIdAndStudent_UserId(Long taskId, Long userId);
    boolean existsSolutionByTask_TaskIdAndStudent_UserId(Long taskId,Long userId);
}