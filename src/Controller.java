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
        return itemList.get(-1);
    }

    //Check duplicate item ID
    public boolean isDuplicate(String userID){

        for(int i = 0; i < itemList.size(); i++){
            if(itemList.get(i).getID().equals(userID)){
                return true;
            }
        }
        return false;
    }

    //Create a new item and add it to itemList
    public void createItem(String ID, String name, double pricePerUnit){
        Item item = new Item(ID,name,pricePerUnit);
        itemList.add(item);
    }

    public void printAllItems() {

        if (itemList.size() == 0) {
            System.out.println("No items registered yet.");
        } else {
        System.out.println("All registered items:");
            for (Item item : itemList) {
                System.out.println(item);
            }
        }

    }

    private ArrayList<Review> reviewList = new ArrayList<Review>();


    public void createReview(String ID, String comment, double grade) {
        Review review = new Review(ID, comment, grade);
        reviewList.add(review);

    }
}