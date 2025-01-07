package com.agora.agoraproductservice.service;

import com.agora.agoraproductservice.exceptions.CategoryNotFoundException;
import com.agora.agoraproductservice.exceptions.ProductNotFoundException;
import com.agora.agoraproductservice.payloads.ProductPayload;
import com.agora.agoraproductservice.response.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse getProduct(String productId) throws ProductNotFoundException;

    List<ProductResponse> getAllProducts();

    ProductResponse create(ProductPayload payload) throws CategoryNotFoundException;

    ProductResponse update(String productId, ProductPayload payload) throws ProductNotFoundException, CategoryNotFoundException;

    void delete(String productId) throws ProductNotFoundException;
}
