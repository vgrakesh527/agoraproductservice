package com.agora.agoraproductservice.messages;

public record ProductNotFoundMessage(
        int errorCode,
        String message
) {
}
