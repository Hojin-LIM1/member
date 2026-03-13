package com.example.demo.common;

import lombok.Getter;

@Getter
public class HealthResponse {
    private final String status;
    private final String timestamp;

    public HealthResponse(String status, String timestamp) {
        this.status = status;
        this.timestamp = timestamp;
    }
}
