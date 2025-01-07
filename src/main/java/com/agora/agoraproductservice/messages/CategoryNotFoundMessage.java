package com.agora.agoraproductservice.messages;

public record CategoryNotFoundMessage(
        int errorCode,
        String message
) {
}
