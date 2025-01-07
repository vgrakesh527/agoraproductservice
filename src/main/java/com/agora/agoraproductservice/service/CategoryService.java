package com.agora.agoraproductservice.service;

import com.agora.agoraproductservice.exceptions.CategoryNotFoundException;
import com.agora.agoraproductservice.models.Category;
import com.agora.agoraproductservice.payloads.CategoryPayload;
import com.agora.agoraproductservice.response.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryResponse getCategory(String id) throws CategoryNotFoundException;

    List<CategoryResponse> getAllCategories();

    CategoryResponse create(CategoryPayload payload);

    CategoryResponse update(String id, CategoryPayload payload) throws CategoryNotFoundException;

    void delete(String id) throws CategoryNotFoundException;

    Category getId(String id) throws CategoryNotFoundException;
}
