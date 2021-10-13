package facade;

import java.util.ArrayList;


public class Controller {

    // -----------------------------COMMON METHODS----------------------------------

    //To change the number of decimal digits
    //How to use: 'value' is your original number input with all decimal digits,
    //and 'decimalPoint' is the number of decimal digits you would like to have.
    // e.g. if you write 'changeDecimal(199.999, 1) you'll get 199.9
/*
    DecimalFormat myFormatter = new DecimalFormat(pattern);
    String output = myFormatter.format(value);
System.out.println(value + " " + pattern + " " + output);*/

    public double changeDecimal(double value, int decimalPoint) {

        value = value * Math.pow(10, decimalPoint);
        value = Math.floor(value);
        value = value / Math.pow(10, decimalPoint);

        return value;
    }

    //-----------------------------------FOR ITEMS-----------------------------------

    public static ArrayList<Item> itemList = new ArrayList<>();

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    //Create a new item and add it to itemList
    public String createItem(String itemID, String itemName, double unitPrice) {

        if (containsItem(itemID)) {
            return "Invalid data for item.";
        } else if (itemID.isEmpty()) {
            return "Invalid data for item.";
        } else if (itemName.isEmpty()) {
            return "Invalid data for item.";
        } else if (unitPrice == 0 || unitPrice < 0) {
            return "Invalid data for item.";
        } else {
            unitPrice = changeDecimal(unitPrice, 2);

            Item item = new Item(itemID, itemName, unitPrice);
            itemList.add(item);
            return "Item " + itemID + " was registered successfully.";
        }
    }

    public String updateItemName(String IDInput, String newNameInput) {

        if (!containsItem(IDInput)){
            return "Item " +IDInput + " was not registered yet.";
        } else if (IDInput.isBlank() || !containsItem(IDInput)) {
            return "Invalid data for item.";
        } else {
            Item foundItem = findItem(IDInput);
            foundItem.setItemName(newNameInput);
            return "Item " + IDInput + " was updated successfully.";
        }
    }

    public String updateItemPrice(String IDInput, double newPriceInput) {

        if (!containsItem(IDInput)){
            return "Item " +IDInput + " was not registered yet.";
        } else if (newPriceInput < 0 || newPriceInput == 0) {
            return "Invalid data for item.";
        } else {
        Item foundItem = findItem(IDInput);
        foundItem.setItemPrice(newPriceInput);
        return "Item " + IDInput + " was updated successfully.";
        }
    }

    //Remove item
    public String removeItem(String itemID) {

        if (this.containsItem(itemID)) {
            Item itemToRemove = this.findItem(itemID);
            itemList.remove(itemToRemove);
            return "Item " + itemID + " was successfully removed.";
        } else {
            return "Item " + itemID + " could not be removed.";
        }
    }

    //Check if item is already in the list by using ID
    public boolean containsItem(String itemID) {

        for (int i = 0; i < getItemList().size(); i++) {
            if (getItemList().get(i).getID().equals(itemID)) {
                return true;
            }
        }
        return false;
    }

