package com.proyect.CodeShareSpace.service.implementations;

import com.proyect.CodeShareSpace.dto.CourseCreateDto;
import com.proyect.CodeShareSpace.dto.CourseDto;
import com.proyect.CodeShareSpace.dto.user.UserDto;
import com.proyect.CodeShareSpace.mapper.ICourseMapper;
import com.proyect.CodeShareSpace.mapper.IUserMapper;
import com.proyect.CodeShareSpace.persistence.model.Course;
import com.proyect.CodeShareSpace.persistence.model.User;
import com.proyect.CodeShareSpace.repository.CourseRepository;
import com.proyect.CodeShareSpace.service.interfaces.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private IUserMapper IUserMapper;
    @Autowired
    private ICourseMapper iCourseMapper;

    @Override
    public List<UserDto> findUsersByCourseId(Long courseId) {
        List<User> users = courseRepository.findUsersByCourseId(courseId);
        return IUserMapper.usersToUsersDto(users);
    }

    @Override
    public CourseDto findById(Long courseId) {
        Optional<Course> course = courseRepository.findById(courseId);
        return iCourseMapper.courseToCourseDto(course.get());
    }

    @Override
    public List<CourseDto> findAll() {
        return iCourseMapper.coursesToCourseDtos(courseRepository.findAll());
    }

    @Override
    public List<CourseDto> findByUserId(Long userId) {
        List<Course> courses = courseRepository.findByUsers_UserId(userId);
        return iCourseMapper.coursesToCourseDtos(courses);
    }

    @Override
    public CourseDto createCourse(CourseCreateDto courseCreateDto) {
        Course course = new Course();
        course.setName(courseCreateDto.getName());
        Course courseCreated = courseRepository.save(course);
        return iCourseMapper.courseToCourseDto(courseRepository.save(course));
    }
}
