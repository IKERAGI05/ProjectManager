package com.portfolio.pm.project_manager_api.core.model.exception;

public class ClientNotFoundException extends RuntimeException {
    
    public ClientNotFoundException(String message) {
        super(message);
    }
    
    public ClientNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
