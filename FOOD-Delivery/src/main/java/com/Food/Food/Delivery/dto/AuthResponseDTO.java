package com.Food.Food.Delivery.dto;

public class AuthResponseDTO {
    private String message;
    private boolean success;

    // You could add more fields like user info, tokens, etc.

    public AuthResponseDTO(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    // Getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
