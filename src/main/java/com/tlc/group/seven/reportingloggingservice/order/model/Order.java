package com.tlc.group.seven.reportingloggingservice.order.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tlc.group.seven.reportingloggingservice.portfolio.model.Portfolio;
import com.tlc.group.seven.reportingloggingservice.user.model.User;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "orders")
@ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iD;

    private String product;
    @NotNull
    private Integer quantity;
    @NotNull
    private Double price;

    private String type;

    private String side;
    @Column
    private String orderId;
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
    @JsonIgnoreProperties
    @NotNull
    @Transient
    private Long portfolioId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;

    public void setPortfolio(Portfolio portfolio){
        this.portfolio= portfolio;
    }
}