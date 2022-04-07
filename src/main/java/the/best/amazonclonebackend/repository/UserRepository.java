package the.best.amazonclonebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import the.best.amazonclonebackend.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}