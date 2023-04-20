package org.example;

public class Clothes {
    private String image;
    private String name;
    private int price;
    public Clothes(String image, String name, int price){
        this.image = image;
        this.name = name;
        this.price = price;
    }
    public String getImage(){
        return this.image;

    }
    public String getName(){
        return this.name;
    }
    public int getPrice(){
        return this.price;
    }
}
