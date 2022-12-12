package com.tlc.group.seven.reportingloggingservice.order.controller;

import com.tlc.group.seven.reportingloggingservice.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/admin/reports")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/orders")
    public ResponseEntity<?> getOrders(){
        if(orderService.getOrders().isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrders());
    }

    @RequestMapping("/orders/by")
    public ResponseEntity<?> getBuySellOrders(@RequestParam String side){
        if(orderService.findOrderBySide(side).isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(orderService.findOrderBySide(side));
    }
}
