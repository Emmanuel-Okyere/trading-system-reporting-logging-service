package com.tlc.group.seven.reportingloggingservice.config.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tlc.group.seven.reportingloggingservice.logs.model.SystemLog;
import com.tlc.group.seven.reportingloggingservice.logs.service.SystemLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @Autowired
    private SystemLogService dataService;

    @KafkaListener(topics = "log-data", groupId = "logDataGroup")
    public void consume(String data) throws JsonProcessingException {
        SystemLog log = new ObjectMapper().readValue(data, SystemLog.class);

        LOGGER.info(String.format("LogData:: received -> %s", data));
        SystemLog systemLog = new SystemLog(log.getTitle(), log.getEvent(), log.getDescription(), log.getService());
        dataService.insertLogData(systemLog);
    }
}