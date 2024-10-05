package pablosja.lindisfarne.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import pablosja.lindisfarne.models.User;
import pablosja.lindisfarne.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Encriptar la contraseña
        userRepository.save(user);
    }

    // Puedes añadir más métodos aquí, como buscar usuarios, etc.
}
