package com.bjoernkw.examples.order_service;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * The order controller.
 */
@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;

    @GetMapping("/")
    public void getAllOrders() {
        orderRepository.findAll();
    }

    @GetMapping("/{id}")
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow();
    }

    @PostMapping("/")
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @PutMapping("/{id}")
    public Order updateOrder(Long id, Order order) {
        return orderRepository.save(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
