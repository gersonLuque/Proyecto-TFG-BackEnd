package com.proyect.CodeShareSpace.controller;

import com.proyect.CodeShareSpace.DataProvider;
import com.proyect.CodeShareSpace.dto.user.UserDto;
import com.proyect.CodeShareSpace.persistence.model.Rol;
import com.proyect.CodeShareSpace.service.interfaces.IUserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private IUserService iUserService;
    @InjectMocks
    private UserController userController;

    @Test
    public void testFindById(){
        // Given
        Long id = 5L;

        // When
        Mockito.when(iUserService.findById(Mockito.anyLong())).thenReturn(DataProvider.newUserDtoMock());
        UserDto UserDto = userController.findById(id).getBody();

        // Then
        Mockito.verify(this.iUserService).findById(Mockito.anyLong());
        assertNotNull(UserDto);
        assertInstanceOf(UserDto.class, UserDto);
        assertEquals("anaFrank08", UserDto.getUsername());
        assertEquals(1L, UserDto.getUserId());
        assertEquals(Rol.TEACHER, UserDto.getRol());
    }
}
