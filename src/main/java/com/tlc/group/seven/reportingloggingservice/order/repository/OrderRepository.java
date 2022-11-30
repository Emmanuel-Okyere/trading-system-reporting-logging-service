package com.tlc.group.seven.reportingloggingservice.order.repository;

import com.tlc.group.seven.reportingloggingservice.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
