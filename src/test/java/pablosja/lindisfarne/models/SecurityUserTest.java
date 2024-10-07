package pablosja.lindisfarne.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class SecurityUserTest {

    @Test
    void testGetAuthorities() {
        Set<Role> roles = new HashSet<>();
        roles.add(new Role(1L, "ROLE_USER"));
        roles.add(new Role(2L, "ROLE_ADMIN"));

        User user = new User();
        user.setRoles(roles);

        SecurityUser securityUser = new SecurityUser(user);
        Collection<? extends GrantedAuthority> authorities = securityUser.getAuthorities();

        assertEquals(2, authorities.size());
        assertEquals(true, authorities.contains(new SimpleGrantedAuthority("ROLE_USER")));
        assertEquals(true, authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN")));
    }

    @Test
    void testGetPassword() {
        User user = new User();
        user.setPassword("securePassword");

        SecurityUser securityUser = new SecurityUser(user);
        assertEquals("securePassword", securityUser.getPassword());
    }

    @Test
    void testGetUsername() {
        User user = new User();
        user.setUsername("testUser");

        SecurityUser securityUser = new SecurityUser(user);
        assertEquals("testUser", securityUser.getUsername());
    }
}
