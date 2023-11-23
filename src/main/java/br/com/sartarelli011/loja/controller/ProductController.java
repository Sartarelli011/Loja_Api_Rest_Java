package br.com.sartarelli011.loja.controller;

import br.com.sartarelli011.loja.dtos.ProductDTO;
import br.com.sartarelli011.loja.entity.Product;
import br.com.sartarelli011.loja.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("loja")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> listProducts = this.productService.findProducts();
        return ResponseEntity.status(HttpStatus.OK).body(listProducts);
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody ProductDTO productDTO) {
        Product createProduct = this.productService.addProduct(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createProduct);
    }

}
