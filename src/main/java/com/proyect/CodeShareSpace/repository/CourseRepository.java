package com.proyect.CodeShareSpace.repository;

import com.proyect.CodeShareSpace.model.Course;
import com.proyect.CodeShareSpace.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("SELECT u FROM User u JOIN u.courses c WHERE c.courseId = :courseId")
    List<User> findUsersByCourseId(@Param("courseId") Long courseId);
    List<Course> findByUsers_UserId(Long userId);
}
