package pablosja.lindisfarne.dtos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationDtoTest {

    @Test
    void testGetEncryptedPassword() {
        UserRegistrationDto dto = new UserRegistrationDto();
        dto.setEncryptedPassword("encryptedPassword123");

        assertEquals("encryptedPassword123", dto.getEncryptedPassword());
    }

    @Test
    void testGetUsername() {
        UserRegistrationDto dto = new UserRegistrationDto();
        dto.setUsername("testuser");

        assertEquals("testuser", dto.getUsername());
    }

    @Test
    void testSetEncryptedPassword() {
        UserRegistrationDto dto = new UserRegistrationDto();

        dto.setEncryptedPassword("newEncryptedPassword456");

        assertEquals("newEncryptedPassword456", dto.getEncryptedPassword());
    }

    @Test
    void testSetUsername() {
        UserRegistrationDto dto = new UserRegistrationDto();

        dto.setUsername("newUsername");

        assertEquals("newUsername", dto.getUsername());
    }
}
