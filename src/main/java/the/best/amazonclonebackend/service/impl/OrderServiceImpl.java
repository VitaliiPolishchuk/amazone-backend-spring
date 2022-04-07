package the.best.amazonclonebackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import the.best.amazonclonebackend.dto.OrderDto;
import the.best.amazonclonebackend.dto.OrderRequest;
import the.best.amazonclonebackend.model.Order;
import the.best.amazonclonebackend.repository.OrderRepository;
import the.best.amazonclonebackend.repository.ProductRepository;
import the.best.amazonclonebackend.service.OrderService;
import the.best.amazonclonebackend.service.UserService;

import java.util.List;

import static java.time.Instant.now;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserService userService;

    @Override
    @Transactional
    public Order create(OrderRequest orderRequest) {
        Order order = new Order();
        order.setUser(userService.getUserProfile());
        order.setOrderProducts(orderRequest.getProductIds().stream().map((Integer productId) -> productRepository.getById(productId.longValue())).toList());
        order.setAmount(orderRequest.getAmount());
        order.setCreated(now());

        return orderRepository.save(order);
    }

    @Override
    public List<OrderDto> getAll() {
        return userService.getUserProfile().getOrders()
                .stream()

                .map((Order order) -> OrderDto.builder()
                        .id(order.getId())
                        .created(order.getCreated().getEpochSecond())
                        .orderProducts(order.getOrderProducts())
                        .amount(order.getAmount())
                        .build())
                .sorted((OrderDto a, OrderDto b) -> (int) ((b.getCreated() - a.getCreated())))
                .toList();
    }
}
