/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TuanPhan
 */
package project3;  

public class OrderBean {
    private String book,customer;  
    private int isbn, price;
    
    public int getISBN(){
        return isbn;
    }
    public void setISBN(int isbn){
        this.isbn = isbn;
    }
    public String getBook() {  
        return book;  
    }  
    public void setBook(String book) {  
        this.book = book;  
    }  
    public String getCustomer() {  
        return customer;  
    }  
    public void setCustomer(String customer) {  
        this.customer= customer;  
    } 
    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price = price;
    }
}
