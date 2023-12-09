package br.com.sartarelli011.loja.dtos.Request;

import br.com.sartarelli011.loja.enums.UserTypes;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRequestDTO(@NotBlank String firstName,
                             @NotBlank String lastName,
                             @NotBlank String email,
                             @NotBlank String password,
                             @NotNull UserTypes role) {
}
