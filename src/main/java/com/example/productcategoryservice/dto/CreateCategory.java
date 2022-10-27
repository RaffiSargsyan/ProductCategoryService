package com.example.productcategoryservice.dto;

import com.example.productcategoryservice.entity.Category;
import liquibase.pro.packaged.S;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateCategory {
    private String name;
}
