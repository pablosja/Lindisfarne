package pablosja.lindisfarne.dtos;

public class UserRegistrationDto {
    private String username;
    private String encryptedPassword;

    // Constructor vacío
    public UserRegistrationDto() {}

    // Constructor con parámetros
    public UserRegistrationDto(String username, String encryptedPassword) {
        this.username = username;
        this.encryptedPassword = encryptedPassword;
    }

    // Getters y Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }
}
