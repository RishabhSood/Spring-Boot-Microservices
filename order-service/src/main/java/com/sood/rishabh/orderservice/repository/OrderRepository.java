package com.sood.rishabh.orderservice.repository;

import com.sood.rishabh.orderservice.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
