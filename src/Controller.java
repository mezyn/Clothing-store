import java.util.ArrayList;
import java.util.Arrays;

public class Controller {

    //For Item Lists
    private ArrayList<Item> itemList = new ArrayList<>();


    //Find index for user typed ID
    public Item findItem(String userID) {

        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getID().equals(userID)) {
                return itemList.get(i);
            }
        }
        return null;
    }

    //Check if item is already in the list by using ID
    public boolean containsItem(String itemID) {

        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getID().equals(itemID)) {
                return true;
            }
        }
        return false;
    }

    //Remove item
    public void removeItem(Item itemToRemove) {

        itemList.remove(itemToRemove);

    }

    //Create a new item and add it to itemList
    public String createItem(String itemID, String itemName, double unitPrice) {

        unitPrice = changeDecimal(unitPrice, 2);
        Item item = new Item(itemID, itemName, unitPrice);
        itemList.add(item);
        return "";
    }

    //To change decimal numbers
    public double changeDecimal(double value, int decimalpoint)
    {
        // Using the pow() method
        value = value * Math.pow(10, decimalpoint);
        value = Math.floor(value);
        value = value / Math.pow(10, decimalpoint);

        return value;
    }


    public String printAllItems() {

        if (itemList.size() == 0) {
            System.out.println("No items registered yet.");
        } else {
            System.out.println("All registered items:");
            for (Item item : itemList) {
                System.out.println(item);
            }
        }
        return "";
    }

    private ArrayList<Review> reviewList = new ArrayList<Review>();


    public void createReview(String ID, String comment, double grade) {
        Review review = new Review(ID, comment, grade);
        reviewList.add(review);

        // No need to check for duplicate review since different reviewers can enter same values.
    }


    public String printAllReview() {
        if (reviewList.size() == 0) {
            System.out.println("No reviews have been added:"+ System.lineSeparator());
        } else {
            System.out.println("All registered reviews: ");
            for (Review review : reviewList) {
                System.out.print("____________________________" + System.lineSeparator()+ review + System.lineSeparator());

            }
        }return "";
    }

    public boolean containsReview(String reviewID) {

        for (int i = 0; i < reviewList.size(); i++) {
            if (reviewList.get(i).getID().equals(reviewID)) {
                return true;
            }
        }
        return false;
    }
    public Review findReview(String reviewID) {

        for (int i = 0; i < reviewList.size(); i++) {
            if (reviewList.get(i).getID().equals(reviewID)) {
                return reviewList.get(i);
            }
        }
        return null;
    }

     /*public String meanReview(){
        if (reviewList.size() == 0) {
             System.out.println("No reviews have been added:"+ System.lineSeparator());
         }else {

        }
     }*/
}