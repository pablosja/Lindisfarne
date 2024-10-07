package pablosja.lindisfarne.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import pablosja.lindisfarne.models.User;
import pablosja.lindisfarne.services.UserService;

@RestController
@RequestMapping("/api/v1")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        try {
            userService.saveUser(user);
            return ResponseEntity.ok("Usuario registrado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error en el registro: " + e.getMessage());
        }
    }

    @GetMapping("/login")

    public ResponseEntity<String> login() {
        try {
            SecurityContext contextHolder = SecurityContextHolder.getContext();
            Authentication auth = contextHolder.getAuthentication();

            System.out.println("<------------- Usr Auth: " + auth.getName());
            return ResponseEntity.ok("Login exitoso");
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Error en el inicio de sesión: " + e.getMessage());

        
        }
    }}
