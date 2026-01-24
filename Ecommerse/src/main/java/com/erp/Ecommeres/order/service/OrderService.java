package com.erp.Ecommeres.order.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.erp.Ecommeres.order.entity.Order;
import com.erp.Ecommeres.order.Repo.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    // ✅ CONSTRUCTOR MUST TAKE OrderRepository
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Save order during checkout
    public Order placeOrder(Order order) {
        return orderRepository.save(order);
    }

    // My Orders (Profile Page)
    public List<Order> getMyOrders(Long userId) {
        return orderRepository.findByUserIdOrderByCreatedAtDesc(userId);
    }
}
