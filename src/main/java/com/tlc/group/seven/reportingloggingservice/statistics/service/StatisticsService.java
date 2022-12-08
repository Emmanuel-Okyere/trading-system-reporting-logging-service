package com.tlc.group.seven.reportingloggingservice.statistics.service;

import com.tlc.group.seven.reportingloggingservice.constant.AppConstant;
import com.tlc.group.seven.reportingloggingservice.logs.repository.LogDataRepository;
import com.tlc.group.seven.reportingloggingservice.order.repository.OrderRepository;
import com.tlc.group.seven.reportingloggingservice.portfolio.repository.PortfolioRepository;
import com.tlc.group.seven.reportingloggingservice.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StatisticsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private LogDataRepository logDataRepository;

    @Autowired
    private PortfolioRepository portfolioRepository;

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
    public int getTotalPortfolio(){
        return portfolioRepository.findAll().size();
    }


    public ResponseEntity<?> getStatistics(){
        if(portfolioRepository.findAll().isEmpty()){
            Map<?, ?> responseBody = Map.of("status", AppConstant.failureStatus, "data", AppConstant.getNoDataAvailableMessage);
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body(responseBody);
        }
        Map<?, ?> statistics = Map.of("users", getTotalUsers(), "orders", getTotalOrders(), "portfolios", getTotalPortfolio(), "sellOrders", getTotalSellOrders(), "buyOrders", getTotalBuyOrders(), "systemLog", getTotalLog());
;        Map<?, ?> responseBody = Map.of("status", AppConstant.successStatus, "message", AppConstant.getDataSuccessMessage, "data", statistics);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseBody);
    }

}
