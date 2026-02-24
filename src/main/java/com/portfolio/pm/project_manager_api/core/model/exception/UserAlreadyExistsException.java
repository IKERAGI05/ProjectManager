package com.portfolio.pm.project_manager_api.core.model.exception;

public class UserAlreadyExistsException extends RuntimeException {
    
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
