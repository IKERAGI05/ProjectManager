package com.portfolio.pm.project_manager_api.core.model.exception;

public class ClientRepositoryException extends RuntimeException {
    
    public ClientRepositoryException(String message) {
        super(message);
    }
    
    public ClientRepositoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
