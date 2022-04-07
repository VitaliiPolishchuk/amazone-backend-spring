package the.best.amazonclonebackend.service;

import the.best.amazonclonebackend.model.RefreshToken;

import java.time.Instant;
import java.util.UUID;

public interface RefreshTokenService {
    RefreshToken generateRefreshToken();

    void validateRefreshToken(String token);

    void deleteRefreshToken(String token);
}
