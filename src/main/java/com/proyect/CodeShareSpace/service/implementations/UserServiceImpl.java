package com.proyect.CodeShareSpace.service.implementations;

import com.proyect.CodeShareSpace.dto.user.UserDto;
import com.proyect.CodeShareSpace.mapper.UserMapper;
import com.proyect.CodeShareSpace.persistence.model.User;
import com.proyect.CodeShareSpace.repository.UserRepository;
import com.proyect.CodeShareSpace.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public UserDto findById(Long id) {
        try {
            User user = userRepository.findById(id).orElseThrow();
            return userMapper.userToUserDto(user);
        } catch (Exception e) {
            System.out.println("User not found or error occurred: " + e.getMessage());
            return null;
        }
    }
}
