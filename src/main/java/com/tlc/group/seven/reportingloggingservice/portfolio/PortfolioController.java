package com.tlc.group.seven.reportingloggingservice.portfolio;

import com.tlc.group.seven.reportingloggingservice.portfolio.model.Portfolio;
import com.tlc.group.seven.reportingloggingservice.portfolio.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/reports/portfolio")
public class PortfolioController {

    @Autowired
    PortfolioService portfolioService;

    @RequestMapping
    public ResponseEntity<List<Portfolio>> getUserPortfolio(){
        if(portfolioService.getUserPortfolio().isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(portfolioService.getUserPortfolio());
    }
}
