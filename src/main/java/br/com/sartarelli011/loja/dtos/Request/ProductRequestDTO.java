package br.com.sartarelli011.loja.dtos.Request;

import java.math.BigDecimal;

public record ProductRequestDTO(String name, String description, Integer quantity, BigDecimal price) {
}
