import java.util.ArrayList;

public class Item {

    //attributes of Item class
     private String ID; //I'll put this as String for now + only have getter(?)
     private String name;
     private double pricePerUnit;
    ArrayList<Review> reviews = new ArrayList<Review>();


     //where should I put this?


    //constructor
    public Item(String ID, String name, double pricePerUnit) {

        this.ID = ID;
        this.name = name;
        this.pricePerUnit = pricePerUnit;

    }

/*
    public void modifyItem() {

        String itemToModify = ItemScanner.readLine("Type ID to change item name: ");

        while (!itemList.contains(itemToModify)) {

            System.out.println("There is no item called " + itemToModify + " in the list.");
        }

        String newName = ItemScanner.readLine("Type a new name for the item: ");{
        //Working on it, should fix

        }

    }*/



// Getters and setters

    public String getID() {
        return ID;
    }

    public String getItemName() {
        return name;
    }

    public void setItemName(String name) {
        this.name = name;
    }

    public double getItemPricePerUnit() {
        return pricePerUnit;
    }

    public void setItemPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }
}

//+toString
/*
1. Main menu user interface -> select options, enter values for attributes
2. Facade -> middle man between BL and controller
3. Controller: all methods
4. Item, Review, Trancation: attributes, constructors. getters, setters, toString.

*/