    //Find index for user typed ID
    public Item findItem(String userID) {

        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getID().equals(userID)) {
                return itemList.get(i);
            }
        }
        return null;
    }


    public double buyItem(String itemID, int amount) {

        double totalPrice;

        if (!containsItem(itemID)) {
            return -1;

        } else {

            double itemPrice = findItem(itemID).getItemPrice();

            if (amount < 4 || amount == 4) {
                totalPrice = itemPrice * amount;
            } else {
                totalPrice = 4 * itemPrice + ((amount - 4) * (itemPrice * (1.0 - 0.3)));
            }

            Transaction newTransaction = new Transaction(itemID, amount, totalPrice);
            transactionHistoryList.add(newTransaction);

            return changeDecimal(totalPrice, 2);

        }
    }

    public String printItem(String itemID) {

        if (containsItem(itemID)) {
            Item foundItem = findItem(itemID);
            return foundItem.toString();
        } else {
            return "Item " + itemID + " was not registered yet.";
        }
    }


    public String printAllItems() {

        if (itemList.size() == 0) {
            return "No items registered yet.";
        } else {
            String allItem = "All registered items:\n";

            for (Item item : itemList) {
                System.out.println(item);
                allItem += item + "\n";
            }
            return allItem;
        }

    }
    public String getItemID (String itemID){
        String ID = findItemID(itemID).getID();
        return itemID;
    }


    public Item findItemID(String itemID) {

        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getID().equals(itemID)) {
                return itemList.get(i);
            }
        }
        return null;
    }

    public boolean containsItemID(String itemID) {

        for (int i = 0; i < getItemList().size(); i++) {
            if (getItemList().get(i).getID().equals(itemID)) {
                return true;
            }
        }
        return false;
    }



    // ----------------------------------------------------------------------------------------
    public static  String getItemComment(String itemID){
        String itemComment = findItemComment(itemID).getItemComment();
        return String.valueOf(itemID);

    }

    public static Review findItemComment(String itemComment) {

        for (Review review : reviewList) {
            if (review.getID().equals(itemComment)) {
                return review;
            }
        }
        return null;
    }

    public boolean containsItemComment(String itemComment) {

        for (int i = 0; i < getReviewList().size(); i++) {
            if (getReviewList().get(i).getID().equals(itemComment)) {
                return true;
            }
        }
        return false;
    }

    public static String getItemGrade(String itemID){
        double itemGrade = findItemGrade(itemID).getItemGrade();
        return String.valueOf(itemGrade);
   }

    public static Review findItemGrade(String itemGrade) {

        for (Review review : reviewList) {
            if (review.getID().equals(itemGrade)) {
                return review;
            }
        }
        return null;
    }

    public boolean containsItemGrade(String itemGrade) {

        for (int i = 0; i < getReviewList().size(); i++) {
            if (getReviewList().get(i).getID().equals(itemGrade)) {
                return true;
            }
        }
        return false;
    }


    public static String getItemName(String itemID) {

        String itemName = findItemName(itemID).getItemName();

        return itemName;
    }


    public boolean containsItemName(String itemName) {

        for (int i = 0; i < getReviewList().size(); i++) {
            if (getReviewList().get(i).getID().equals(itemName)) {
                return true;
            }
        }
        return false;
    }



    public static Item findItemName(String itemName) {

        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getID().equals(itemName)) {
                return itemList.get(i);
            }
        }
        return null;
    }

    public static String getItemPrice(String itemID) {
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getID().equals(itemID)) {
                return String.valueOf(itemList.get(i).getItemPrice()); //
            }
        }
        return null;


    }

    public boolean containsItemPrice(String itemPrice) {

        for (int i = 0; i < itemList.size(); i++) {
            if (getReviewList().get(i).getID().equals(itemPrice)) {
                return true;
            }
        }
        return false;
    }

    public Item findItemPrice(String itemPrice) {

        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getID().equals(itemPrice)) {
                return itemList.get(i);
            }
        }
        return null;
    }

// -------------------------------------- FOR REVIEWS ---------------------------------------------------

    //does it have to be static? I know TA mentioned this but I didn't get why -Mijin
    static ArrayList<Review> reviewList = new ArrayList<>();



    public static ArrayList<Review> getReviewList() {
        return reviewList;
    }

    public static ArrayList<String> commentsList = new ArrayList<>();




    public static ArrayList<String> getcommentsList() {
        return commentsList;
    }

//Create Review 3.1
    public String reviewItem(String ID, String reviewComment, int reviewGrade) {
        Review review = new Review(ID, reviewComment, reviewGrade);
        reviewList.add(review);
        return "";
    }


    public String getPrintedItemReview(String itemID, int reviewNumber) {
        if (reviewList.size() == 0) {
            System.out.println("No reviews have been added: "+ System.lineSeparator());
        } else {
            System.out.println("Index ");
            for (Review review : reviewList) {
                System.out.print("____________________________" + System.lineSeparator()+ review + System.lineSeparator());

            }
        }
        return "";
    }


    public String printAllReviews() {
        if (reviewList.size() == 0) {
            System.out.println("No items registered yet.");
        } else {
            System.out.println("All registered items:");
            for (Review review : reviewList) {
                System.out.println(review);
            }
        }
        return "";


    }
