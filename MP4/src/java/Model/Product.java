package Model;

/* Represents vailable item for sale on the website */

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Product {
    private int id;
    private String name;
    private double price;
    private String imgURL;
    private String description;

    public Product(int id, String name, double price, String imgURL, String description){
        this.id = id;
        this.name = name;
        this.price = price;
        this.imgURL = imgURL;
        this.description = description;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getPrice(){
        return this.price;
    }

    public void setPrice(String price){
        this.name = price;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.name = description;
    }
    
    public String getImgURL(){
        return this.imgURL;
    }

}
