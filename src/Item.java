
public class Item {

    //attributes of Item class
    private String ID; //I'll put this as String for now /Mijin
    String name;
    double pricePerUnit;


    //constructor
    public Item(String ID, String name, double pricePerUnit) {

        this.ID = ID;
        this.name = name;
        this.pricePerUnit = pricePerUnit;

    }

    //method for creating items
    public static Item createItem(){

        String ID = UserInput.readLine("Type ID of item: ");
        String name = UserInput.readLine("Type name of item: ");
        double pricePerUnit = UserInput.readDouble("Type unit price of item: ");

        Item newItem = new Item(ID, name, pricePerUnit);
        System.out.println(name + " " + ID + " was registered successfully.");

        return newItem;

        //Question to TA: where should we close the scanner?


    }

}

