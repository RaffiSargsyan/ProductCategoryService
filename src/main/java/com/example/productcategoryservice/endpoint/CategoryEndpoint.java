package com.example.productcategoryservice.endpoint;

import com.example.productcategoryservice.dto.CategoryResponse;
import com.example.productcategoryservice.dto.CreateCategory;
import com.example.productcategoryservice.entity.Category;
import com.example.productcategoryservice.mapper.CategoryMapper;
import com.example.productcategoryservice.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryEndpoint {
    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping("/all")
    public List<CategoryResponse> getAllCategory() {
        return categoryMapper.map(categoryService.findAllCategory());
    }

    @GetMapping("/getBy/{id}")
    public ResponseEntity<Category> getById(@PathVariable("id") int id) {
        Optional<Category> byId = categoryService.getById(id);
        if (byId.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(byId.get());
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CreateCategory category) {
        Category categorycreate = categoryService.create(categoryMapper.map(category));
        return ResponseEntity.ok(categorycreate);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Category> update(@RequestBody Category category, @PathVariable("id") int id) {
        Optional<Category> getId = categoryService.getById(id);
        if (category.getId() == 0){
            return ResponseEntity.badRequest().build();
        }
        Category categoryNew = getId.get();
        Category.builder()
                .name(category.getName())
                .build();
        categoryService.updateCategory(categoryNew);
        categoryService.updateCategory(category);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete (@PathVariable("id") int id){
        categoryService.delete(id);
        return ResponseEntity.notFound().build();
    }
}
