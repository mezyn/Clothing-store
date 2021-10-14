package facade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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

    public double changeDecimal(double value) {

        value = value * Math.pow(10, 2);
        value = Math.floor(value);
        value = value / Math.pow(10, 2);
        return value;
    }

        public double changeDecimal2(double value) { //for two decimal digits

        /*value = value * Math.pow(10, decimalPoint);
        value = Math.floor(value);
        value = value / Math.pow(10, decimalPoint);*/
        String newString = String.valueOf(value);
        int index = 0;
        for(int i = 0;i<newString.length();i++){
            if(newString.charAt(i)=='.' || newString.charAt(i)==','){
                index = i;
            }
        }
        newString = newString.substring(0,index+3);
        double newValue = Double.valueOf(newString);
        //String sValue = (String) String.format("%.2f", value);
        //Double newValue = Double.parseDouble(sValue);
        return newValue;
    }

    public double changeDecimalToOne(double value) { //for One decimal digit

        /*value = value * Math.pow(10, decimalPoint);
        value = Math.floor(value);
        value = value / Math.pow(10, decimalPoint);*/
        String sValue = (String) String.format("%.1f", value);
        Double newValue = Double.parseDouble(sValue);
        return newValue;
    }

    //-----------------------------------FOR ITEMS-----------------------------------

     ArrayList<Item> itemList = new ArrayList<>();

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
            unitPrice = changeDecimal(unitPrice);
            Item item = new Item(itemID, itemName, unitPrice);
            itemList.add(item);
            return "Item " + itemID + " was registered successfully.";
        }
    }

    public String updateItemName(String itemID, String newName) {

        if (!containsItem(itemID)) {
            return "Item " + itemID + " was not registered yet.";
        } else if (itemID.isBlank() || !containsItem(itemID)) {
            return "Invalid data for item.";
        } else {
            Item foundItem = findItem(itemID);
            foundItem.setItemName(newName);
            return "Item " + itemID + " was updated successfully.";
        }
    }

    public String updateItemPrice(String itemID, double newPrice) {

        if (!containsItem(itemID)) {
            return "Item " + itemID + " was not registered yet.";
        } else if (newPrice < 0 || newPrice == 0) {
            return "Invalid data for item.";
        } else {
            Item foundItem = findItem(itemID);
            foundItem.setItemPrice(newPrice);
            return "Item " + itemID + " was updated successfully.";
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
    public Item findItem(String itemID) {

        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getID().equals(itemID)) {
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

            return changeDecimal(totalPrice);

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
                //System.out.println(item);
                allItem += item + "\n";
            }
            return allItem;
        }

    }

    //I don't need this method for Items. If you're using this method, then tell me, otherwise I'll remove it. -Mijin
    public String getItemID(String itemID) {
        String ID = findItemID(itemID).getID();
        return itemID;
    }

    //I don't need this method for Items. If you're using this method, then tell me, otherwise I'll remove it. -Mijin
    public Item findItemID(String itemID) {

        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getID().equals(itemID)) {
                return itemList.get(i);
            }
        }
        return null;
    }

    //I already have an exactly same method, named containsItem(). So delete this and use that one instead -Mijin
    public boolean containsItemID(String itemID) {

        for (int i = 0; i < getItemList().size(); i++) {
            if (getItemList().get(i).getID().equals(itemID)) {
                return true;
            }
        }
        return false;
    }


    // ----------------------------------------------------------------------------------------



    public Review findItemComment(String itemComment) {

        for (Review review : Item.getReviews()) {
            //the code below won't work, because here you're comparing 'review.getID()' and 'itemComment', which will
            //never be equal. So you need to add 'getItemComment()' after 'getID()', so that you're actually comparing
            //comment to comment.
            if (review.getID().equals(itemComment)) {
                return review;
            }
        }
        return null;
    }

    public boolean containsItemComment(String itemComment) {

        for (int i = 0; i < Item.getReviews().size(); i++) {
            if (Item.getReviews().get(i).getID().equals(itemComment)) {
                return true;
            }
        }
        return false;
    }

    public String getItemGrade(String itemID) {
        double itemGrade = findItemGrade(itemID).getItemGrade();
        return String.valueOf(itemGrade);
    }

    public Review findItemGrade(String itemGrade) {

        for (Review review : Item.getReviews()) {
            if (review.getID().equals(itemGrade)) {
                return review;
            }
        }
        return null;
    }

    public boolean containsItemGrade(String itemGrade) {

        for (int i = 0; i < Item.getReviews().size(); i++) {
            if (Item.getReviews().get(i).getID().equals(itemGrade)) {
                return true;
            }
        }
        return false;
    }


    public String getItemName(String itemID) {

        String itemName = findItemName(itemID).getItemName();

        return itemName;
    }


    public boolean containsItemName(String itemName) {

        for (int i = 0; i < Item.getReviews().size(); i++) {
            if (Item.getReviews().get(i).getID().equals(itemName)) {
                return true;
            }
        }
        return false;
    }

