package br.com.sartarelli011.loja.controller;

import br.com.sartarelli011.loja.dtos.UserDTO;
import br.com.sartarelli011.loja.entity.User;
import br.com.sartarelli011.loja.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;


    @GetMapping
    public ResponseEntity<List<User>> findAllUser() {
        List<User> listUser = this.userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(listUser);
    }
}
