package facade;

import java.util.ArrayList;
import java.text.DecimalFormat;
import java.util.Collection;

public class Item {


    //attributes of Item class
     private String ID; //I'll put this as String for now + only have getter(?)
     private String name;
     private double pricePerUnit;
     private  ArrayList<Review> reviewList= new ArrayList<Review>;


    //constructor
    public Item(String ID, String name, double pricePerUnit) {

        this.ID = ID;
        this.name = name;
        this.pricePerUnit = pricePerUnit;
    }

    public void registerReview(Review review) {

        this.reviewList.add(review);

    }



    @Override
    public String toString() {

        DecimalFormat decimal2 = new DecimalFormat("###.00");
        String stringPrice = decimal2.format(this.pricePerUnit);
        return  this.ID + ": " + this.name + ". " + stringPrice + " SEK";
    }


// Getters and setters

    public String getID() {
        return ID;
    }

    public String getItemName() {
        return name;
    }

    public void setItemName(String newNameInput) {
        this.name = newNameInput;
    }

    public double getItemPrice() {
        return pricePerUnit;
    }

    public void setItemPrice(double newPriceInput) {
        this.pricePerUnit = newPriceInput;
    }

    public ArrayList<Review> getReviewList(){
        return this.reviewList;
    }

}

