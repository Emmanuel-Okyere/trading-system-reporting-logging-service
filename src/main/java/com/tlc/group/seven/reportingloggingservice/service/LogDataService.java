package com.tlc.group.seven.reportingloggingservice.service;

import com.tlc.group.seven.reportingloggingservice.model.LogData;
import com.tlc.group.seven.reportingloggingservice.repository.LogDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogDataService {
    @Autowired
    private LogDataRepository dataRepository;

    public void insertLogData(LogData logData){
        dataRepository.save(logData);
    }

    public List<LogData> getLogData(){
        return dataRepository.findAll();
    }
}
