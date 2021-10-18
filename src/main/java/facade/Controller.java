package facade;

import javax.swing.text.Utilities;
import java.util.*;


public class Controller {


    // -----------------------------COMMON METHODS----------------------------------

    //To change the number of decimal digits
    //How to use: 'value' is your original number input with all decimal digits,
    //and 'decimalPoint' is the number of decimal digits you would like to have.
    // e.g. if you write 'changeDecimal(199.999, 1) you'll get 199.9


    public static double changeDecimal(double value, int decimalDigit) {

        if (decimalDigit == 1) {
            value = value * Math.pow(10, 1);
            value = Math.floor(value);
            value = value / Math.pow(10, 1);

        } else if (decimalDigit == 2) {
            value = value * Math.pow(10, 2);
            value = Math.floor(value);
            value = value / Math.pow(10, 2);
        }
        return value;
    }

/*Don't think we need it, but will leave for now
    public double changeDecimalToOne(double value) { //for One decimal digit

        value = value * Math.pow(10, decimalPoint);
        value = Math.floor(value);
        value = value / Math.pow(10, decimalPoint);
        String sValue = (String) String.format("%.1f", value);
        Double newValue = Double.parseDouble(sValue);
        return newValue;
    }
        */

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
            //unitPrice = changeDecimal(unitPrice, 2);
            Item item = new Item(itemID, itemName, unitPrice);
            itemList.add(item);
            return "Item " + itemID + " was registered successfully.";
        }
    }

    public String updateItemName(String itemID, String newName) {

        if (!containsItem(itemID)) {
            return "Item " + itemID + " was not registered yet.";
        } else if (itemID.isBlank() || !containsItem(itemID) || newName.isBlank()) {
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
                //System.out.println(item);
                allItem += item + "\n";
            }
            return allItem;
        }

    }


    // ----------------------------------------------------------------------------------------


    public String getItemName(String itemID) { // In Use
        //Before
        /* String itemName = findItemName(itemID).getItemName();
        return itemName;*/

        //after
        return findItemName(itemID).getItemName();
    }
    //I'll use this to do the mean grade - Mijin
    public Item findItemName(String itemName) { //IN Use

        for (Item item : itemList) {
            if (item.getID().equals(itemName)) {
                return item;
            }
        }
        return null;
    }

    public String getItemPrice(String itemID) { //In use
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getID().equals(itemID)) {
                return String.valueOf(itemList.get(i).getItemPrice()); //
            }
        }
        return null;


    }

// -------------------------------------- FOR REVIEWS ---------------------------------------------------

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
            Item foundItem = findItem(ID);
            //item.getReviewList().add(review);
            Review review = new Review(reviewComment, reviewGrade);
            foundItem.registerReview(review);

            return "Your item review was registered successfully."; //Testing issue
        }
    }
