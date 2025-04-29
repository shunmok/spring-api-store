package com.codewithmosh.store.services;

import com.codewithmosh.store.orders.OrderDto;
import com.codewithmosh.store.orders.OrderNotFoundException;
import com.codewithmosh.store.mappers.OrderMapper;
import com.codewithmosh.store.repositories.OrderRepository;
import com.codewithmosh.store.products.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class OrderService {
    private final ProductRepository.AuthService authService;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public List<OrderDto> getAllOrders() {
        var user = authService.getCurrentUser();
        var orders = orderRepository.getOrdersByCustomer(user);
        return orders
                .stream()
                .map(orderMapper::toDto)
                .toList();
    }

    public OrderDto getOrder(Long orderId) {
        var user = authService.getCurrentUser();
        var order = orderRepository
                .getOrderWithItems(orderId)
                .orElseThrow(OrderNotFoundException::new);

        if (!order.isPlacedBy(user)) {
            throw new AccessDeniedException("You don't have access to this order.");
        }

        return orderMapper.toDto(order);
    }
}
