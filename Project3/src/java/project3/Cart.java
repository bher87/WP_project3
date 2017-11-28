package project3;

import java.util.HashMap;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dilukshan Mahendra
 */
public class Cart {

    HashMap<String, Integer> books;
    public Cart(){
     books = new HashMap<>();
      
    }
    public HashMap getItems(){
        return books;
    }
    public void addToCart(String title, int price){
        books.put(title, price);
    }
}