//Temp
    public static String printAllcomments() {
        if (commentsList.size() == 0) {
            System.out.println("No items registered yet.");
        } else {
            System.out.println("All registered items:");
            for (String review : commentsList) {
                System.out.println(review);
            }
        }
        return "";


    }

    public static boolean containsReview(String itemID) {

        for (int i = 0; i < reviewList.size(); i++) {
            if (getReviewList().get(i).getID().equals(itemID)) {
                return true;
            }
        }
        return false;
    }
    public static Review findReview(String itemID) {

        for (int i = 0; i < reviewList.size(); i++) {
            if (reviewList.get(i).getID().equals(itemID)) {
                return reviewList.get(i);
            }
        }
        return null;
    }


  //_______________________________Mean Grade of Review____________________________________________

    /*public String getItemMeanGrade() {
          if (reviewList.size() == 0) {
              System.out.println("No reviews have been added:" + System.lineSeparator());
          } else {
              System.out.println("Grade of item: ");
          }
          for (Review reviewGrade : reviewList) {
              System.out.print( reviewGrade + System.lineSeparator());

          }
          return "";
      }*/

// --------------------------------------- FOR TRANSACTION HISTORY ---------------------------------------
    //creating a transaction
    public static ArrayList<Transaction> transactionHistoryList = new ArrayList<Transaction>();


    //to contain transaction for specific item ... (4.3)
    public boolean containsTransaction(String itemID) {
        for (int i = 0; i < transactionHistoryList.size(); i++) {
            if (transactionHistoryList.get(i).getID().equals(itemID)) {
                return true;
            }
        }
        return false;
    }

    /*
        User Story 4.2 - Retrieve purchase data for a specific item
        I want to retrieve different data about transactions of a specific item in order to get an overview of how profitable the item is.
        For a registered item ID specified by the user, the system should print three different summary data:
        Sum of all the profit made by purchasing that specific item.
        Sum of all units sold of that specific item.
        Total number of transactions registered for the specific item.
        If the item ID has not been registered or if no transaction for that item has been made, the system should return the value zero (0) for all operations above.

    */

    public String printItemTransactions(String itemID) {

        double sumProfit = 0.0;
        int sumUnitSold = 0;
        int transactionCounter = 0;

        for (int i=0; i < transactionHistoryList.size(); i++) {
            if (transactionHistoryList.get(i).getID().equals(itemID)) {
                sumProfit = sumProfit + transactionHistoryList.get(i).getProfit();
                sumUnitSold = sumUnitSold + transactionHistoryList.get(i).getUnitsSold();
                transactionCounter += 1;
            }

        }

        return "";
    }


    /*
        //get specific item transactions
    public static String getPurchasePrice(String itemID) {
        for (int i = 0; i < transactionHistoryList.size(); i++);
        if (transactionHistoryList.get(i).getID().equals(itemID)) {
            return String.valueOf(transactionHistoryList.get(i).getItemPurchase());
        }
        return "Can't find";
    }
*/


    public static Transaction findItemTransactionHistory(String userID) {
        for (int i = 0; i < transactionHistoryList.size(); i++) {
            if (transactionHistoryList.get(i).getID().equals(userID)) {
                return transactionHistoryList.get(i);
            }
        }
        return null;
    }



    //4.4  3. print total number of transactions
    public int getTotalTransactions() {
        int totalTransactions = transactionHistoryList.size();
        if (totalTransactions == 0) {
            System.out.println("Total purchases made: 0 transactions");
        } else {
            for (int i = 0; i < totalTransactions; i++); {
            System.out.println("Total purchases made: <" + totalTransactions +"> transactions\n");
            }
        }
        return -1;
    }



    //   4.5 - Print all transactions
    public String printAllTransactions() {

        if (transactionHistoryList.size() == 0) {
            System.out.println("All purchases made:\n" +
                    "Total profit: 0.00 SEK\n" +
                    "Total items sold: 0 units\n" +
                    "Total purchases made: 0 transactions\n" +
                    "----------------------------------------\n" +
                    "----------------------------------------");
        } else {


            System.out.println("All purchases made:\n" +
                    "Total profit: <total profit> SEK\n" +
                    "Total items sold: <total units> units\n" +
                    "Total purchases made: <total transactions> transactions");

            for (Transaction transaction : transactionHistoryList) {
                System.out.println(transaction.toString());
            }

            System.out.println("------------------------------------\n" + "\n");
        }
        return "";

    }

    //-----------------------------------FOR Employee-----------------------------------

    private static ArrayList<Item> employeeList = new ArrayList<>();

    public ArrayList<Item> getEmployeeList() {
        return employeeList;
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary) throws Exception {

        return "";
    }

}

