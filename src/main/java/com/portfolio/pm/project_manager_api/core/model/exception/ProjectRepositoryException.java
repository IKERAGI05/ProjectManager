package com.portfolio.pm.project_manager_api.core.model.exception;

public class ProjectRepositoryException extends RuntimeException {
    
    public ProjectRepositoryException(String message) {
        super(message);
    }
    
    public ProjectRepositoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
