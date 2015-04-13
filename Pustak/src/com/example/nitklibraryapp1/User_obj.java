package com.example.nitklibraryapp1;

public class User_obj {
	
	//private int id;
    private String book_name,author;
    private int availability;
    //private double price;
   
    public User_obj(){
        super();
    }
   
    public User_obj( String book_name,String author,int availability) {
        super();
       // this.username = username;
        this.book_name = book_name;
        this.author = author;
        this.availability = availability;
        //this.expertise = expertise;
    }

    @Override
    public String toString() {
        return this.book_name + "" + this.author + " " + this.availability   ;
    }

}
