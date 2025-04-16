package com.proyect.CodeShareSpace.mapper;

import com.proyect.CodeShareSpace.dto.user.UserBasicDto;
import com.proyect.CodeShareSpace.dto.user.UserCreateDto;
import com.proyect.CodeShareSpace.dto.user.UserDto;
import com.proyect.CodeShareSpace.model.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = ICourseMapper.class,injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface IUserMapper {

    UserDto userToUserDto(User user);
    User userDtoToUser(UserDto userDto);
    UserBasicDto userToUserBasicDto(User user);
    User userCreateToUser(UserCreateDto userCreateDto);
    List<UserDto> usersToUsersDto(List<User> users);

}
