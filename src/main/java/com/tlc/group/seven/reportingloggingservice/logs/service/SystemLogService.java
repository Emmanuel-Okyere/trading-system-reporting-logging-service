package com.tlc.group.seven.reportingloggingservice.logs.service;

import com.tlc.group.seven.reportingloggingservice.constant.AppConstant;
import com.tlc.group.seven.reportingloggingservice.logs.model.SystemLog;
import com.tlc.group.seven.reportingloggingservice.logs.repository.SystemLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SystemLogService {
    @Autowired
    private SystemLogRepository systemLogRepository;

    public void insertLogData(SystemLog systemLog){
        systemLogRepository.save(systemLog);
    }

    public List<SystemLog> getSystemLog(){
        return systemLogRepository.findAll();
    }

}
