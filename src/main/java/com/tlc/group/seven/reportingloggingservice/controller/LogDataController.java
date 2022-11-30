package com.tlc.group.seven.reportingloggingservice.controller;

import com.tlc.group.seven.reportingloggingservice.model.LogData;
import com.tlc.group.seven.reportingloggingservice.service.LogDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
public class LogDataController {
    @Autowired
    private LogDataService dataService;

    @RequestMapping("/logs")
    public List<LogData> getLogData(){
        return dataService.getLogData();
    }
}
