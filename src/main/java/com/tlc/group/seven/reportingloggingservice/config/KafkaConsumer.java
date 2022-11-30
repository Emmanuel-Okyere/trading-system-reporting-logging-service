package com.tlc.group.seven.reportingloggingservice.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tlc.group.seven.reportingloggingservice.model.LogData;
import com.tlc.group.seven.reportingloggingservice.service.LogDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @Autowired
    private LogDataService dataService;

    @KafkaListener(topics = "log-data", groupId = "logDataGroup")
    public void consume(String data) throws JsonProcessingException {
        LogData log = new ObjectMapper().readValue(data, LogData.class);

        LOGGER.info(String.format("LogData:: received -> %s", data));
        LogData logData = new LogData(log.getTitle(), log.getEvent(), log.getDescription(), log.getService(), log.getTimestamp());
        dataService.insertLogData(logData);
    }
}