package com.tlc.group.seven.reportingloggingservice.statistics.service;

import com.tlc.group.seven.reportingloggingservice.logs.repository.LogDataRepository;
import com.tlc.group.seven.reportingloggingservice.order.repository.OrderRepository;
import com.tlc.group.seven.reportingloggingservice.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private LogDataRepository logDataRepository;

    public int getTotalUsers(){
        return userRepository.findAll().size();
    }

    public int getTotalOrders(){
        return orderRepository.findAll().size();
    }

    public int getTotalSellOrders(){
        return orderRepository.findOrderBySide("SELL").size();
    }

    public int getTotalBuyOrders(){
        return orderRepository.findOrderBySide("BUY").size();
    }

    public int getTotalLog(){
        return logDataRepository.findAll().size();
    }

}
