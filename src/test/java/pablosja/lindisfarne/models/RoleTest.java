package pablosja.lindisfarne.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RoleTest {

    @Test
    void testGetId() {
        Role role = new Role(1L, "ADMIN");
        assertEquals(1L, role.getId());
    }

    @Test
    void testGetName() {
        Role role = new Role(1L, "ADMIN");
        assertEquals("ADMIN", role.getName());
    }

    @Test
    void testSetId() {
        Role role = new Role(1L, "ADMIN");
        role.setId(2L);
        assertEquals(2L, role.getId());
    }

    @Test
    void testSetName() {
        Role role = new Role(1L, "ADMIN");
        role.setName("USER");
        assertEquals("USER", role.getName());
    }
}