// Second reviewItem

    public String reviewItem(String ID, int reviewGrade) {

        if (ID.isEmpty()) {
            return "ID needed to review item: ";
        } else if (!containsItem(ID)) {
            return "Item ID1 not found.";
            //"Item " + ID + " was not registered yet.";

        } else if (reviewGrade < 1.0 || reviewGrade > 5.0) {
            return "Grade values must be between 1 and 5.";
        } else {
            Item foundItem = findItem(ID);
            Review review = new Review(reviewGrade);
            foundItem.registerReview(review);
            return "Your item review was registered successfully.";
        }
    }
    /*item.getReviewList().add(review);
            Review review = new Review(ID, reviewComment, reviewGrade);
            reviewList.add(review);
            return "Your item review was registered successfully."; //Testing issue
        }*/


    public String getPrintedItemReview(String itemID, int reviewNumber) { // User story 3.2

        Item item = findItem(itemID);

        if (item == null) {
            return "Item " + itemID + " was not registered yet.";

        } else if (item.getReviewList().size()==0) {
            return "Item " + item.getItemName() + " has not been reviewed yet.";
        } else {
            if (reviewNumber < 1 || reviewNumber > item.getReviewList().size()) {
                return "Invalid review number. Choose between 1 and "
                        + item.getReviewList().size() + ".";
            } else {
                Review reviewItem = item.getReviewList().get(reviewNumber - 1);
                return  reviewItem.toString();
            }
        }
    }


    public String getPrintedReviews(String itemID) { // User Story 3.3

        Item itemToPrint = findItem(itemID);
        if (itemToPrint == null) {
            return "Item " + itemID + " was not registered yet.";
        }
        else if (itemToPrint.getReviewList().size()>0) {
            String printedOutput =  "Review(s) for " + itemID + ": "
                    + getItemName(itemID) + ". "
                    + getItemPrice(itemID) + " SEK" + System.lineSeparator();
            for (int i = 0; i < itemToPrint.getReviewList().size(); i++) {
                printedOutput += itemToPrint.getReviewList().get(i).toString()
                        + System.lineSeparator();

            }
            return printedOutput;
        } else  {
            String printedOutput =  "Review(s) for " + itemToPrint.toString() + System.lineSeparator();
            return printedOutput + "The item " + itemToPrint.getItemName() + " has not been reviewed yet.";
        }
    }

    ArrayList<String> commentsList = new ArrayList<String>();
    public ArrayList<String> getCommentsList(){
        return this.commentsList;
    }


    public List<String> getItemComments(String itemID) { //User Story 3.5 | PART 1#

        Item commentedItem = findItem(itemID);
        ArrayList<String> commentsList = new ArrayList<String>();

        if (commentedItem !=null) {
            for (int i = 0; i < commentedItem.getReviewList().size(); i++) {
                if(!commentedItem.getReviewList().get(i).getItemComment().trim().equals(""))
                    commentsList.add(commentedItem.getReviewList().get(i).getItemComment());

            }
        }
        return commentsList;
    }


    public String getItemCommentsPrinted(String itemID) { // User Story 3.5 | PART 2#
        String commentToPrint = "";

        for (String comments : getCommentsList())
            commentToPrint += comments + System.lineSeparator();

        return commentToPrint;
    }

    public String printAllReviews() { // User Story 3.6

        String head = "All registered reviews:" + System.lineSeparator();

        String textItem = "Review(s) for ";
        String reviewText = "";

        if (itemList.size() == 0) {
            System.out.println("No items registered yet.");
        }
        for (int i = 0; i < itemList.size(); i++) {
            if(!itemList.get(i).getReviewList().isEmpty()) {
                reviewText += "------------------------------------" + System.lineSeparator();
                reviewText += textItem + itemList.get(i).toString() + System.lineSeparator();
                for (Review review : itemList.get(i).getReviewList()) {
                    reviewText += review.toString() + System.lineSeparator();

                }
            }
        }
        return head + reviewText + "------------------------------------" + System.lineSeparator();
    }

