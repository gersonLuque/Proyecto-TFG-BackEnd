package com.proyect.CodeShareSpace.repository;

import com.proyect.CodeShareSpace.persistence.model.File.FileSolution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileSolutionRepository extends JpaRepository<FileSolution,Long> {

}
