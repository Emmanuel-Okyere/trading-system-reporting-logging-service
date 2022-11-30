package com.tlc.group.seven.reportingloggingservice.logs.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@ToString
@RequiredArgsConstructor
@Entity
public class LogData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String event;
    private String description;
    private String service;
    private Date timestamp;

    public LogData(String title, String event, String description, String service, Date timestamp) {
        this.title = title;
        this.event = event;
        this.description = description;
        this.service = service;
        this.timestamp = timestamp;
    }
}