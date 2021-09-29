import java.util.ArrayList;

public class Item {

    //attributes of Item class
     private final String ID; //I'll put this as String for now
     private String name;
     private double pricePerUnit;


    //constructor
    public Item(String ID, String name, double pricePerUnit) {

        this.ID = ID;
        this.name = name;
        this.pricePerUnit = pricePerUnit;

    }

    //ArrayList for items
    //Declare in the attribute, initialize in the method
    public static ArrayList<Item> itemList = new ArrayList<>();


    //method for creating items
    public static void createItem(){

        String ID = UserInput.readLine("Type ID of item: ");
        String name = UserInput.readLine("Type name of item: ");
        double pricePerUnit = UserInput.readDouble("Type unit price of item: ");

        Item newItem = new Item(ID, name, pricePerUnit);
        System.out.println(name + " " + ID + " was registered successfully.");

        itemList.add(newItem);

        //Question to TA: where should we close the scanner?

    }

    public void modifyItem() {

        String itemToModify = UserInput.readLine("Type ID to change item name: ");

        while (!itemList.contains(itemToModify)) {

            System.out.println("There is no item called " + itemToModify + " in the list.");
        }

        String newName = UserInput.readLine("Type a new name for the item: ");
        //Working on it

        }




// Getters and setters
    public String getItemName() {
        return name;
    }

    public double getItemPricePerUnit() {
        return pricePerUnit;
    }

    public void setItemName(String name) {
        this.name = name;
    }

    public void setItemPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }



}

