package com.tlc.group.seven.reportingloggingservice.logs.controller;

import com.tlc.group.seven.reportingloggingservice.logs.service.SystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin/reports")
public class SystemLogController {
    @Autowired
    private SystemLogService systemLogService;

    @RequestMapping("/logs")
    public ResponseEntity<?> getSystemLog(){
        return systemLogService.getSystemLog();
    }
}