package com.tlc.group.seven.reportingloggingservice.logs.controller;

import com.tlc.group.seven.reportingloggingservice.logs.model.LogData;
import com.tlc.group.seven.reportingloggingservice.logs.service.LogDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/reports")
public class LogDataController {
    @Autowired
    private LogDataService logDataService;

    @RequestMapping("/logs")
    public ResponseEntity<List<LogData>> getLogData(){
        if(logDataService.getLogData().isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(logDataService.getLogData());
    }
}
