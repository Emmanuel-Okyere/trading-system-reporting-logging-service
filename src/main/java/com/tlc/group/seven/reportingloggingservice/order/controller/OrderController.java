package com.tlc.group.seven.reportingloggingservice.order.controller;

import com.tlc.group.seven.reportingloggingservice.order.model.Order;
import com.tlc.group.seven.reportingloggingservice.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/reports")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/orders")
    public ResponseEntity<?> getOrders(){
        return orderService.getOrders();
    }

    @RequestMapping("/orders/by")
    public ResponseEntity<?> getBuySellOrders(@RequestParam String side){
        return orderService.findOrderBySide(side);
    }
}
