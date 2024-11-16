package com.proyect.CodeShareSpace.service.implementations;

import com.proyect.CodeShareSpace.dto.UserDto;
import com.proyect.CodeShareSpace.mapper.UserMapper;
import com.proyect.CodeShareSpace.persistence.model.User;
import com.proyect.CodeShareSpace.repository.UserRepository;
import com.proyect.CodeShareSpace.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        return userMapper.usersToUsersDto(users);
    }

    @Override
    public List<UserDto> findAllByCourseId(Long courseId) {
        List<User> usersByCourse = userRepository.findAllByCourseId(courseId);
        return userMapper.usersToUsersDto(usersByCourse);
    }

    @Override
    public UserDto findById(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return userMapper.userToUserDto(user);
    }
}
