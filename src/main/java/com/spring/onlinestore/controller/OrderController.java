package com.spring.onlinestore.controller;

import com.spring.onlinestore.model.Order;
import com.spring.onlinestore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
    }

    @PostMapping
    public Order addOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderById(@PathVariable Long id) {
        orderService.deleteOrderById(id);
    }
}
