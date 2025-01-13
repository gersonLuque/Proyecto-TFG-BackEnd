package com.proyect.CodeShareSpace.mapper;

import com.proyect.CodeShareSpace.dto.UserBasicDto;
import com.proyect.CodeShareSpace.dto.UserDto;
import com.proyect.CodeShareSpace.persistence.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IUserMapper {

    UserDto userToUserDto(User user);
    User userDtoToUser(UserDto userDto);
    UserBasicDto mapToUserBasicDto(User user);
    List<UserDto> usersToUsersDto(List<User> users);

}
