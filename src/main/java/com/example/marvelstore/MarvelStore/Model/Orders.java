package com.example.marvelstore.MarvelStore.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Orders")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Orders {

    @Id
    @Column(name="OrderId")
    private Integer id;

    private float OrderAmount;

    private Date OrderTime;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "UserId")
    private Users UserId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getOrderAmount() {
        return OrderAmount;
    }

    public void setOrderAmount(float orderAmount) {
        OrderAmount = orderAmount;
    }

    public Date getOrderTime() {
        return OrderTime;
    }

    public void setOrderTime(Date orderTime) {
        OrderTime = orderTime;
    }

    public Users getUserId() {
        return UserId;
    }

    public void setUserId(Users userId) {
        UserId = userId;
    }
}
