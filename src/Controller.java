import java.util.ArrayList;

public class Controller {

    private ArrayList<Item> itemList = new ArrayList<Item>();

    public boolean checkForDuplicates(String userID){

        for(int i = 0;i<itemList.size();i++){
            if(itemList.get(i).getID().equals(userID)){
                return true;
            }
        }
        return false;
    }

    public void createItem(String id, String name, double price){
        Item item = new Item(id,name,price);
        itemList.add(item);
}


    private ArrayList<Review> reviewList = new ArrayList<Review>();

    public void createReview(String ID, String comment, double grade) {
        Review review = new Review(ID, comment, grade);
        reviewList.add(review);

    }
}