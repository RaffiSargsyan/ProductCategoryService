package com.example.productcategoryservice.service;

import com.example.productcategoryservice.entity.Product;
import com.example.productcategoryservice.repository.CategoryRepository;
import com.example.productcategoryservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> allProductes() {
        return productRepository.findAll();
    }

    public Product create(Product map) {
        return productRepository.save(map);
    }

    public Optional<Product> getById(int id) {
        return productRepository.findById(id);
    }

    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    public void delete(int id) {
        productRepository.deleteById(id);
    }
}
