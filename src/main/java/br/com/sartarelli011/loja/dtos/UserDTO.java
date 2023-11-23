package br.com.sartarelli011.loja.dtos;

import br.com.sartarelli011.loja.enums.UserTypes;

public record UserDTO(String firstName, String lastName, String email, String password, UserTypes role) {
}
