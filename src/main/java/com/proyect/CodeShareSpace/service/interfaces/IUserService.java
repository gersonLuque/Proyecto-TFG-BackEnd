package com.proyect.CodeShareSpace.service.interfaces;

import com.proyect.CodeShareSpace.dto.user.UserCreateDto;
import com.proyect.CodeShareSpace.dto.user.UserDto;
import com.proyect.CodeShareSpace.persistence.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<UserDto> findAll();
    UserDto findById(Long id);
    Optional<User> findUserByUsername(String username);

    UserDto updateUser(UserDto userDto);

    UserDto createUser(UserCreateDto userCreateDto);
}
