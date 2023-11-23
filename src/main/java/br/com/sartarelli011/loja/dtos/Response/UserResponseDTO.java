package br.com.sartarelli011.loja.dtos.Response;

import br.com.sartarelli011.loja.entity.User;
import br.com.sartarelli011.loja.enums.UserTypes;

public record UserResponseDTO(String firstName, String lastName, String email, UserTypes role) {

    public UserResponseDTO(User user) {
        this(user.getFirstName(), user.getLastName(), user.getEmail(), user.getRole());
    }
}
