package br.com.sartarelli011.loja.entity;

import br.com.sartarelli011.loja.dtos.Request.ProductRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "Product")
@Table(name = "produtos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Integer quantity;
    private BigDecimal price;

    public Product(ProductRequestDTO productDTO) {
        this.name = productDTO.name();
        this.description = productDTO.description();
        this.quantity = productDTO.quantity();
        this.price = productDTO.price();
    }
}
