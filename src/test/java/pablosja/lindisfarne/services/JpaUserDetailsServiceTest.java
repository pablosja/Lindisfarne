package pablosja.lindisfarne.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import pablosja.lindisfarne.models.User;
import pablosja.lindisfarne.repositories.UserRepository;

public class JpaUserDetailsServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private JpaUserDetailsService jpaUserDetailsService;

    public JpaUserDetailsServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testLoadUserByUsername() {
        User mockUser = new User();
        mockUser.setUsername("testUser");
        mockUser.setPassword("testPassword");

        when(userRepository.findByUsername("testUser")).thenReturn(Optional.of(mockUser));

        UserDetails userDetails = jpaUserDetailsService.loadUserByUsername("testUser");
        assertNotNull(userDetails);
    }

    @Test
    void testLoadUserByUsername_UserNotFound() {
        when(userRepository.findByUsername("nonexistentUser")).thenReturn(Optional.empty());

        try {
            jpaUserDetailsService.loadUserByUsername("nonexistentUser");
        } catch (UsernameNotFoundException e) {
            assertNotNull(e);
        }
    }
}
