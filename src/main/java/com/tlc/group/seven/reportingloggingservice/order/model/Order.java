package com.tlc.group.seven.reportingloggingservice.order.model;

import com.tlc.group.seven.reportingloggingservice.portfolio.model.Portfolio;
import lombok.Data;
import lombok.ToString;

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

    private Integer quantity;

    private Double price;

    private String type;

    private String side;

    private String orderId;
    private String orderStatus;

    private Date createdAt;

    private Date updatedAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;

    public void setPortfolio(Portfolio portfolio){
        this.portfolio= portfolio;
    }
}