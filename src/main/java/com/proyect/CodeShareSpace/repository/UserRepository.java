package com.proyect.CodeShareSpace.repository;

import com.proyect.CodeShareSpace.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findAllByCourseId(Long courseId);
}
