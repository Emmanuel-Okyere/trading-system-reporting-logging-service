package com.tlc.group.seven.reportingloggingservice.portfolio.service;

import com.tlc.group.seven.reportingloggingservice.constant.AppConstant;
import com.tlc.group.seven.reportingloggingservice.portfolio.model.Portfolio;
import com.tlc.group.seven.reportingloggingservice.portfolio.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PortfolioService {

    @Autowired
    PortfolioRepository portfolioRepository;

    public ResponseEntity<?> getUserPortfolio(){
        if(portfolioRepository.findAll().isEmpty()){
            Map<?, ?> responseBody = Map.of("status", "200", "data", AppConstant.getNoDataAvailableMessage);
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body(responseBody);
        }
        Map<?, ?> responseBody = Map.of("status", AppConstant.successStatus, "message", AppConstant.getDataSuccessMessage, "data", portfolioRepository.findAll());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseBody);
    }
}
