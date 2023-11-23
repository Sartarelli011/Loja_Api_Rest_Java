package br.com.sartarelli011.loja.dtos.Response;

import br.com.sartarelli011.loja.entity.Product;

import java.math.BigDecimal;

public record ProductResponseDTO(Long id, String name, String description, Integer quantity, BigDecimal price) {

    public ProductResponseDTO(Product product) {
        this(product.getId(), product.getName(), product.getDescription(), product.getQuantity(), product.getPrice());
    }
}
