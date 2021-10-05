import java.util.ArrayList;

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

    public double buyItem() { //(String itemID, int amount)

        double totalPrice;
        String itemID = UserInput.readLine("Type ID of item you want to purchase: ");

        if (!containsItem(itemID)) {
            return -1;

        } else {
            int amount = UserInput.readInt("Type the amount of items you want to purchase: ");
            double itemPrice = findItem(itemID).getItemPrice();

            if (amount < 4 || amount == 4) {
                totalPrice = itemPrice * amount;
            } else {
                totalPrice = 4 * itemPrice + ((amount - 4) * (itemPrice * (1.0 - 0.3)));
            }

            Transaction newTransaction = new Transaction(itemID, amount, totalPrice);
            transactionHistoryList.add(newTransaction);

            return totalPrice;

        }
    }

    //To change the number of decimal digits
    //How to use: 'value' is your original number input with all decimal digits,
    //and 'decimalPoint' is the number of decimal digits you would like to have.
    // e.g. if you write 'changeDecimal(199.999, 1) you'll get 199.9
    public double changeDecimal(double value, int decimalPoint)
    {
        // Using the pow() method
        value = value * Math.pow(10, decimalPoint);
        value = Math.floor(value);
        value = value / Math.pow(10, decimalPoint);

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

    public String printAnReview() { // Prints a review for one item
        if (reviewList.size() == 0) {
            System.out.println("No reviews have been added:"+ System.lineSeparator());
        } else {
            System.out.println("All registered   of review: ");
            for (Review review : reviewList) {
                System.out.print("____________________________" + System.lineSeparator()+ review + System.lineSeparator());

            }
        }return "";
    }
// _______________________________Mean Grade of Review____________________________________________
    public boolean containsGrade(String reviewGrade) {

        for (int i = 0; i < reviewList.size(); i++) {
            if (reviewList.get(i).getID().equals(reviewGrade)) {
                return true;
            }
        }
        return false;
    }
    public Review findGrade(String reviewGrade) {

        for (int i = 0; i < reviewList.size(); i++) {
            if (reviewList.get(i).getID().equals(reviewGrade)) {
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

    //creating a transaction but I still didn't figure out how to link it, so that when an item is bought it would be automatically created...
    private ArrayList<Transaction> transactionHistoryList = new ArrayList<Transaction>();

    public void createTransaction( String ID, int amount, double purchasePrice){

        Transaction transaction = new Transaction(ID, amount, purchasePrice);
        transactionHistoryList.add(transaction);
    }



    //to contain transaction for specific item ... (4.3)
    public boolean containsTransaction(String itemID) {
        for (int i = 0; i < transactionHistoryList.size(); i++) {
            if (transactionHistoryList.get(i).getID().equals(itemID)) {
                return true;
            }
        }
        return false;
    }


    //   4.5 - Print all transactions
    public String printAllTransactions() {

        if (transactionHistoryList.size() ==0) {
            System.out.println("No registered transactions.");
        } else {
            System.out.println("All registered transactions:");
            for (Transaction transaction : transactionHistoryList) {
                System.out.println(transaction);
            }
        }
        return "";

    }

}

