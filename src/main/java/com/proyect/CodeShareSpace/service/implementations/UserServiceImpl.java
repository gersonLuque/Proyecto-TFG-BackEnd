package com.proyect.CodeShareSpace.service.implementations;

import com.proyect.CodeShareSpace.dto.UserDto;
import com.proyect.CodeShareSpace.mapper.UserMapper;
import com.proyect.CodeShareSpace.persistence.model.User;
import com.proyect.CodeShareSpace.repository.UserRepository;
import com.proyect.CodeShareSpace.service.interfaces.IUserService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;
    private UserMapper USER_MAPPER = UserMapper.INSTANCE;


    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        return USER_MAPPER.usersToUsersDto(users);
    }

    @Override
    public List<UserDto> findAllByCourseId(Long courseId) {
        List<User> usersByCourse = userRepository.findAllByCourseId(courseId);
        return USER_MAPPER.usersToUsersDto(usersByCourse);
    }

    @Override
    public UserDto findById(Long id) {
        try {
            User user = userRepository.findById(id).orElseThrow();
            System.out.println(user); // Verifica que el objeto no sea null
            UserDto userDto = USER_MAPPER.userToUserDto(user);
            System.out.println(userDto); // Verifica que el DTO se haya mapeado correctamente
            return userDto;
        } catch (Exception e) {
            System.out.println("User not found or error occurred: " + e.getMessage());
            return null; // O maneja el error como prefieras
        }
    }
}
