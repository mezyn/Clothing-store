package facade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
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
        for (int i = 0; i < newString.length(); i++) {
            if (newString.charAt(i) == '.' || newString.charAt(i) == ',') {
                index = i;
            }
        }
        newString = newString.substring(0, index + 3);
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
                return reviewItem.toString();
            }
        }
    }
/* public  Review findReview(String itemID) {


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


    public String getPrintedReviews(String itemID) { // User Story 3.3

        Item itemToPrint = findItem(itemID);
        if (itemToPrint == null) {
            return "Item " + itemID + " was not registered yet.";
        }
        else if (itemToPrint.getReviewList().size()>0) {
            String build =  "Review(s) for " + itemID + ": "
                    + getItemName(itemID) + ". "
                    + getItemPrice(itemID) + " SEK" + System.lineSeparator();
            for (int i = 0; i < itemToPrint.getReviewList().size(); i++) {
                    build += itemToPrint.getReviewList().get(i).toString();

            }
            return build;
        } else  {
            return "Item " + itemToPrint.getItemName() + " has not been reviewed yet.";
        }
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

    public String getItemCommentsPrinted(String itemID){ // User Story 3.5 | PART 2#


        return "";

    }

/*Users want to read all comments written for a reviewed item so that they can see the general opinion of previous customers.
When retrieving all comments, users must specify an item ID. For this user story, only the written comments are retrieved
and can be iterated as a collection of strings.
If the item ID was not registered or if the item has no reviews or written comments in it,
the system should return an empty collection.
*/

    public String printAllReviews() { // User Story 3.6 // Saved old code in NOT_USED_CODE.JAVA

        String message = "All registered reviews:" +
                System.lineSeparator() +
                "------------------------------------" +
                System.lineSeparator();
        String messageToString = "Review(s) for " + toString();

        for (Item item : getItemList()){
            return messageToString;

            for (Review review : item.getReviewList()){
                return message + review + System.lineSeparator();

            }
        }
    }



