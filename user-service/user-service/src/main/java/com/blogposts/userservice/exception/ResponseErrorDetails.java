package com.blogposts.userservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ResponseErrorDetails {
    private LocalDateTime timestamp;
    private String message;
    private String errorCode;

    public ResponseErrorDetails(String message, String errorCode) {
        this.timestamp = LocalDateTime.now();
        this.message = message;
        this.errorCode = errorCode;
    }
}
