package com.agora.agoraproductservice.exceptions;

import lombok.Getter;

@Getter
public class CategoryNotFoundException extends Exception{
    private final int errorCode;
    public CategoryNotFoundException(int errorCode,String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
