package com.graphql.repo.controller;

import com.graphql.repo.data.Order;
import com.graphql.repo.repository.OrderRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class OrderController {
    private final OrderRepository orderRepository;
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    @QueryMapping
    public Iterable<Order> orders(){
        return this.orderRepository.findAll();
    }

    @QueryMapping
    public Order orderById(@Argument String id){
        return this.orderRepository.findById(id).orElseThrow();
    }
}
