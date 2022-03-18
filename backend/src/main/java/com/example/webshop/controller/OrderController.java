package com.example.webshop.controller;

import com.example.webshop.entity.Order;
import com.example.webshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Create operation
    @PostMapping("/orders")
    public Order createOrder(@Valid @RequestBody Order order) {
        return orderService.createOrder(order);
    }

    // Read operations
    @GetMapping("/orders/{id}")
    public Order fetchOrder(@PathVariable("id") Long id) {
        return orderService.fetchOrder(id);
    }

    @GetMapping("/orders")
    public List<Order> fetchOrderList() {
        return orderService.fetchOrderList();
    }

    // No update operation

    // Delete operation
    @DeleteMapping("/orders/{id}")
    public void deleteOrderById(@PathVariable("id") Long id) {
        orderService.deleteOrderById(id);
    }
}
