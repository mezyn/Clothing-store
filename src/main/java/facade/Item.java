package facade;

import java.util.ArrayList;

public class Item {

    //attributes of Item class
     private String ID; //I'll put this as String for now + only have getter(?)
     private String name;
     private double pricePerUnit;


    //constructor
    public Item(String ID, String name, double pricePerUnit) {

        this.ID = ID;
        this.name = name;
        this.pricePerUnit = pricePerUnit;

    }


    @Override
    public String toString() {

        return  this.ID + ": " + this.name + ". " + this.pricePerUnit + " SEK.";
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

}

