package com.portfolio.pm.project_manager_api.core.services;

import com.portfolio.pm.project_manager_api.core.model.dto.user.AuthResponse;
import com.portfolio.pm.project_manager_api.core.model.dto.user.LoginRequest;
import com.portfolio.pm.project_manager_api.core.model.dto.user.RegisterRequest;

public interface UserService {
    
    AuthResponse register(RegisterRequest request);
    
    AuthResponse login(LoginRequest request);
}
