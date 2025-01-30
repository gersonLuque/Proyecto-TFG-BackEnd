package com.proyect.CodeShareSpace.service.implementations;

import com.proyect.CodeShareSpace.dto.course.CourseDto;
import com.proyect.CodeShareSpace.dto.user.UserCreateDto;
import com.proyect.CodeShareSpace.dto.user.UserDto;
import com.proyect.CodeShareSpace.exception.CourseNotFoundException;
import com.proyect.CodeShareSpace.exception.UserExistException;
import com.proyect.CodeShareSpace.mapper.IUserMapper;
import com.proyect.CodeShareSpace.model.Course;
import com.proyect.CodeShareSpace.model.User;
import com.proyect.CodeShareSpace.repository.CourseRepository;
import com.proyect.CodeShareSpace.repository.UserRepository;
import com.proyect.CodeShareSpace.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private IUserMapper IUserMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        return IUserMapper.usersToUsersDto(users);
    }

    @Override
    public UserDto findById(Long id) {
        User user = findUserById(id);
        return IUserMapper.userToUserDto(user);
    }

    private User findUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        return user;
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public UserDto updateUser(UserDto userDto){
        User user = findUserById(userDto.getUserId());
        user.setCompleteName(userDto.getCompleteName());
        List<Course> courses = getCoursesFromDto(userDto.getCourses());
        user.setCourses(courses);
        return IUserMapper.userToUserDto(userRepository.save(user));
    }

    @Override
    public UserDto createUser(UserCreateDto userCreateDto) {

        if (findUserByUsername(userCreateDto.getUsername()).isPresent())
            throw new UserExistException("El usuario ya esta registrado");

        List<Course> courseList = getCoursesFromDto(userCreateDto.getCourses());
        User user = IUserMapper.userCreateToUser(userCreateDto);

        user.setCourses(courseList);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return IUserMapper.userToUserDto(userRepository.save(user));
    }

    private List<Course> getCoursesFromDto(List<CourseDto> coursesDto) {
        return coursesDto.stream()
                .map(courseDto -> courseRepository.findById(courseDto.getCourseId())
                        .orElseThrow(() -> new CourseNotFoundException("Error al encontrar el curso")))
                .collect(Collectors.toList());
    }
}
