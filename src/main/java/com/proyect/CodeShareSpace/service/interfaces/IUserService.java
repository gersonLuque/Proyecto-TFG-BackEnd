package com.proyect.CodeShareSpace.service.interfaces;

import com.proyect.CodeShareSpace.dto.user.UserCreateDto;
import com.proyect.CodeShareSpace.dto.user.UserDto;
import com.proyect.CodeShareSpace.dto.user.UserUpdateDto;
import com.proyect.CodeShareSpace.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<UserDto> findAll();
    UserDto findById(Long id);
    Optional<User> findUserByUsername(String username);

    UserDto updateUser(UserUpdateDto userDto);

    UserDto createUser(UserCreateDto userCreateDto);

    void deleteUserById(Long userId);
}
