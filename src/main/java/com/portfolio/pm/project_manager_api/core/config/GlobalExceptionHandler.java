package com.portfolio.pm.project_manager_api.core.config;

import com.portfolio.pm.project_manager_api.core.model.dto.error.ErrorResponse;
import com.portfolio.pm.project_manager_api.core.model.exception.*;
import com.portfolio.pm.project_manager_api.core.model.utils.constants.ConstantsErrors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    private void logError(Exception ex) {
        log.error("[ERROR]: {} - {}", ex.getClass().getSimpleName(), ex.getMessage(), ex);
    }

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleClientNotFoundException(ClientNotFoundException ex, WebRequest request) {
        logError(ex);
        ErrorResponse errorResponse = ErrorResponse.builder()
                .error("Client Not Found")
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .path(request.getDescription(false).replace("uri=", ""))
                .errorMessageCode(ConstantsErrors.ERR_CLIENT_NOT_FOUND)
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(ClientRepositoryException.class)
    public ResponseEntity<ErrorResponse> handleClientRepositoryException(ClientRepositoryException ex, WebRequest request) {
        logError(ex);
        ErrorResponse errorResponse = ErrorResponse.builder()
                .error("Client Database Error")
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .path(request.getDescription(false).replace("uri=", ""))
                .errorMessageCode(ConstantsErrors.ERR_DEFAULT)
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    @ExceptionHandler(ProjectNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProjectNotFoundException(ProjectNotFoundException ex, WebRequest request) {
        logError(ex);
        ErrorResponse errorResponse = ErrorResponse.builder()
                .error("Project Not Found")
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .path(request.getDescription(false).replace("uri=", ""))
                .errorMessageCode(ConstantsErrors.ERR_PROJECTS_NOT_FOUND)
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(ProjectRepositoryException.class)
    public ResponseEntity<ErrorResponse> handleProjectRepositoryException(ProjectRepositoryException ex, WebRequest request) {
        logError(ex);
        ErrorResponse errorResponse = ErrorResponse.builder()
                .error("Project Database Error")
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .path(request.getDescription(false).replace("uri=", ""))
                .errorMessageCode(ConstantsErrors.ERR_DEFAULT)
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ErrorResponse> handleInvalidCredentialsException(InvalidCredentialsException ex, WebRequest request) {
        logError(ex);
        ErrorResponse errorResponse = ErrorResponse.builder()
                .error("Authentication Failed")
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .path(request.getDescription(false).replace("uri=", ""))
                .errorMessageCode(ConstantsErrors.ERR_USER_NOT_ALLOWED)
                .build();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleUserAlreadyExistsException(UserAlreadyExistsException ex, WebRequest request) {
        logError(ex);
        ErrorResponse errorResponse = ErrorResponse.builder()
                .error("User Conflict")
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .path(request.getDescription(false).replace("uri=", ""))
                .errorMessageCode(ConstantsErrors.ERR_USER_ALREADY_EXISTS)
                .build();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex, WebRequest request) {
        logError(ex);
        ErrorResponse errorResponse = ErrorResponse.builder()
                .error("Internal Server Error")
                .message("An unexpected error occurred")
                .timestamp(LocalDateTime.now())
                .path(request.getDescription(false).replace("uri=", ""))
                .errorMessageCode(ConstantsErrors.ERR_DEFAULT)
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}
