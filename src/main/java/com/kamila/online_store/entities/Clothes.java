package com.kamila.online_store.entities;

import com.kamila.online_store.util.Utils;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
public class Clothes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private double price;
    private int inStock;

    @Enumerated(EnumType.STRING)

    @Column(name = "size")
    private Size sizes;
    @Enumerated(EnumType.STRING)
    @Column(name = "types")
    private Type types;
    public enum Size {
        XS, S, L, M
    }
    public enum Type {
        Tops, Dresses, Bottoms, Shoes, Accessories, OuterWear
    }

    public Clothes() {
    }

    public Clothes(String name, double price, int inStock) {
        this.name = name;
        this.price = price;
        this.inStock = inStock;

    }

    // Two digits (cents) after the decimal point format
    public String getPriceForDisplay() {
        return Utils.moneyToDisplay(price);
    }
}
