package com.proyect.CodeShareSpace.service.implementations;

import com.proyect.CodeShareSpace.dto.UserDto;
import com.proyect.CodeShareSpace.mapper.IUserMapper;
import com.proyect.CodeShareSpace.persistence.model.User;
import com.proyect.CodeShareSpace.repository.UserRepository;
import com.proyect.CodeShareSpace.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private IUserMapper IUserMapper;

    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        return IUserMapper.usersToUsersDto(users);
    }

    @Override
    public UserDto findById(Long id) {
        try {
            User user = userRepository.findById(id).orElseThrow();
            return IUserMapper.userToUserDto(user);
        } catch (Exception e) {
            System.out.println("User not found or error occurred: " + e.getMessage());
            return null;
        }
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("usuario no encontrado"));
    }
}
