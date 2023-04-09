package com.bookstore.order;

import com.bookstore.auth.User;
import com.bookstore.auth.UserReposity;
import com.bookstore.config.JwtUtils;
import com.bookstore.exceptions.NotFoundException;
import com.bookstore.order.dto.OrderRequestDto;
import com.bookstore.order.dto.OrderResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserReposity userReposity;
    private final JwtUtils jwtUtils;

    public ResponseEntity<List<Order>> findAllOrders() {
        return ResponseEntity.ok(orderRepository.findAll());
    }

    public ResponseEntity<OrderResponseDto> createOrder(OrderRequestDto orderDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userReposity.findUserByEmail(username).get();

        Order newOrder = Order.builder()
                .user(user)
                .books(orderDto.getBooks())
                .orderDate(orderDto.getOrderDate())
                .orderStatus(orderDto.getOrderStatus())
                .build();

        OrderResponseDto newOrderDto = OrderResponseDto.builder()
                .userEmail(username)
                .books(orderDto.getBooks())
                .orderDate(orderDto.getOrderDate())
                .orderStatus(orderDto.getOrderStatus())
                .build();

        orderRepository.save(newOrder);
        return ResponseEntity.ok(newOrderDto);

    }

    public ResponseEntity<Optional<Order>> findOrderById(UUID id) {
        Optional<Order> order = Optional.of(orderRepository.findById(id))
                .orElseThrow(() -> new NotFoundException("Book does not exists."));
        return ResponseEntity.ok(order);
    }
}
