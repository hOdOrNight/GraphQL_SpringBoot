package com.graphql.repo.repository;

import com.graphql.repo.data.Salesperson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalespersonRepository extends JpaRepository<Salesperson, Long> {
    Salesperson findSalespersonByEmail(String email);
}