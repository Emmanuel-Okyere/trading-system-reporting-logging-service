package com.tlc.group.seven.reportingloggingservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class LogData {

    private int id;
    private String title;
    private String event;
    private String description;
    private String timestamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "LogData{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", event='" + event + '\'' +
                ", description='" + description + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
