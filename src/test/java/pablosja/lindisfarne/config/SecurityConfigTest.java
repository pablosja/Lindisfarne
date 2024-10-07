package pablosja.lindisfarne.config;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pablosja.lindisfarne.facades.encryptations.Base64Encoder;


public class SecurityConfigTest {

    @InjectMocks
    private SecurityConfig securityConfig;

    @Mock
    private HttpSecurity httpSecurity;

    @Mock
    private AuthenticationManagerBuilder authenticationManagerBuilder;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAuthManager() throws Exception {
        when(httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)).thenReturn(authenticationManagerBuilder);
        AuthenticationManager authenticationManager = mock(AuthenticationManager.class);
        when(authenticationManagerBuilder.build()).thenReturn(authenticationManager);

        AuthenticationManager result = securityConfig.authManager(httpSecurity);
        assertNotNull(result);
        verify(authenticationManagerBuilder, times(1)).build();
    }

    @Test
    void testBase64Encoder() {
        Base64Encoder base64Encoder = securityConfig.base64Encoder();
        assertNotNull(base64Encoder);
    }

    @Test
    void testPasswordEncoder() {
        PasswordEncoder passwordEncoder = securityConfig.passwordEncoder();
        assertNotNull(passwordEncoder);
        assertTrue(passwordEncoder instanceof BCryptPasswordEncoder);
    }
}
