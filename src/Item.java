import java.util.ArrayList;

public class Item {

    //attributes of Item class
     private String ID; //I'll put this as String for now + only have getter(?)
     private String name;
     private double pricePerUnit;
     //for review
     private double grade;
     private String comment;

     //private ArrayList<Item> itemList = new ArrayList<Item>();

     //where should I put this?


    //constructor
    public Item(String ID, String name, double pricePerUnit, double grade, String comment) {

        this.ID = ID;
        this.name = name;
        this.pricePerUnit = pricePerUnit;
        this.grade = grade;
        this.comment = comment;

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

    public double getGrade(){
        return this.grade;
    }

    public String getComment () {
        return this.comment;
    }

}

