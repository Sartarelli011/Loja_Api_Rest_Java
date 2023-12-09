package br.com.sartarelli011.loja.dtos.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductRequestDTO(@NotBlank String name,
                                @NotBlank String description,
                                @NotNull Integer quantity,
                                @NotNull BigDecimal price) {
}
