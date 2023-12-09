package br.com.sartarelli011.loja.controller;

import br.com.sartarelli011.loja.dtos.Request.ProductRequestDTO;
import br.com.sartarelli011.loja.dtos.Response.ProductResponseDTO;
import br.com.sartarelli011.loja.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("loja")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
        var listProducts = this.productService.findProducts();
        return ResponseEntity.status(HttpStatus.OK).body(listProducts);
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> addProduct(@RequestBody @Valid ProductRequestDTO productDTO) {
        ProductResponseDTO createProduct = this.productService.addProduct(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createProduct);
    }

}
