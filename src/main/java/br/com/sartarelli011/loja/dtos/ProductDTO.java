package br.com.sartarelli011.loja.dtos;

import java.math.BigDecimal;

public record ProductDTO(String name, String description, Integer quantity, BigDecimal price) {
}
