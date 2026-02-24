package com.portfolio.pm.project_manager_api.core.services;

import com.portfolio.pm.project_manager_api.core.model.enums.UserRole;
import com.portfolio.pm.project_manager_api.core.model.dto.user.AuthResponse;
import com.portfolio.pm.project_manager_api.core.model.dto.user.LoginRequest;
import com.portfolio.pm.project_manager_api.core.model.dto.user.RegisterRequest;
import com.portfolio.pm.project_manager_api.core.model.exception.InvalidCredentialsException;
import com.portfolio.pm.project_manager_api.core.model.exception.UserAlreadyExistsException;
import com.portfolio.pm.project_manager_api.core.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portfolio.pm.project_manager_api.infrastructure.entity.User;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    //TODO REVISAR LA IMPLEMENTACIÓN Y CAMBIAR LA LÓGICA DE ENCRIPTACIÓN DE LA CONTRASEÑA
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse register(RegisterRequest request) {
        // Check if username already exists
        if (userRepository.existsByUsername(request.username())) {
            throw new UserAlreadyExistsException("Username already taken: " + request.username());
        }

        // Check if email already exists
        if (userRepository.existsByEmail(request.email())) {
            throw new UserAlreadyExistsException("Email already registered: " + request.email());
        }

        try {
            // Create new user with encrypted password
            User user = User.builder()
                    .name(request.name())
                    .surname(request.surname())
                    .email(request.email())
                    .username(request.username())
                    .password(passwordEncoder.encode(request.password()))
                    .roles(UserRole.DEV)
                    .build();

            User savedUser = userRepository.save(user);

            return AuthResponse.builder()
                    .success(true)
                    .message("User registered successfully")
                    .user(AuthResponse.UserInfo.builder()
                            .id(savedUser.getId())
                            .username(savedUser.getUsername())
                            .email(savedUser.getEmail())
                            .name(savedUser.getName())
                            .surname(savedUser.getSurname())
                            .build())
                    .build();

        } catch (Exception ex) {
            throw new RuntimeException("Error during user registration", ex);
        }
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        // Find user by username
        User user = userRepository.findByUsername(request.username())
                .orElseThrow(() -> new InvalidCredentialsException("Invalid username or password"));

        // Check password matches
        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new InvalidCredentialsException("Invalid username or password");
        }

        return AuthResponse.builder()
                .success(true)
                .message("Login successful")
                .user(AuthResponse.UserInfo.builder()
                        .id(user.getId())
                        .username(user.getUsername())
                        .email(user.getEmail())
                        .name(user.getName())
                        .surname(user.getSurname())
                        .build())
                .build();
    }
}
