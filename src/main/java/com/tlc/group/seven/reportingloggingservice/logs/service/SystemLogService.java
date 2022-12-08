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

    public ResponseEntity<?> getSystemLog(){
        if(systemLogRepository.findAll().isEmpty()){
            Map<?, ?> responseBody = Map.of("status", AppConstant.noContentStatus, "message", AppConstant.getNoDataAvailableMessage);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(responseBody);
        }
        Map<?, ?> responseBody = Map.of("status", AppConstant.successStatus, "message", AppConstant.getDataSuccessMessage, "data", systemLogRepository.findAll());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseBody);
    }


}
