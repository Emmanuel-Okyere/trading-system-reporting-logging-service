package com.tlc.group.seven.reportingloggingservice.logs.controller;

import com.tlc.group.seven.reportingloggingservice.logs.model.SystemLog;
import com.tlc.group.seven.reportingloggingservice.logs.service.SystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/admin/reports")
public class SystemLogController {
    @Autowired
    private SystemLogService systemLogService;

    @RequestMapping("/logs")
    public ResponseEntity<?> getLogData(){
        if(systemLogService.getSystemLog().isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(systemLogService.getSystemLog());
    }
}