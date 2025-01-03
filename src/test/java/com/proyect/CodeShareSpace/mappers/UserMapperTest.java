package com.proyect.CodeShareSpace.mappers;

import com.proyect.CodeShareSpace.DataProvider;
import com.proyect.CodeShareSpace.dto.UserDto;
import com.proyect.CodeShareSpace.mapper.UserMapper;
import com.proyect.CodeShareSpace.persistence.model.Rol;
import com.proyect.CodeShareSpace.persistence.model.User;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class UserMapperTest {

    @Mock
    private UserMapper iUserMapper;
    @Test
    public void testUserToUserDto() {
        // Given
        User user = DataProvider.newUserMock();
        UserDto expectedUserDto = DataProvider.newUserDtoMock(); // Guarda el DTO esperado para comparar

        // When
        Mockito.when(iUserMapper.userToUserDto(any(User.class))).thenReturn(expectedUserDto);
        UserDto UserDto = iUserMapper.userToUserDto(user);

        // Then
        Mockito.verify(iUserMapper).userToUserDto(user); // Verifica con la instancia real de User
        assertNotNull(UserDto);
        assertEquals(expectedUserDto, UserDto); // Compara objetos usando equals() (si está implementado) o compara campo por campo si no

        assertEquals(expectedUserDto.getUserId(), UserDto.getUserId());
        assertEquals(expectedUserDto.getUsername(), UserDto.getUsername());
        assertEquals(expectedUserDto.getPassword(), UserDto.getPassword());
        assertEquals(expectedUserDto.getCompleteName(), UserDto.getCompleteName());
        assertEquals(expectedUserDto.getRol(), UserDto.getRol());
        assertEquals(expectedUserDto.getCourses().size(), UserDto.getCourses().size());
    }

    @Test
    public void testUserDtoToUser() {
        // Given
        UserDto userDto = DataProvider.newUserDtoMock(); // DTO de entrada
        User expectedUser = DataProvider.newUserMock(); // Entidad esperada

        // When
        Mockito.when(iUserMapper.userDtoToUser(any(UserDto.class))).thenReturn(expectedUser);
        User user = iUserMapper.userDtoToUser(userDto);

        // Then
        Mockito.verify(iUserMapper).userDtoToUser(any(UserDto.class)); // Verifica que se llamó al método
        assertNotNull(user, "El objeto User no debería ser nulo");
        assertInstanceOf(User.class, user, "El objeto debería ser de tipo User");
        assertEquals(1L, user.getUserId(), "El UserId debería ser 1L");
        assertEquals("anaFrank08", user.getUsername(), "El username debería ser 'anaFrank08'");
        assertEquals("cacahuete", user.getPassword(), "El password debería ser 'cacahuete'");
        assertEquals("Ana Cisneros", user.getCompleteName(), "El nombre completo debería ser 'Ana Cisneros'");
        assertEquals(Rol.TEACHER, user.getRol(), "El rol debería ser TEACHER");
        assertTrue(user.getCourses().isEmpty(), "La lista de cursos debería estar vacía");
    }

}
