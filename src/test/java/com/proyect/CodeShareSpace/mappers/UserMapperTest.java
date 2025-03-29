package com.proyect.CodeShareSpace.mappers;

import com.proyect.CodeShareSpace.DataProvider;
import com.proyect.CodeShareSpace.dto.user.UserBasicDto;
import com.proyect.CodeShareSpace.dto.user.UserCreateDto;
import com.proyect.CodeShareSpace.dto.user.UserDto;
import com.proyect.CodeShareSpace.mapper.IUserMapper;
import com.proyect.CodeShareSpace.model.Rol;
import com.proyect.CodeShareSpace.model.User;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserMapperTest {

    @Autowired
    private IUserMapper iUserMapper;

    @Test
    public void testUserToUserDto() {
        // Given
        User user = DataProvider.newUserMock();
        // When - se mapea User -> UserDto
        UserDto userDto = iUserMapper.userToUserDto(user);
        // Then
        assertNotNull(userDto);
        assertEquals(userDto.getUserId(), user.getUserId());
        assertEquals(userDto.getRol(), user.getRol());
        assertEquals(userDto.getCompleteName(), user.getCompleteName());
    }

    @Test
    public void testUserDtoToUser() {
        // Given
        UserDto userDto = DataProvider.newUserDtoMock();
        // When - se mapea UserDto -> User
        User user = iUserMapper.userDtoToUser(userDto);
        // Then
        assertNotNull(user);
        assertEquals(user.getUserId(), userDto.getUserId());
        assertEquals(user.getRol(), userDto.getRol());
        assertEquals(user.getCompleteName(), userDto.getCompleteName());
    }

    @Test
    public void testUserToUserBasicDto(){
        // Given
        User user = DataProvider.newUserMock();
        // When - se mapea User -> UserBasicDto
        UserBasicDto userBasicDto = iUserMapper.userToUserBasicDto(user);
        // Then
        assertNotNull(userBasicDto);
        assertEquals(userBasicDto.getUserId(), user.getUserId());
        assertEquals(userBasicDto.getCompleteName(), user.getCompleteName());
        assertEquals(userBasicDto.getRol(), user.getRol());
    }

    @Test
    public void testUserCreateDtoToUser(){
        // Given
        UserCreateDto userBasicDto = DataProvider.newUserCreateDtoMock();
        // When - se mapea UserBasicDto -> User
        User user = iUserMapper.userCreateToUser(userBasicDto);
        // Then
        assertNotNull(user);
        assertEquals(user.getCompleteName(), userBasicDto.getCompleteName());
        assertEquals(user.getRol(), userBasicDto.getRol());
    }

    @Test
    public void testUsersToUsersDto(){
        // Given
        List<User> userList = DataProvider.newUsersListMock();
        // When - se mapean varios User -> UserDto
        List<UserDto> usersDto = iUserMapper.usersToUsersDto(userList);
        // Then
        assertNotNull(usersDto);
        assertEquals(usersDto.size(), userList.size());
        assertNull(usersDto.get(0).getRol());
        assertEquals(usersDto.get(1).getRol(), userList.get(1).getRol());
    }

}