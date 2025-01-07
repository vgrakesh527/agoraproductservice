package com.agora.agoraproductservice.controller;

import com.agora.agoraproductservice.exceptions.CategoryNotFoundException;
import com.agora.agoraproductservice.exceptions.ProductNotFoundException;
import com.agora.agoraproductservice.payloads.ProductPayload;
import com.agora.agoraproductservice.response.ProductResponse;
import com.agora.agoraproductservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable("id") String id) throws ProductNotFoundException {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(@RequestBody ProductPayload payload) throws CategoryNotFoundException {
        return new ResponseEntity<>(productService.create(payload), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(@PathVariable("id") String id, @RequestBody ProductPayload payload) throws CategoryNotFoundException, ProductNotFoundException {
        return new ResponseEntity<>(productService.update(id, payload), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) throws ProductNotFoundException {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
