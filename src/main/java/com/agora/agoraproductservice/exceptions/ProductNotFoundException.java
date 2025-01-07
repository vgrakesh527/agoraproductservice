package com.agora.agoraproductservice.exceptions;

import lombok.Getter;

@Getter
public class ProductNotFoundException extends Exception{
    private final int errorCode;
    public ProductNotFoundException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

}
