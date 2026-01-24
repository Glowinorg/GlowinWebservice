package com.erp.Ecommeres.order.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.erp.Ecommeres.order.entity.Order;
import com.erp.Ecommeres.order.service.OrderService;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // PLACE ORDER (Checkout)
    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.placeOrder(order));
    }

    // MY ORDERS (Profile Page)
    @GetMapping("/my/{userId}")
    public ResponseEntity<List<Order>> myOrders(@PathVariable Long userId) {
        return ResponseEntity.ok(orderService.getMyOrders(userId));
    }
}
