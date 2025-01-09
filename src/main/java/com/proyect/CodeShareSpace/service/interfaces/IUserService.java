package com.proyect.CodeShareSpace.service.interfaces;

import com.proyect.CodeShareSpace.dto.user.UserDto;

import java.util.List;

public interface IUserService {
    List<UserDto> findAll();
    UserDto findById(Long id);
}
