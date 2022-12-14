package com.tlc.group.seven.reportingloggingservice.portfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tlc.group.seven.reportingloggingservice.user.model.User;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Portfolio {
    @Id
    private Long iD;
    private String ticker;
    private int quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "users_id")
    private User users;
}
