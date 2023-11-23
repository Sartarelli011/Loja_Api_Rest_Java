package br.com.sartarelli011.loja.controller;

import br.com.sartarelli011.loja.dtos.Request.LoginRequestDTO;
import br.com.sartarelli011.loja.dtos.Response.LoginResponseDTO;
import br.com.sartarelli011.loja.dtos.Request.UserRequestDTO;
import br.com.sartarelli011.loja.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {


    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Validated LoginRequestDTO loginDTO) {
        return this.userService.loginUser(loginDTO);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Validated UserRequestDTO userDTO) {
        return this.userService.createUser(userDTO);
    }

}
