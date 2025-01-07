package com.agora.agoraproductservice.service.impl;

import com.agora.agoraproductservice.exceptions.CategoryNotFoundException;
import com.agora.agoraproductservice.exceptions.ProductNotFoundException;
import com.agora.agoraproductservice.models.Product;
import com.agora.agoraproductservice.payloads.ProductPayload;
import com.agora.agoraproductservice.repositories.ProductRepository;
import com.agora.agoraproductservice.response.ProductResponse;
import com.agora.agoraproductservice.service.CategoryService;
import com.agora.agoraproductservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    @Override
    public ProductResponse getProduct(String productId) throws ProductNotFoundException {
        var product = getId(productId);
        return ProductResponse.toResponse(product);
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream().map(ProductResponse::toResponse).toList();
    }

    @Override
    public ProductResponse create(ProductPayload payload) throws CategoryNotFoundException {
        Product product = payload.toEntity();
        product.setCategory(categoryService.getId(payload.categoryId()));
        var result = productRepository.save(product);
        return ProductResponse.toResponse(result);
    }

    @Override
    public ProductResponse update(String productId, ProductPayload payload) throws ProductNotFoundException, CategoryNotFoundException {
        var product = getId(productId);
        product.setPrice(payload.price());
        product.setTitle(payload.title());
        product.setDescription(payload.description());
        product.setCategory(categoryService.getId(payload.categoryId()));
        var result = productRepository.save(product);
        return ProductResponse.toResponse(result);
    }

    @Override
    public void delete(String productId) throws ProductNotFoundException {
        var product = getId(productId);
        productRepository.delete(product);
    }

    private Product getId(String productId) throws ProductNotFoundException {
        return productRepository.findById(UUID.fromString(productId))
                .orElseThrow(() -> new ProductNotFoundException(111, productId + " is not available!!!"));
    }

}
