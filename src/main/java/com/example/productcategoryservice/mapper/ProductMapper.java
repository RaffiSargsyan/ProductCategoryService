package com.example.productcategoryservice.mapper;

import com.example.productcategoryservice.dto.CreateProduct;
import com.example.productcategoryservice.dto.ProductResponse;
import com.example.productcategoryservice.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product map(CreateProduct createProduct);
    ProductResponse map(Product product);
    List<ProductResponse> map(List<Product> productList);

}
