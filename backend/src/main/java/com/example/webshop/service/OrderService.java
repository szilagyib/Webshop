package com.example.webshop.service;

import com.example.webshop.entity.Order;
import com.example.webshop.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private IOrderRepository orderRepository;

    // Create operation
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    // Read operations
    public Order fetchOrder(Long id) {
        return orderRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No order with id " + id));
    }

    public List<Order> fetchOrderList() {
        return (List<Order>) orderRepository.findAll();
    }

    // No update operation

    // Delete operation
    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);
    }
}