//I'll use this to do the mean grade - Mijin
    public Item findItemName(String itemName) {

        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getID().equals(itemName)) {
                return itemList.get(i);
            }
        }
        return null;
    }

    public String getItemPrice(String itemID) {
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getID().equals(itemID)) {
                return String.valueOf(itemList.get(i).getItemPrice()); //
            }
        }
        return null;


    }

    public boolean containsItemPrice(String itemPrice) {

        for (int i = 0; i < itemList.size(); i++) {
            if (Item.getReviews().get(i).getID().equals(itemPrice)) {
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
    /*ArrayList<Review> reviewList = new ArrayList<>();


    public ArrayList<Review> getReviewList() {
        return reviewList;
    }

     ArrayList<String> commentsList = new ArrayList<>();

    public ArrayList<String> getCommentsList() {
        return commentsList;
    }*/


    //Create Review 3.1
    public String reviewItem(String ID, String reviewComment, int reviewGrade) {

        if (ID.isEmpty()) {
            return "ID needed to review item: ";
        } else if (!containsItem(ID)) {
            return "Item ID1 not found.";
            //"Item " + ID + " was not registered yet.";

        } else if (reviewGrade < 1.0 || reviewGrade > 5.0) {
            return "Grade values must be between 1 and 5.";
        } else {
            Item founditem = findItem(ID);
            //item.getReviewList().add(review);
            Review review = new Review(reviewComment, reviewGrade);
            founditem.registerReview(review);
            return "Your item review was registered successfully."; //Testing issue
        }
    }
// Second reviewItem

    public String reviewItemWithoutComment(String ID, int reviewGrade) {

        if (ID.isEmpty()) {
            return "ID needed to review item: ";
        } else if (!containsItem(ID)) {
            return "Item ID1 not found.";
            //"Item " + ID + " was not registered yet.";

        } else if (reviewGrade < 1.0 || reviewGrade > 5.0) {
            return "Grade values must be between 1 and 5.";
        } else {
            Item founditem = findItem(ID);
            Review review = new Review(reviewGrade);
            founditem.registerReview(review);
            return "Your item review was registered successfully.";
        }
    }
    /*item.getReviewList().add(review);
            Review review = new Review(ID, reviewComment, reviewGrade);
            reviewList.add(review);
            return "Your item review was registered successfully."; //Testing issue
        }*/


    public String getPrintedItemReview(String itemID, int reviewNumber) { // User story 3.2
        //System.out.println("Size of list: " + reviewList.size()); // This line is just for us to see what to enter.

        if (containsItem(itemID)) {
           return "Item " + itemID + " was not registered yet.";

        } else if (!containsReview(itemID)) {
            return "Item " + getItemName(itemID) + " has not been reviewed yet.";
        } else {
            if (reviewNumber < 1 || reviewNumber > Item.reviews().size()) {
                return "Invalid review number. Choose between 1 and "
                        + Item.reviews().size() + ".";
            } else {
                Review reviewItem = Item.reviews().get(reviewNumber - 1);

            }
        }
        return null; // set to null for now so no error
    }


        /*if (reviewList.size() == 0) {
            System.out.println("No reviews have been added: "+ System.lineSeparator());
        } else {
            System.out.println("Index ");
            for (Review review : reviewList) {
                System.out.print("____________________________" + System.lineSeparator()+ review + System.lineSeparator());

            }
        }
        return "";
    }*/

    public String getPrintedReviews(String itemID) { //User story 3.3
        if (!containsItem(itemID)) {
            return "Item <" + itemID + "> was not registered yet.";

        } else if (!containsReview(itemID)) {
            return "Review(s) for " + itemID + ": "
                    + getItemName(itemID) + ". "
                    + getItemPrice(itemID) + " SEK" + System.lineSeparator();

        } else if (containsItem(itemID) && !Item.reviews().equals(itemID)) {

                return "Item " + getItemName(itemID) + " has not been reviewed yet.";

        } else if (containsReview(itemID)) {
            String message = "Review(s) for " + itemID + ": "
                    + getItemName(itemID) + ". "
                    + getItemPrice(itemID) + " SEK.";

            for (int i = 0; i < Item.reviews().size(); i++) {
                if (Item.getReviews().get(i).getID().equals(itemID)) {
                    return message + Item.getReviews().get(i).toString();

                }
            }
        }
        return null; // set to null for now so no error
    }

    public List<String> getItemComments(String itemID) { //User Story 3.5


        if (containsReview(itemID)) {
            for (int i = 0; i < Item.getReviews().size(); i++) {
                if (Item.getReviews().get(i).getID().equals(itemID)) {
                    commentsList.add(Item.getReviews().get(i).getItemComment());

                    /*}for (String review : commentsList) {
            System.out.println(itemID);
        }*/
                }
            }
        }
        return commentsList;
    }

    /*for(int i = 0; i <commentList.size();i++){
        System.out.println(commentsList.get(i));
    }*/



     public String printAllReviews() { // User Story 3.6
         String allReview = null;
         if (Item.getReviews().size() == 0) {
             return ("No items registered yet.");
         } else {
             allReview = "All registered reviews:" +
                     System.lineSeparator() +
                     "------------------------------------" +
                     System.lineSeparator();

             for (Review review : Item.getReviews()) {
                 System.out.println("Review(s) for <ID>: <Item Name>. <Price> SEK");
                 //"Review(s) for "+  +": "+ getItemName() +". "+ getItemName() +" SEK"); // ask TA

                 System.out.println(review);
                 allReview += review + System.lineSeparator();
             }
         }
         return allReview;


     }
// I rewrote the containsReview, but not sure if this'll work. Feel free to fix if you think this doesn't make sense -Mijin

    public boolean containsReview(String itemID) {

        for (int i = 0; i < getItemList().size(); i++) {
            if (getItemList().get(i).getID().equals(itemID)) {
                int nrOfreviews = getItemList().get(i).getReviewList().size();
                if (nrOfreviews == 0) {
                    return false;
                } else {
                return true;
            }
        }
    }

    public Review findReview(String itemID) {

        for (int i = 0; i < Item.getReviews().size(); i++) {
            if (Item.getReviews().get(i).getID().equals(itemID)) {
                return Item.getReviews().get(i);
            }
        }
        return null;
    }

    //From here I did - Mijin

    public double getItemMeanGrade(String itemID) {

        double sumGrade = 0.0;
        int counter = 0;

        if (!containsReview(itemID)) {
            System.out.println("Item " + itemID + "was not registered yet.");
        } else if (findReview(itemID).getItemComment().isEmpty()) {
            System.out.println("Item " + itemID + " has not been reviewed yet.");
        } else {
            for (int i = 0; i < Item.getReviews().size(); i++) {
                if (Item.getReviews().get(i).getID().equals(itemID)) {
                    sumGrade += Item.getReviews().get(i).getItemGrade();
                    counter += 1;
            }
        }
        }
        double meanGrade = changeDecimal(sumGrade / counter);
        return meanGrade;
    }

    public int getNumberOfReviews(String itemID) {

        int reviewCounter = 0;
        for (int i=0; i<Item.getReviews().size(); i++) {
            if (Item.getReviews().get(i).getID().equals(itemID)) {
                reviewCounter += 1;
            }
        }
        return reviewCounter;
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
    ArrayList<Transaction> transactionHistoryList = new ArrayList<Transaction>();

    public ArrayList<Transaction> getTransactionHistoryList(){
        return transactionHistoryList;
    }
    public double getTotalProfit() {

        double totalProfit = 0.0;
        for (int i = 0; i < transactionHistoryList.size(); i++)
            totalProfit += transactionHistoryList.get(i).getProfit();

        totalProfit = changeDecimal(totalProfit);
        return totalProfit;
    }

    public int getTotalUnitsSold() {

        int totalUnitsSold = 0;
        for (int i=0; i<transactionHistoryList.size(); i++) {
            totalUnitsSold += transactionHistoryList.get(i).getUnitsSold();
        }
        return totalUnitsSold;
    }

    public double getProfit(String itemID) {

        double sumProfit = 0.00;

        for (int i = 0; i < transactionHistoryList.size(); i++) {
            if (transactionHistoryList.get(i).getID().equals(itemID)) {
                sumProfit = sumProfit + transactionHistoryList.get(i).getProfit();
            }
        }
        if(sumProfit==0.0) System.out.println("No transactions have been registered for item " + itemID + " yet.");
        sumProfit = changeDecimal(sumProfit);
        return sumProfit;
    }
    public int getUnitsSolds(String itemID) { //should we change name to getUnitsSold?

        int sumUnitsSold = 0;

        for (int i = 0; i < transactionHistoryList.size(); i++) {
            if (transactionHistoryList.get(i).getID().equals(itemID)) {
                sumUnitsSold = sumUnitsSold + transactionHistoryList.get(i).getUnitsSold();
            } else {
                System.out.println("No transactions have been registered for item " + itemID + " yet.");
            }

        }
        return sumUnitsSold;
    }


    //to contain transaction for specific item ... (4.3)
    public boolean containsTransaction (String itemID) {

    for (int i = 0; i < transactionHistoryList.size(); i++) {
        if (transactionHistoryList.get(i).getID().equals(itemID)) {
            return true;
            }
        }
        return false;
    }

    // US 4.2 -Retrieve purchase data for a specific item

    public String printItemTransactions(String itemID) {

        if (!containsItem(itemID)) {
            return "Item " + itemID + " was not registered yet.";
        } else if (!containsTransaction(itemID)) {
            String message = "Transactions for item: " + findItem(itemID) + System.lineSeparator();
            return message + "No transactions have been registered for item " + itemID + " yet.";
        } else {
            String message = "Transactions for item: " + findItem(itemID) + System.lineSeparator();
            for (int i = 0; i < transactionHistoryList.size(); i++) {
                if (transactionHistoryList.get(i).getID().equals(itemID))
                message += transactionHistoryList.get(i).toString() + "\n";
            }
            return message;
        }
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


    public Transaction findItemTransactionHistory(String userID) {
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
        return totalTransactions;
        /*return totalTransactions;

        if (totalTransactions == 0) {
            "Total purchases made: 0 transactions");
        } else {
            for (int i = 0; i < totalTransactions; i++); {
            System.out.println("Total purchases made: <" + totalTransactions +"> transactions\n");
            }
        }
        return -1;
   */ }




    //   4.5 - Print all transactions
    public String printAllTransactions() {

        if (transactionHistoryList.size() == 0) {
            return ("All purchases made:\n" +
                    "Total profit: 0.00 SEK\n" +
                    "Total items sold: 0 units\n" +
                    "Total purchases made: 0 transactions\n" +
                    "------------------------------------\n" +
                    "------------------------------------\n");
        } else {

            String allTransactions = ("All purchases made:\n" +
                    "Total profit: " + getTotalProfit() + " total profit SEK\n" +
                    "Total items sold: " + getTotalUnitsSold() + " units\n" +
                    "Total purchases made: " + getTotalTransactions() + " transactions\n" +
                    "------------------------------------\n");

            for (Transaction transaction : transactionHistoryList) {
                allTransactions += transaction + "\n";
            }

            return (allTransactions + "------------------------------------\n");
        }

    }

    //-----------------------------------FOR Employee-----------------------------------

    ArrayList<Employee> employeeList = new ArrayList<>();

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary) throws Exception {

        grossSalary = changeDecimal(grossSalary);
        Employee newEmployee = new Employee(employeeID, employeeName, grossSalary );
        employeeList.add(newEmployee);

        return "Employee " + employeeID + "was registered successfully.";
    }

}

