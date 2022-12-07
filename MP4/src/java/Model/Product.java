package Model;

/* Represents vailable item for sale on the website */

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.TreeSet;
import javax.servlet.ServletContext;

public class Product {
    private int id;
    private String name;
    private double price;
    private double basePrice;
    private String imgURL;
    private String description;
    private String category;
    private int quantity;

    public Product(int id, String name, double price, String imgURL, String description, String category){
        this.id = id;
        this.name = name;
        this.basePrice = price;
        this.imgURL = imgURL;
        this.description = description;
        this.category = category;
        this.quantity = 1;
    }

    // setters and
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
    
    public String getCategory(){
        return this.category;
    }
    
    public int getQuantity(){
        return this.quantity;
    }
    
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    
    public double getBasePrice(){
        return this.basePrice;
    }
    
    // TODO: add desc
    public static List<Product> readProductsFile(ServletContext servletContext){
 
        List<Product> list = new ArrayList<Product>();
        try{  
            InputStream ins = servletContext.getResourceAsStream("/files/products.csv");
            InputStreamReader isr = new InputStreamReader(ins);
            BufferedReader reader = new BufferedReader(isr);
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] byComma = line.split(",");
                byComma[4]=byComma[4].replaceAll("[%]%c\\W", ",");
                list.add(new Product(Integer.parseInt(byComma[0]), 
                                     byComma[1], 
                                     Double.parseDouble(byComma[2]), 
                                     byComma[3], 
                                     byComma[4], 
                                     byComma[5]));
            }
        }catch (IOException e){  
            e.printStackTrace();  
        }
        
        return list;
    }
    
    // given a string representing a category adds products from an input list 
    // into a new list whose with each element's category corresponding
    // with the input and outputs this a list of those products
    public static List<Product> sortByCategory(String category, List<Product> products){
        List<Product> list = new ArrayList<Product>();
            
            for(Product p: products){
                if(p.getCategory().matches(category)){
                    list.add(p);
                }
            }
            
        return list;
    }
    
    // given an integer searchId and list of products. iterate through products to find
    // a match with searchId then return the index of the match
    public static int searchProduct(int searchKey, List<Product> products){
        
        ListIterator<Product> productsIterator = products.listIterator();

        while(productsIterator.hasNext()){
            
            // succesful search
            if(productsIterator.next().getId() == searchKey){
                return productsIterator.previousIndex();
            } 
            
        }
             
        return -999;
    }
    
    public static boolean exists(int searchKey, ArrayList<Product> products){
        
        ListIterator<Product> productsIterator = products.listIterator();
        
        while(productsIterator.hasNext()){
            
            // succesful search
            if(productsIterator.next().getId() == searchKey){
                return true;  
            } 
            
        }
        
        return false;
    }
    
    public void updateTotalPrice(){
        this.price = this.quantity * this.basePrice;
    }
    
    public void incrementQuantity(){
        this.quantity++;
    }
    
    public void decrementQuantity(){
        this.quantity--;
    }
    
    public boolean isQuantityZero(){
        return this.quantity == 0;
    }
    
}
