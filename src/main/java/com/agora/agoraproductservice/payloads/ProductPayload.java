package com.agora.agoraproductservice.payloads;

import com.agora.agoraproductservice.models.Product;

import java.util.UUID;

public record ProductPayload(
        String id,
        String title,
        String description,
        double price,
        String categoryId
) {
    public Product toEntity() {
        Product product = new Product();
        product.setId(UUID.fromString(id));
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        return product;
    }
}
