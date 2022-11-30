package com.tlc.group.seven.reportingloggingservice.order.model;

import com.tlc.group.seven.reportingloggingservice.user.model.User;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "orders")
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
    private Date createdAt;
    private Date updatedAt;

    @Override
    public String toString() {
        return "Order{" +
                "iD=" + iD +
                ", product='" + product + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", side='" + side + '\'' +
                ", orderId='" + orderId + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", users=" + users +
                '}';
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "users_id")
    private User users;

    public void setUser(User user){
        this.users= user;
    }
}
