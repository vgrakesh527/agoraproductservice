package com.agora.agoraproductservice.exceptions;

import com.agora.agoraproductservice.messages.CategoryNotFoundMessage;
import com.agora.agoraproductservice.messages.ProductNotFoundMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<ProductNotFoundMessage> productNotFoundException(ProductNotFoundException e) {
        ProductNotFoundMessage message = new ProductNotFoundMessage(e.getErrorCode(), e.getMessage());
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<CategoryNotFoundMessage> categoryNotFoundException(CategoryNotFoundException e) {
        CategoryNotFoundMessage message = new CategoryNotFoundMessage(e.getErrorCode(), e.getMessage());
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }
}
