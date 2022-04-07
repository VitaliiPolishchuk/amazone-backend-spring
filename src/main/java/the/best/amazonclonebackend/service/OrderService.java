package the.best.amazonclonebackend.service;

import the.best.amazonclonebackend.dto.OrderDto;
import the.best.amazonclonebackend.dto.OrderRequest;
import the.best.amazonclonebackend.model.Order;

import java.util.List;

public interface OrderService {
    Order create(OrderRequest orderRequest);
    List<OrderDto> getAll();
}
