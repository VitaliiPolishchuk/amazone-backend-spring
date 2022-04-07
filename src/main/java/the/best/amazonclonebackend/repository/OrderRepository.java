package the.best.amazonclonebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import the.best.amazonclonebackend.model.Order;
import the.best.amazonclonebackend.model.User;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByOrderByIdDesc();
}
