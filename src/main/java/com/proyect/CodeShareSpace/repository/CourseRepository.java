package com.proyect.CodeShareSpace.repository;

import com.proyect.CodeShareSpace.dto.UserDto;
import com.proyect.CodeShareSpace.persistence.model.Course;
import com.proyect.CodeShareSpace.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
//    @Query("SELECT u.* FROM users u LEFT JOIN users_courses uc ON uc.user_id=u.user_id WHERE uc.course_id = :courseId")
//    List<User> findAllByCourseId(@Param("courseId") Long courseId);
    List<User> findUsersByCourseId(Long courseId);

}
