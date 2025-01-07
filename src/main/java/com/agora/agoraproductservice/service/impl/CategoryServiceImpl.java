package com.agora.agoraproductservice.service.impl;

import com.agora.agoraproductservice.exceptions.CategoryNotFoundException;
import com.agora.agoraproductservice.models.Category;
import com.agora.agoraproductservice.payloads.CategoryPayload;
import com.agora.agoraproductservice.repositories.CategoryRepository;
import com.agora.agoraproductservice.response.CategoryResponse;
import com.agora.agoraproductservice.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    @Override
    public CategoryResponse getCategory(String id) throws CategoryNotFoundException {
        var category = getId(id);
        return CategoryResponse.toResponse(category);
    }

    @Override
    public List<CategoryResponse> getAllCategories() {
        var categories = categoryRepository.findAll();
        return categories.stream().map(CategoryResponse::toResponse).toList();
    }

    @Override
    public CategoryResponse create(CategoryPayload payload) {
        var category = new Category();
        category.setName(payload.name());
        var result = categoryRepository.save(category);
        return CategoryResponse.toResponse(result);
    }

    @Override
    public CategoryResponse update(String id, CategoryPayload payload) throws CategoryNotFoundException {
        var category = getId(id);
        category.setName(payload.name());
        var result = categoryRepository.save(category);
        return CategoryResponse.toResponse(result);
    }

    @Override
    public void delete(String id) throws CategoryNotFoundException {
        var category = getId(id);
        categoryRepository.delete(category);
    }

    public Category getId(String id) throws CategoryNotFoundException {
        return categoryRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new CategoryNotFoundException(123, id + " is not found!"));
    }
}
