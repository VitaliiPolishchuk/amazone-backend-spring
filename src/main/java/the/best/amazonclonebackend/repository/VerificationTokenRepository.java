package the.best.amazonclonebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import the.best.amazonclonebackend.model.VerificationToken;

import java.util.Optional;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
    Optional<VerificationToken> findByToken(String token);
}

