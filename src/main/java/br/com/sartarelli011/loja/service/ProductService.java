package br.com.sartarelli011.loja.service;

import br.com.sartarelli011.loja.dtos.ProductDTO;
import br.com.sartarelli011.loja.entity.Product;
import br.com.sartarelli011.loja.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> findProducts() {
        List<Product> listProducts = this.productRepository.findAll();
        return listProducts;
    }

    public Product addProduct(ProductDTO productDTO) {
        Product newProduct = new Product(productDTO);
        this.productRepository.save(newProduct);
        return newProduct;

    }

}
