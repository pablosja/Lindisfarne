package pablosja.lindisfarne.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import pablosja.lindisfarne.models.User;
import pablosja.lindisfarne.services.UserService;

@RestController
@RequestMapping("/api/v1")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        try {
            userService.saveUser(user);
            return ResponseEntity.ok("Usuario registrado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error en el registro: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return ResponseEntity.ok("Login exitoso");
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Error en el inicio de sesión: " + e.getMessage());
        }
    }
}
