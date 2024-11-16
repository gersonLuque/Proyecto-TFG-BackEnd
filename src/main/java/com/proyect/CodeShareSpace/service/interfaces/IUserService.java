package com.proyect.CodeShareSpace.service.interfaces;

import com.proyect.CodeShareSpace.dto.UserDto;

import java.util.List;

public interface IUserService {
    List<UserDto> findAll();
    List<UserDto> findAllByCourseId(Long id);
    UserDto findById(Long id);
}
