package br.com.sartarelli011.loja.service;

import br.com.sartarelli011.loja.dtos.LoginDTO;
import br.com.sartarelli011.loja.dtos.LoginResponseDTO;
import br.com.sartarelli011.loja.dtos.UserDTO;
import br.com.sartarelli011.loja.entity.User;
import br.com.sartarelli011.loja.repositories.UserRepository;
import br.com.sartarelli011.loja.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;

    public ResponseEntity<LoginResponseDTO> loginUser(LoginDTO loginDTO) {

        var usernamePassword = new UsernamePasswordAuthenticationToken(loginDTO.login(), loginDTO.password());

        try {
            var auth = this.authenticationManager.authenticate(usernamePassword);
            var token = tokenService.generateToken((User) auth.getPrincipal());
            return ResponseEntity.ok(new LoginResponseDTO(token));
        } catch (AuthenticationException exception) {
            throw new RuntimeException("Email ou senha incorreta.", exception);
        }
    }

    public ResponseEntity<String> createUser(UserDTO userDTO) {

        if (this.userRepository.findByEmail(userDTO.email()) != null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already exists.");

        String encriptedUserPassword = new BCryptPasswordEncoder().encode(userDTO.password());
        User newUser = new User(userDTO, encriptedUserPassword);
        this.userRepository.save(newUser);

        return ResponseEntity.status(HttpStatus.CREATED).body("User created with success!");
    }


    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

}
