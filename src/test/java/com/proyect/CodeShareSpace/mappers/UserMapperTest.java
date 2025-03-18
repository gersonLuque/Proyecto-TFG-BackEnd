package com.proyect.CodeShareSpace.mappers;

import com.proyect.CodeShareSpace.DataProvider;
import com.proyect.CodeShareSpace.dto.user.UserDto;
import com.proyect.CodeShareSpace.mapper.IUserMapper;
import com.proyect.CodeShareSpace.model.Rol;
import com.proyect.CodeShareSpace.model.User;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
//public class UserMapperTest {
//
//    @Autowired
//    private IUserMapper iUserMapper;
//
//    @Test
//    public void testUserToUserDto() {
//        // Given
//        User user = DataProvider.newUserMock();
//        // When - se mapea User -> UserDto
//        UserDto userDto = iUserMapper.userToUserDto(user);
//        // Then
//        assertNotNull(userDto);
//        assertEquals(userDto.getUserId(), user.getUserId());
//        assertEquals(userDto.getRol(), user.getRol());
//        assertEquals(userDto.getCompleteName(), user.getCompleteName());
//    }
//}