/*
    public String printMostReviewedItems() {

        if (Item.getReviewList().isEmpty()) {
            return "No items registered yet.";
        } else if (!getItemList().isEmpty() && Item.getReviewList() == 0) {
            return "No items were reviewed yet.";
        } else if (!(getItemList() && Item.getReviewList() == 0)) { //Not(item list and review list= 0) = there contains something in both

            for (Review review : Item.getReviewList()) {
                if ()
            }



            }

        }

    }

    ArrayList<String> mostReviewItemList = new ArrayList<>();

    public ArrayList<String> getMostReviewItemList() {
        return mostReviewItemList;
    }

    public List<String> getMostReviewedItems(String itemID) {

        if (containsReview(itemID)) {
            for (int i = 0; i < Item.getReviewList().size(); i++) {
                if (Item.getReviewList().get(i).getID().equals(itemID)) {
                    mostReviewItemList.add(Item.getReviewList().get(i).getItemReview());

                }
            }
        }
        return ;
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
        return true;
    }
        /*public Review findReview(String review) {
          Item item = findItem(itemID);

           for (int i = 0; i < Item.getReviews().size(); i++) {
               if (Item.getReviews().get(i).getID().equals(itemID)) {
                   return Item.getReviews().get(i);
               }
           }
           return null;
       }*/
    public Review findReview(String itemID) {
        Item item = findItem(itemID);

        for (int i = 0; i < item.getReviewList().size(); i++) {
            if (item.getReviewList().get(i).equals(itemID)) {
                return item.getReviewList().get(i);
            }
        }
        return null;
    }
    /*  public Review findReview(String review) { // In case its wrong

        for (int i = 0; i < Item.getReviewList().size(); i++) {
            if (Item.getReviewList().get(i).getID().equals(itemID)) {
                return Item.getReviewList().get(i);
            }
        }
        return null;
    }*/


    //From here I did - Mijin

    public double getItemMeanGrade(String itemID) {
        Item amazingCool = findItem(itemID);

        double sumGrade = 0.0;
        int counter = 0;

        if (!containsReview(itemID)) {
            System.out.println("Item " + itemID + "was not registered yet.");
        } else if (findReview(itemID).getItemComment().isEmpty()) {
            System.out.println("Item " + itemID + " has not been reviewed yet.");
        } else {
            for (int i = 0; i < amazingCool.getReviewList().size(); i++) {
                if (amazingCool.getReviewList().get(i).equals(itemID)) { // Revmoved getID()
                    sumGrade += amazingCool.getReviewList().get(i).getItemGrade();
                    counter += 1;
            }
        }
        }
        double meanGrade = changeDecimal(sumGrade / counter);
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

    ArrayList<EmployeeManager> employeeManagerList = new ArrayList<>();
    public ArrayList<EmployeeManager> getEmployeeManagerList() {
        return employeeManagerList;
    }

    ArrayList<EmployeeDirector> employeeDirectorList = new ArrayList<>();
    public ArrayList<EmployeeDirector> getEmployeeDirectorList() {
        return employeeDirectorList;
    }

    ArrayList<EmployeeIntern> employeeInternList = new ArrayList<>();
    public ArrayList<EmployeeIntern> getEmployeeInternList() {
        return employeeInternList;
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary) throws Exception {

        grossSalary = changeDecimal(grossSalary);
        Employee newEmployee = new Employee(employeeID, employeeName, grossSalary );
        employeeList.add(newEmployee);

        return "Employee " + employeeID + "was registered successfully.";
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree) throws Exception {

        grossSalary = changeDecimal(grossSalary);
        EmployeeManager newEmployeeManager = new EmployeeManager(employeeID, employeeName, grossSalary, degree );
        employeeManagerList.add(newEmployeeManager);

        return "Employee " + employeeID + "was registered successfully.";
        }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree, String dept) throws Exception {
        grossSalary = changeDecimal(grossSalary);
        EmployeeDirector newEmployeeDirector = new EmployeeDirector(employeeID, employeeName, grossSalary, degree, dept );
        employeeDirectorList.add(newEmployeeDirector);

        return "Employee " + employeeID + "was registered successfully.";
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, int gpa) throws Exception {
        grossSalary = changeDecimal(grossSalary);
        EmployeeIntern newEmployeeIntern = new EmployeeIntern(employeeID, employeeName, grossSalary, gpa);
        employeeInternList.add(newEmployeeIntern);

        return "Employee " + employeeID + "was registered successfully.";
    }

    public boolean containsEmployee(String employeeID) {

        for (int i = 0; i < getEmployeeList().size(); i++) {
            if (getEmployeeList().get(i).getID().equals(employeeID)) {
                return true;
            }
        }
        return false;
    }

    public Employee findEmployee(String employeeID) {

        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getID().equals(employeeID)) {
                return employeeList.get(i);
            }
        }
        return null;
    }

    public boolean containsEmployeeManager(String employeeID) {

        for (int i = 0; i < getEmployeeManagerList().size(); i++) {
            if (getEmployeeManagerList().get(i).getID().equals(employeeID)) {
                return true;
            }
        }
        return false;
    }
    public EmployeeManager findEmployeeManager(String employeeID) {

        for (int i = 0; i < employeeManagerList.size(); i++) {
            if (employeeManagerList.get(i).getID().equals(employeeID)) {
                return employeeManagerList.get(i);
            }
        }
        return null;
    }

    public boolean containsEmployeeDirector(String employeeID) {

        for (int i = 0; i < getEmployeeDirectorList().size(); i++) {
            if (getEmployeeDirectorList().get(i).getID().equals(employeeID)) {
                return true;
            }
        }
        return false;
    }
    public EmployeeDirector findEmployeeDirector(String employeeID) {

        for (int i = 0; i < employeeDirectorList.size(); i++) {
            if (employeeDirectorList.get(i).getID().equals(employeeID)) {
                return employeeDirectorList.get(i);
            }
        }
        return null;
    }

    public boolean containsEmployeeIntern(String employeeID) {

        for (int i = 0; i < getEmployeeInternList().size(); i++) {
            if (getEmployeeManagerList().get(i).getID().equals(employeeID)) {
                return true;
            }
        }
        return false;
    }
    public EmployeeIntern findEmployeeIntern(String employeeID) {

        for (int i = 0; i < employeeInternList.size(); i++) {
            if (employeeInternList.get(i).getID().equals(employeeID)) {
                return employeeInternList.get(i);
            }
        }
        return null;
    }

    public String removeEmployee(String employeeID) throws Exception {
        if (this.containsEmployee(employeeID)) {
            Employee employeeToRemove = this.findEmployee(employeeID);
            employeeList.remove(employeeToRemove);
            return "Employee " + employeeID + " was successfully removed.";

        } else if (this.containsEmployeeManager(employeeID)){
            EmployeeManager employeeManagerToRemove = this.findEmployeeManager(employeeID);
            employeeList.remove(employeeManagerToRemove);
            return "Employee " + employeeID + " was successfully removed.";

        } else if (this.containsEmployeeDirector(employeeID)){
            EmployeeDirector employeeDirectorToRemove = this.findEmployeeDirector(employeeID);
            employeeList.remove(employeeDirectorToRemove);
            return "Employee " + employeeID + " was successfully removed.";

        } else if (this.containsEmployeeIntern(employeeID)) {
            EmployeeIntern employeeInternToRemove = this.findEmployeeIntern(employeeID);
            employeeList.remove(employeeInternToRemove);
            return "Employee " + employeeID + " was successfully removed.";

        } else {
            return "Employee " + employeeID + " could not be removed.";
        }
    }

    public String printEmployee(String employeeID) throws Exception {
        if (containsEmployee(employeeID)) {
            Employee foundEmployee = findEmployee(employeeID);
            return foundEmployee.toString();

        } else if (containsEmployeeManager(employeeID)) {
            EmployeeManager foundEmployeeManager = findEmployeeManager(employeeID);
            return foundEmployeeManager.toString();

        } else if (containsEmployeeDirector(employeeID)) {
            EmployeeDirector foundEmployeeDirector = findEmployeeDirector(employeeID);
            return foundEmployeeDirector.toString();

        } else if (containsEmployeeIntern(employeeID)) {
            EmployeeIntern foundEmployeeIntern = findEmployeeIntern(employeeID);
            return foundEmployeeIntern.toString();

        } else {
            return "Employee " + employeeID + " was not registered yet.";
        }
    }

    public String printAllEmployees() throws Exception {

        if (employeeList.size()== 0 && employeeManagerList.size()==0 && employeeDirectorList.size()==0 && employeeInternList.size()==0) {
            return ("No employees were registered yet");
        } else {
            String allEmloyees =
        }
    }




}



    /*
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
      public String printItem(String itemID) {

        if (containsItem(itemID)) {
            Item foundItem = findItem(itemID);
            return foundItem.toString();
        } else {
            return "Item " + itemID + " was not registered yet.";
        }
    }
    public boolean containsItem(String itemID) {

        for (int i = 0; i < getItemList().size(); i++) {
            if (getItemList().get(i).getID().equals(itemID)) {
                return true;
            }
        }
        return false;
    }
     public String removeItem(String itemID) {

        if (this.containsItem(itemID)) {
            Item itemToRemove = this.findItem(itemID);
            itemList.remove(itemToRemove);
            return "Item " + itemID + " was successfully removed.";
        } else {
            return "Item " + itemID + " could not be removed.";
        }
    }
     */


