package com.tlc.group.seven.reportingloggingservice.order.service;

import com.tlc.group.seven.reportingloggingservice.constant.AppConstant;
import com.tlc.group.seven.reportingloggingservice.order.model.Order;
import com.tlc.group.seven.reportingloggingservice.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public ResponseEntity<?> getOrders(){
        if(orderRepository.findAll().isEmpty()){
            Map<?, ?> responseBody = Map.of("status", AppConstant.noContentStatus, "data", AppConstant.getNoDataAvailableMessage);
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body(responseBody);
        }
        Map<?, ?> responseBody = Map.of("status", AppConstant.successStatus, "message", AppConstant.getDataSuccessMessage, "data", orderRepository.findAll());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseBody);
    }

    public ResponseEntity<?> findOrderBySide(String side){
        if(orderRepository.findOrderBySide(side).isEmpty()){
            Map<?, ?> responseBody = Map.of("status", AppConstant.noContentStatus, "message", AppConstant.getNoDataAvailableMessage);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(responseBody);
        }
        Map<?, ?> responseBody = Map.of("status", AppConstant.successStatus, "message", AppConstant.getDataSuccessMessage, "data", orderRepository.findOrderBySide(side));
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseBody);
    }
}
