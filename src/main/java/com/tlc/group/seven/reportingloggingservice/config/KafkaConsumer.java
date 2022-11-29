package com.tlc.group.seven.reportingloggingservice.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tlc.group.seven.reportingloggingservice.model.LogData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "log-data", groupId = "logDataGroup")
    public void consume(String logData) throws JsonProcessingException {
        LogData log = new ObjectMapper().readValue(logData, LogData.class);

        LOGGER.info(String.format("LogData received -> %s", logData));
    }
}