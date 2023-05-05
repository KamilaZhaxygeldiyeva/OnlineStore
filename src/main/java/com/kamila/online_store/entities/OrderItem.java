package com.kamila.online_store.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "order_items")
@Data
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "order_details_id")
    private OrderDetails orderDetails;

    @OneToOne
    private Clothes product;

    private int quantity;

    public OrderItem(OrderDetails orderDetails, Clothes product, int quantity) {
        this.orderDetails = orderDetails;
        this.product = product;
        this.quantity = quantity;
    }

    // for Thymeleaf
    public OrderItem() {
    }
}
