package pablosja.lindisfarne.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    void testGetId() {
        User user = new User();
        user.setId(1L);
        assertEquals(1L, user.getId());
    }

    @Test
    void testGetPassword() {
        User user = new User();
        user.setPassword("testPassword");
        assertEquals("testPassword", user.getPassword());
    }

    @Test
    void testGetRoles() {
        User user = new User();
        Set<Role> roles = new HashSet<>();
        roles.add(new Role(null, "ADMIN"));
        user.setRoles(roles);
        assertEquals(roles, user.getRoles());
    }

    @Test
    void testGetUsername() {
        User user = new User();
        user.setUsername("testUser");
        assertEquals("testUser", user.getUsername());
    }

    @Test
    void testSetId() {
        User user = new User();
        user.setId(2L);
        assertEquals(2L, user.getId());
    }

    @Test
    void testSetPassword() {
        User user = new User();
        user.setPassword("newPassword");
        assertEquals("newPassword", user.getPassword());
    }

    @Test
    void testSetRoles() {
        User user = new User();
        Set<Role> roles = new HashSet<>();
        roles.add(new Role(null, "USER"));
        user.setRoles(roles);
        assertEquals(roles, user.getRoles());
    }

    @Test
    void testSetUsername() {
        User user = new User();
        user.setUsername("newUser");
        assertEquals("newUser", user.getUsername());
    }
}
