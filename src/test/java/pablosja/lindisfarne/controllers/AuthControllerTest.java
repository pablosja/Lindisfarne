package pablosja.lindisfarne.controllers;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import pablosja.lindisfarne.models.User;
import pablosja.lindisfarne.services.UserService;

public class AuthControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private AuthController authController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        MockMvcBuilders.standaloneSetup(authController).build();
    }

    @SuppressWarnings("deprecation")
    @Test
    void testRegister() throws Exception {
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("testPassword");

        doNothing().when(userService).saveUser(user);

        ResponseEntity<String> response = authController.register(user);

        verify(userService, times(1)).saveUser(user);
        assertEquals("Usuario registrado exitosamente", response.getBody());
        assertEquals(200, response.getStatusCodeValue());
    }

    @SuppressWarnings("deprecation")
    @Test
    void testRegisterWithError() throws Exception {
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("testPassword");

        doThrow(new RuntimeException("Error de prueba")).when(userService).saveUser(user);

        ResponseEntity<String> response = authController.register(user);

        verify(userService, times(1)).saveUser(user);
        assertEquals("Error en el registro: Error de prueba", response.getBody());
        assertEquals(400, response.getStatusCodeValue());
    }
}
