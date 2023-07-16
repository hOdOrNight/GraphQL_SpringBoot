package com.graphql.repo.controller;

import com.graphql.repo.data.Salesperson;
import com.graphql.repo.repository.SalespersonRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class SalespersonController {
    private final SalespersonRepository salespersonRepository;

    public SalespersonController(SalespersonRepository salespersonRepository) {
        this.salespersonRepository = salespersonRepository;
    }

    @QueryMapping
    public Iterable<Salesperson> salespeople() {
        return this.salespersonRepository.findAll();
    }

    @QueryMapping
    public Salesperson salespersonById(@Argument Long id) {
        return this.salespersonRepository.findById(id).orElseThrow();
    }

    @QueryMapping
    public Salesperson salespersonByEmail(@Argument String email) {
        return this.salespersonRepository.findSalespersonByEmail(email);
    }
}
