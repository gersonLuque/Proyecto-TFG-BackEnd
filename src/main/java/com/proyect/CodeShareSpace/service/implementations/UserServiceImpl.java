package com.proyect.CodeShareSpace.service.implementations;

import com.proyect.CodeShareSpace.dto.user.UserCreateDto;
import com.proyect.CodeShareSpace.dto.user.UserDto;
import com.proyect.CodeShareSpace.exception.UserExistException;
import com.proyect.CodeShareSpace.mapper.IUserMapper;
import com.proyect.CodeShareSpace.persistence.model.User;
import com.proyect.CodeShareSpace.repository.UserRepository;
import com.proyect.CodeShareSpace.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;
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
        try {
            User user = userRepository.findById(id).orElseThrow();
            return IUserMapper.userToUserDto(user);
        } catch (Exception e) {
            System.out.println("User not found or error occurred: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public UserDto createUser(UserCreateDto userCreateDto) {

        if (findUserByUsername(userCreateDto.getUsername()).isPresent())
            throw new UserExistException();

        System.out.println("USERCRETEDTO: "+ userCreateDto);
        User user = IUserMapper.userCreateToUser(userCreateDto);

        System.out.println("USER : "+user);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return IUserMapper.userToUserDto(userRepository.save(user));
    }
}
