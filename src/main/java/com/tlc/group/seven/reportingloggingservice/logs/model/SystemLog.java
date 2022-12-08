package com.tlc.group.seven.reportingloggingservice.logs.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class SystemLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String event;
    private String description;
    private String service;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    public SystemLog(int id, String title, String event, String description, String service, Date createdAt, Date updatedAt) {
        this.id = id;
        this.title = title;
        this.event = event;
        this.description = description;
        this.service = service;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public SystemLog(String title, String event, String description, String service) {
        this.title = title;
        this.event = event;
        this.description = description;
        this.service = service;
    }

}