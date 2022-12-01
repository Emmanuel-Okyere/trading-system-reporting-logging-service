package com.tlc.group.seven.reportingloggingservice.order.repository;

import com.tlc.group.seven.reportingloggingservice.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "SELECT * from orders where side = ?1", nativeQuery = true)
    List<Order> findOrderBySide1(String side);

    @Query(value = "select * from orders where side like :side%", nativeQuery = true)
    List<Order> findOrderBySide(@Param("side") String side);
}
