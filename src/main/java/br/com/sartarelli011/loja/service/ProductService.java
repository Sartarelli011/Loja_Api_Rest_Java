package br.com.sartarelli011.loja.service;

import br.com.sartarelli011.loja.dtos.Request.ProductRequestDTO;
import br.com.sartarelli011.loja.dtos.Response.ProductResponseDTO;
import br.com.sartarelli011.loja.entity.Product;
import br.com.sartarelli011.loja.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<ProductResponseDTO> findProducts() {
        List<Product> listProducts = this.productRepository.findAll();
        return listProducts.stream().map(ProductResponseDTO::new).toList();
    }

    public ProductResponseDTO addProduct(ProductRequestDTO productDTO) {
        Product newProduct = new Product(productDTO);
        this.productRepository.save(newProduct);
        return new ProductResponseDTO(newProduct);

    }

}
