package com.proyect.CodeShareSpace.service.interfaces;

import com.proyect.CodeShareSpace.dto.user.UserDto;
import com.proyect.CodeShareSpace.persistence.model.User;

import java.util.List;

public interface IUserService {
    List<UserDto> findAll();
    UserDto findById(Long id);
    User findUserByUsername(String username);
}
