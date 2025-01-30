package com.proyect.CodeShareSpace.repository;

import com.proyect.CodeShareSpace.model.File.FileSolution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileSolutionRepository extends JpaRepository<FileSolution,Long> {

}
