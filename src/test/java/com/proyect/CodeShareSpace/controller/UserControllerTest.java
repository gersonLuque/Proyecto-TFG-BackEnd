package com.proyect.CodeShareSpace.controller;

import com.proyect.CodeShareSpace.DataProvider;
import com.proyect.CodeShareSpace.dto.user.UserDto;
import com.proyect.CodeShareSpace.model.Rol;
import com.proyect.CodeShareSpace.service.interfaces.IUserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private IUserService iUserService;
    @InjectMocks
    private UserController userController;

    @Test
    public void testFindAll(){
        // Given
        List<UserDto> userDtoList = DataProvider.newUsersDtoListMock();

        // When
        Mockito.when(iUserService.findAll()).thenReturn(userDtoList);
        ResponseEntity<List<UserDto>> responseUserrDtoList = userController.findAll();

        // Then
        Mockito.verify(this.iUserService).findAll();
        assertNotNull(responseUserrDtoList);
        assertFalse(responseUserrDtoList.getBody().isEmpty());

        assertEquals(5, responseUserrDtoList.getBody().size());
        assertEquals("carlomagno", responseUserrDtoList.getBody().get(1).getUsername());
        assertEquals(7L, responseUserrDtoList.getBody().get(4).getUserId());
    }
    
    @Test
    public void testFindById(){
        // Given
        Long id = 5L;

        // When
        Mockito.when(iUserService.findById(Mockito.anyLong())).thenReturn(DataProvider.newUserDtoMock());
        ResponseEntity<UserDto> responseUserDto = userController.findById(id);

        // Then
        Mockito.verify(this.iUserService).findById(Mockito.anyLong());
        assertNotNull(responseUserDto);

        assertEquals("antonioMayorista", responseUserDto.getBody().getUsername());
        assertEquals(5L, responseUserDto.getBody().getUserId());
        assertEquals(Rol.STUDENT, responseUserDto.getBody().getRol());
    }

//    @Test
//    public void testDeleteUserById(){
//        // Given
//        Long userId = 5L;
//
//        // When
//        Mockito.doNothing().when(iUserService).deleteUserById(Mockito.anyLong());
//        ResponseEntity<Void> response = userController.deleteUserById(userId);
//
//        // Then
//        Mockito.verify(iUserService).deleteUserById(Mockito.anyLong());
//        assertNotNull(response);
//        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
//    }



}
