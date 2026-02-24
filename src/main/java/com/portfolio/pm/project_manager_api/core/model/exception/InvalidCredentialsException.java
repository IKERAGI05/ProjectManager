package com.portfolio.pm.project_manager_api.core.model.exception;

public class InvalidCredentialsException extends RuntimeException {
    
    public InvalidCredentialsException(String message) {
        super(message);
    }
}
