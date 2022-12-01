package com.tlc.group.seven.reportingloggingservice.order.service;

import com.tlc.group.seven.reportingloggingservice.order.model.Order;
import com.tlc.group.seven.reportingloggingservice.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getOrders(){
        return orderRepository.findAll();
    }

    public List<Order> findOrderBySide(String side){
        return orderRepository.findOrderBySide(side);
    }
}
