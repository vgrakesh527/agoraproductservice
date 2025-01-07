package com.agora.agoraproductservice.controller;

import com.agora.agoraproductservice.exceptions.CategoryNotFoundException;
import com.agora.agoraproductservice.payloads.CategoryPayload;
import com.agora.agoraproductservice.response.CategoryResponse;
import com.agora.agoraproductservice.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable String id) throws CategoryNotFoundException {
        return new ResponseEntity<>(categoryService.getCategory(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> create(@RequestBody CategoryPayload payload) {
        return new ResponseEntity<>(categoryService.create(payload), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> update(@PathVariable String id, @RequestBody CategoryPayload payload) throws CategoryNotFoundException {
        return ResponseEntity.ok(categoryService.update(id, payload));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable String id) throws CategoryNotFoundException {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
