package com.agora.agoraproductservice.response;

import com.agora.agoraproductservice.models.Category;

import java.time.Instant;

public record CategoryResponse(
        String id,
        String name,
        Instant createdOn,
        Instant updatedOn
) {
    public static CategoryResponse toResponse(Category category) {
        return new CategoryResponse(
                category.getId().toString(),
                category.getName(),
                category.getCreatedOn(),
                category.getUpdatedOn());
    }
}
