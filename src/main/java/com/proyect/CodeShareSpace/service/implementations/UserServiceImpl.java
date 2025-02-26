package com.proyect.CodeShareSpace.service.implementations;

import com.proyect.CodeShareSpace.dto.course.CourseDto;
import com.proyect.CodeShareSpace.dto.user.UserCreateDto;
import com.proyect.CodeShareSpace.dto.user.UserDto;
import com.proyect.CodeShareSpace.dto.user.UserUpdateDto;
import com.proyect.CodeShareSpace.exception.CourseNotFoundException;
import com.proyect.CodeShareSpace.exception.UserExistException;
import com.proyect.CodeShareSpace.exception.UserNotFoundException;
import com.proyect.CodeShareSpace.mapper.IUserMapper;
import com.proyect.CodeShareSpace.model.Course;
import com.proyect.CodeShareSpace.model.File.FileSolution;
import com.proyect.CodeShareSpace.model.User;
import com.proyect.CodeShareSpace.repository.CourseRepository;
import com.proyect.CodeShareSpace.repository.UserRepository;
import com.proyect.CodeShareSpace.service.interfaces.IStorageService;
import com.proyect.CodeShareSpace.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private IStorageService iStorageService;

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
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado"));
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public UserDto updateUser(UserUpdateDto userDto){
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

    @Override
    public void deleteUserById(Long userId) {
        User user = findUserById(userId);

        // se intenta borrar primero los ficheros relacionados con el usuario
        // si hay una excepcion en s3 no se eliminaran los datos
        List<FileSolution> fileSolutions = getFileSolutionsFromUser(user);
        iStorageService.delete(fileSolutions);

        userRepository.delete(user);
    }

    private List<FileSolution> getFileSolutionsFromUser(User user) {
        return user.getSolutions().stream()
                .flatMap(solution -> solution.getFileSolutions().stream())
                .collect(Collectors.toList());
    }

    private List<Course> getCoursesFromDto(List<CourseDto> coursesDto) {
        return coursesDto.stream()
                .map(courseDto -> courseRepository.findById(courseDto.getCourseId())
                        .orElseThrow(() -> new CourseNotFoundException("Error al encontrar el curso")))
                .collect(Collectors.toList());
    }
}
