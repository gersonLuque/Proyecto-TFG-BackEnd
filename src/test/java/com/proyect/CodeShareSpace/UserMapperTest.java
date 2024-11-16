package com.proyect.CodeShareSpace;

import com.proyect.CodeShareSpace.dto.UserDto;
import com.proyect.CodeShareSpace.mapper.UserMapper;
import com.proyect.CodeShareSpace.persistence.model.Rol;
import com.proyect.CodeShareSpace.persistence.model.User;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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
        assertEquals(user.getCourses().size(), userDto.getCoursesName().size());
    }
    @Test
    public void testUserDtoToUser() {
        // Crear un objeto UserDto para probar
        UserDto userDto = new UserDto();
        userDto.setUserId(1L);
        userDto.setUsername("juanperez");
        userDto.setPassword("password123");
        userDto.setCompleteName("Juan Pérez");
        userDto.setRol(Rol.STUDENT);

        // Mapear el UserDto a User
        User user = userMapper.userDtoToUser(userDto);

        // Verificar que el mapeo es correcto
        assertNotNull(user);
        assertEquals(userDto.getUserId(), user.getUserId());
        assertEquals(userDto.getUsername(), user.getUsername());
        assertEquals(userDto.getPassword(), user.getPassword());
        assertEquals(userDto.getCompleteName(), user.getCompleteName());
        assertEquals(userDto.getRol(), user.getRol());
        assertEquals(userDto.getCoursesName().size(), user.getCourses().size());
    }

    @Test
    public void testUsersToUsersDto() {
        // Crear una lista de objetos User para probar
        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setUserId(1L);
        user1.setUsername("juanperez");
        user1.setPassword("password123");
        user1.setCompleteName("Juan Pérez");
        user1.setRol(Rol.STUDENT);
        user1.setCourses(new HashSet<>());  // Puedes agregar cursos si es necesario

        User user2 = new User();
        user2.setUserId(2L);
        user2.setUsername("maria");
        user2.setPassword("password456");
        user2.setCompleteName("María López");
        user2.setRol(Rol.TEACHER);
        user2.setCourses(new HashSet<>());

        users.add(user1);
        users.add(user2);

        // Mapear la lista de Users a la lista de UserDtos
        List<UserDto> userDtos = userMapper.usersToUsersDto(users);

        // Verificar que el mapeo es correcto
        assertNotNull(userDtos);
        assertEquals(users.size(), userDtos.size());

        // Verificar que los datos coinciden
        assertEquals(user1.getUserId(), userDtos.get(0).getUserId());
        assertEquals(user2.getUserId(), userDtos.get(1).getUserId());
    }
}
