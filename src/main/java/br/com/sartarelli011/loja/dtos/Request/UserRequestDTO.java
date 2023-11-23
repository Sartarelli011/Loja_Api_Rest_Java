package br.com.sartarelli011.loja.dtos.Request;

import br.com.sartarelli011.loja.enums.UserTypes;

public record UserRequestDTO(String firstName, String lastName, String email, String password, UserTypes role) {
}
