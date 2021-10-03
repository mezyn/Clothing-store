import java.util.ArrayList;
import java.util.Arrays;

public class Controller {

    //For Item Lists
    private ArrayList<Item> itemList = new ArrayList<>();

    /*public ArrayList<Item> getItemList() {
        return itemList;
    }*/

    //Find index for user typed ID
    public Item findItem(String userID) {

        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getID().equals(userID)) {
                return itemList.get(i);
            }
        }
        return null;
    }

    //Check duplicate item ID
    public boolean containsItem(String itemID){

        for(int i = 0; i < itemList.size(); i++){
            if(itemList.get(i).getID().equals(itemID)){
                return true;
            }
        }
        return false;
    }

    //Create a new item and add it to itemList
    public String createItem(String itemID, String itemName, double unitPrice){
        Item item = new Item(itemID,itemName,unitPrice);
        itemList.add(item);
        return "";
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

    }
}