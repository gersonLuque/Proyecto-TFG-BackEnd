package com.proyect.CodeShareSpace;

import com.proyect.CodeShareSpace.dto.UserDto;
import com.proyect.CodeShareSpace.mapper.UserMapper;
import com.proyect.CodeShareSpace.persistence.model.Rol;
import com.proyect.CodeShareSpace.persistence.model.User;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserMapperTest {
    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);
    @Test
    public void testUserToUserDto() {
        // Crear un objeto User para probar
        User user = new User();
        user.setUserId(1L);
        user.setUsername("juanperez");
        user.setPassword("password123");
        user.setCompleteName("Juan Pérez");
        user.setRol(Rol.STUDENT);
        user.setCourses(new HashSet<>());  // Puedes agregar cursos si es necesario

        // Mapear el User a UserDto
        UserDto userDto = userMapper.userToUserDto(user);

        // Verificar que el mapeo es correcto
        assertNotNull(userDto);
        assertEquals(user.getUserId(), userDto.getUserId());
        assertEquals(user.getUsername(), userDto.getUsername());
        assertEquals(user.getPassword(), userDto.getPassword());
        assertEquals(user.getCompleteName(), userDto.getCompleteName());
        assertEquals(user.getRol(), userDto.getRol());
        assertEquals(user.getCourses().size(), userDto.getCourses().size());
    }
}
