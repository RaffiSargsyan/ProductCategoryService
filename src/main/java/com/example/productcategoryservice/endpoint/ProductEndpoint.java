package com.example.productcategoryservice.endpoint;

import com.example.productcategoryservice.dto.CreateProduct;
import com.example.productcategoryservice.dto.ProductResponse;
import com.example.productcategoryservice.entity.Product;
import com.example.productcategoryservice.mapper.ProductMapper;
import com.example.productcategoryservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductEndpoint {
    private final ProductService productService;
    private final ProductMapper productMapper;

    @GetMapping("/all")
    public List<ProductResponse> getAllCategory() {
        return productMapper.map(productService.allProductes());
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CreateProduct createProduct) {
        Product productCreate = productService.create(productMapper.map(createProduct));
        return ResponseEntity.ok(productCreate);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> update(@RequestBody Product product, @PathVariable("id") int id) {
        Optional<Product> getId = productService.getById(id);
        if (product.getId() == 0){
            return ResponseEntity.badRequest().build();
        }
        Product newProduct = getId.get();
        Product.builder()
                .title(product.getTitle())
                .build();
        productService.updateProduct(newProduct);
        productService.updateProduct(product);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete (@PathVariable("id") int id){
        productService.delete(id);
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/getBy/{id}")
    public ResponseEntity<Product> getById(@PathVariable("id") int id) {
        Optional<Product> byId = productService.getById(id);
        if (byId.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(byId.get());
    }
}
