package com.tlc.group.seven.reportingloggingservice.statistics.controller;

import com.tlc.group.seven.reportingloggingservice.statistics.model.Statistics;
import com.tlc.group.seven.reportingloggingservice.statistics.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/admin/reports")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @RequestMapping("/statistics")
    public ResponseEntity<?> getStatistics(){
        return statisticsService.getStatistics();
    }

}