//Test this first, and if it works properly it's easy to build printLeastReviwedItems()
    public String printMostReviewedItems(){


        return null;
    }
    public List<String> getLeastReviewedItems() {

        int reviewCounter = 0;
        int lowestReviewNumber = itemList.get(0).getReviewList().size(); //Set as the first item to start with
        ArrayList<Item> leastReviewedItems = new ArrayList<>();
        ArrayList<String> printLeastReviewedItems = new ArrayList<>();

        for (int i = 0; i < itemList.size(); i++) {
            reviewCounter += itemList.get(i).getReviewList().size();

            if (itemList.size() == 0) {
                System.out.println("No items registered yet.");
            } else if (reviewCounter == 0) {
                System.out.println("No items were reviewed yet.");
            } else {
                for (i = 0; i < itemList.size(); i++) {
                    if (itemList.get(i).getReviewList().size() < lowestReviewNumber) {
                        lowestReviewNumber = itemList.get(i).getReviewList().size();
                    }
                }
                for (i = 0; i < itemList.size(); i++) {
                    if (itemList.get(i).getReviewList().size() == lowestReviewNumber) {
                        printLeastReviewedItems.add(itemList.get(i).getID());
                    }
                }
            }
        }
        return printLeastReviewedItems;
    }

    public List<String> getMostReviewedItems() { //Passed test

        int reviewCounter = 0;
        int highestReviewNumber = itemList.get(0).getReviewList().size(); //Set as the first item to start with
        ArrayList<Item> mostReviewedItems = new ArrayList<>();
        ArrayList<String> printMostReviewedItems = new ArrayList<>();

        for (int i = 0; i < itemList.size(); i++) {
            reviewCounter += itemList.get(i).getReviewList().size();

            if (itemList.size() == 0) {
                System.out.println("No items registered yet.");
            } else if (reviewCounter == 0) {
                System.out.println("No items were reviewed yet.");
            } else {
                for (i = 0; i < itemList.size(); i++) {
                    if (itemList.get(i).getReviewList().size() > highestReviewNumber) {
                        highestReviewNumber = itemList.get(i).getReviewList().size();
                    }
                }
                for (i = 0; i < itemList.size(); i++) {
                    if (itemList.get(i).getReviewList().size() == highestReviewNumber) {
                        printMostReviewedItems.add(itemList.get(i).getID()); // removed to.String
                    }
                }
            }
        }
        return printMostReviewedItems;
    }
    /*public List<String> printMostReviewedItems() { // getMostReviewedItems

        int reviewCounter = 0;
        int highestReviewNumber = itemList.get(0).getReviewList().size(); //Set as the first item to start with
        ArrayList<Item> mostReviewedItems = new ArrayList<>();
        ArrayList<String> printMostReviewedItems = new ArrayList<>();

        for (int i = 0; i < itemList.size(); i++) {
            reviewCounter += itemList.get(i).getReviewList().size();

            if (itemList.size() == 0) {
                System.out.println("No items registered yet.");
            } else if (reviewCounter == 0) {
                System.out.println("No items were reviewed yet.");
            } else {
                for (i = 0; i < itemList.size(); i++) {
                    if (itemList.get(i).getReviewList().size() > highestReviewNumber) {
                        highestReviewNumber = itemList.get(i).getReviewList().size();
                    }
                }
                for (i = 0; i < itemList.size(); i++) {
                    if (itemList.get(i).getReviewList().size() == highestReviewNumber) {
                        printMostReviewedItems.add(itemList.get(i).toString());
                    }
                }
            }
        }
        return printMostReviewedItems;
    }*/

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
        return true;
    }

    public Review findReview(String itemID) {
        Item item = findItem(itemID);

        for (int i = 0; i < item.getReviewList().size(); i++) {
            if (item.getReviewList().get(i).equals(itemID)) {
                return item.getReviewList().get(i);
            }
        }
        return null;
    }
    /*  public Review findReview(String review) { // In case its wrong ^

        for (int i = 0; i < Item.getReviewList().size(); i++) {
            if (Item.getReviewList().get(i).getID().equals(itemID)) {
                return Item.getReviewList().get(i);
            }
        }
        return null;
    }*/


    //From here I did - Mijin

    public double getItemMeanGrade(String itemID) { //User Story 3.4
        Item item = findItem(itemID);

        double sumGrade = 0.0;
        double meanGrade = 0.0;
        if (!containsReview(itemID)) {
            System.out.println("Item " + itemID + "was not registered yet.");
        }
        else if(item.getReviewList().isEmpty()) meanGrade = 0.0;
        else if (findReview(itemID).getItemComment().isEmpty()) {
            System.out.println("Item " + itemID + " has not been reviewed yet.");
        } else {
            for (int i = 0; i < item.getReviewList().size(); i++) {
                    sumGrade += item.getReviewList().get(i).getItemGrade();
        }
             meanGrade = changeDecimal(sumGrade / item.getReviewList().size(), 2);
        }

        return meanGrade;
    }

    public int getNumberOfReviews(String itemID) {
        Item number = findItem(itemID);

        int reviewCounter = 0;
        for (int i=0; i<number.getReviewList().size(); i++) {
            if (number.getReviewList().get(i).equals(itemID)) { //getID() removed
                reviewCounter += 1;
            }
        }
        return reviewCounter;
    }



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

        totalProfit = changeDecimal(totalProfit, 2);
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
        sumProfit = changeDecimal(sumProfit, 2);
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

    public String printMostProfitableItems() {
        Transaction highestProfit = null;
        if (itemList.size() == 0) {
            return "No items registered yet.";
        } else if (transactionHistoryList.size() == 0) {
            return "No items ere bought yet.";
        } else if( !transactionHistoryList.isEmpty() ) {
            highestProfit = transactionHistoryList.get(0);
            for (int i = 1; i < transactionHistoryList.size(); i++) {
                Transaction currentTransaction = transactionHistoryList.get(i);
                if(currentTransaction.getProfit() > highestProfit.getProfit()) {
                    highestProfit = currentTransaction;
                }
            }
        } else {

            String mostProfitableItem = ("Most profitable items:\n" +
                    "Total profit: " + highestProfit + " SEK\n" +
                    highestProfit.toString());          //I will change more on it later
        }
        return printMostProfitableItems();
    }


    //-----------------------------------FOR Employee-----------------------------------

    ArrayList<Employee> employeeList = new ArrayList<>();

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }
    // Create Regular employee
    public String createEmployee(String employeeID, String employeeName, double grossSalary) {//throws Exception

        grossSalary = changeDecimal(grossSalary, 2);
        Employee newEmployee = new Employee(employeeID, employeeName, grossSalary);
        employeeList.add(newEmployee);

        return "Employee " + employeeID + " was registered successfully.";
    }

    //createEmployeeManager
    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree) {//throws Exception

        grossSalary = changeDecimal(grossSalary,2);
        Employee newManager = new EmployeeManager(employeeID, employeeName, grossSalary, degree);
        employeeList.add(newManager);

        return "Employee " + employeeID + " was registered successfully.";
        }

    //createEmployeeDirector
    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree, String department) {//throws Exception

        grossSalary = changeDecimal(grossSalary,2);
        Employee newDirector = new EmployeeDirector(employeeID, employeeName, grossSalary, degree, department);
        employeeList.add(newDirector);

        return "Employee " + employeeID + " was registered successfully.";
    }

    //createEmployeeIntern
    public String createEmployee(String employeeID, String employeeName, double grossSalary, int GPA) {//throws Exception

        grossSalary = changeDecimal(grossSalary,2);
        Employee newIntern = new EmployeeIntern(employeeID, employeeName, grossSalary, GPA);
        employeeList.add(newIntern);

        return "Employee " + employeeID + " was registered successfully.";
    }

    //I created this just in case, but might not needed?
    public Employee findEmployee(String employeeID) {

        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getID().equals(employeeID)) {
                return employeeList.get(i);
            }
        } return null;
    }

    public int findEmployeeIndex(String employeeID) {

        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getID().equals(employeeID)) {
                return i;
            }
        } return -1;
    }

    //US 5.5: Print a specific employee
    public String printEmployee(String employeeID) throws Exception {

        String outputMessage = "";
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getID().equals(employeeID)) {
                outputMessage = employeeList.get(i).toString();
            }
        } return outputMessage;
    }

    public double getNetSalary(String employeeID) throws Exception {

        double outputSalary = 0.0;
        for (int i = 0; i < employeeList.size(); i++) {
           if (employeeList.get(i).getID().equals(employeeID)) {
                outputSalary = employeeList.get(i).getNetSalary();
            }
        }
        return outputSalary;
    }

    // US 5.4
        public String removeEmployee(String empID) throws Exception {

        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getID().equals(empID)) {
                employeeList.remove(employeeList.get(i));
            }
        }
        return "Employee " + empID + " was successfully removed.";
    }

    //US 5.6
    public String printAllEmployees() throws Exception {

        String output = "All registered employees:" + System.lineSeparator();

        for (int i = 0; i < employeeList.size(); i++) {
            output += employeeList.get(i).toString() + System.lineSeparator();
        }
        return output;
    }

    public double getTotalNetSalary() throws Exception {

        double totalNetSalary = 0.0;

        for (int i = 0; i < employeeList.size(); i++) {
            totalNetSalary += employeeList.get(i).getNetSalary();
        }
        return changeDecimal(totalNetSalary,2 );
    }


    //Sorted by gross salary, in ascending order
    public String printSortedEmployees() throws Exception {

        Collections.sort(employeeList, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.compareTo(o2);
            }
        });

        String outputString = "Employees sorted by gross salary (ascending order):" + System.lineSeparator();
        for (int i = 0; i < employeeList.size(); i++) {
            outputString += employeeList.get(i).toString() + System.lineSeparator();
        }

        return outputString;
    }

    public String updateEmployeeName(String empID, String newName) throws Exception {

        Employee foundEmployee = findEmployee(empID);
        foundEmployee.setEmployeeName(newName);

        return "Employee " + empID + " was updated successfully";
    }

    public String updateInternGPA(String empID, int newGPA) throws Exception {

        Employee foundEmployee = findEmployee(empID);
        if (foundEmployee instanceof EmployeeIntern) {
            EmployeeIntern foundIntern = (EmployeeIntern) foundEmployee;
            foundIntern.setGPA(newGPA);
        }
        return "Employee " + empID + " was updated successfully";
    }

    public String updateManagerDegree(String empID, String newDegree) throws Exception {
        Employee foundEmployee = findEmployee(empID);
        if (foundEmployee instanceof EmployeeManager) {
            EmployeeManager foundManager = (EmployeeManager) foundEmployee;
            foundManager.setDegree(newDegree);
        }
        return "Employee " + empID + " was updated successfully";
    }

    public String updateDirectorDept(String empID, String newDepartment) throws Exception {
        Employee foundEmployee = findEmployee(empID);
        if (foundEmployee instanceof EmployeeDirector) {
            EmployeeDirector foundDirector = (EmployeeDirector) foundEmployee;
            foundDirector.setDepartment(newDepartment);
        }
        return "Employee " + empID + " was updated successfully";
    }

    public String updateGrossSalary(String empID, double newSalary) throws Exception {

        Employee foundEmployee = findEmployee(empID);
        foundEmployee.setGrossSalary(newSalary);

        return "Employee " + empID + " was updated successfully";
    }

    /* WORKING ON IT NOW
    public Map<String, Integer> mapEachDegree() throws Exception {

        HashMap <String, Integer> degreeMap = new HashMap<>();


    }*/

} //Don't delete this!! It's the most outer bracket




