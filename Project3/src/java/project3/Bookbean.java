/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

/**
 *
 * @author TuanPhan
 */
public class Bookbean {
    private int isbn, price, edition;
    private String title, author;
    
    public int getISBN(){
        return isbn;
    }
    public void setISBN(int isbn){
        this.isbn = isbn;
    }
    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public int getEdition(){
        return edition;
    }
    public void setEdition(int edition){
        this.edition = edition;
    }
    
}
