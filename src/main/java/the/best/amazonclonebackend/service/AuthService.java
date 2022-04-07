package the.best.amazonclonebackend.service;

import the.best.amazonclonebackend.dto.AuthenticationResponse;
import the.best.amazonclonebackend.dto.LoginRequest;
import the.best.amazonclonebackend.dto.RefreshTokenRequest;
import the.best.amazonclonebackend.model.User;

public interface AuthService {
    void signup(LoginRequest registerRequest);
    void verifyAccount(String token);
    AuthenticationResponse login(LoginRequest loginRequest);
    User getCurrentUser();
    AuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
    boolean isLoggedIn();
}
