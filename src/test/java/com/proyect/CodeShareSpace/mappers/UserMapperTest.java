package com.proyect.CodeShareSpace.mappers;

import com.proyect.CodeShareSpace.DataProvider;
import com.proyect.CodeShareSpace.dto.user.UserDto;
import com.proyect.CodeShareSpace.mapper.IUserMapper;
import com.proyect.CodeShareSpace.model.User;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import static org.junit.jupiter.api.Assertions.*;

public class UserMapperTest {

//    private IUserMapper iUserMapper = Mappers.getMapper(IUserMapper.class);
//
//    @Test
//    public void testUserToUserDto() {
//        // Given
//        User user = DataProvider.newUserMock();
//
//        // When - se mapea User -> UserDto
//        UserDto userDto = iUserMapper.userToUserDto(user);
//
//        // Then
//        assertNotNull(userDto);
//        assertEquals(userDto.getUserId(), user.getUserId());
//        assertEquals(userDto.getRol(), user.getRol());
//        assertEquals(userDto.getPassword(), user.getPassword());
//        assertEquals(userDto.getCompleteName(), user.getCompleteName());
//        assertEquals(userDto.getCourses(), user.getCourses());
//    }
//
//    @Test
//    public void testUserDtoToUser() {
//        // Given
//        UserDto userDto = DataProvider.newUserDtoMock(); // DTO de entrada
//
//        // When - se mapea UserDto -> User
//        User user = iUserMapper.userDtoToUser(userDto);
//
//        // Then
//        assertNotNull(user);
//        assertEquals(user.getUserId(), userDto.getUserId());
//        assertEquals(user.getRol(), userDto.getRol());
//        assertEquals(user.getPassword(), userDto.getPassword());
//        assertEquals(user.getCompleteName(), userDto.getCompleteName());
//        assertEquals(user.getCourses(), userDto.getCourses());
//    }

    @Test
    public void testMapToUserBasicDto(){
        // TODO
    }

    @Test
    public void testUsersToUsersDto(){
        // TODO
    }

}
