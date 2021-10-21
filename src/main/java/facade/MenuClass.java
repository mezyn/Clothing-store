package facade;

public class MenuClass {

    Facade facade = new Facade();

    //method for creating items
    public void createItem(){

        String ID = UserInput.readLine("Type ID for item: ");
        while(facade.containsItem(ID)) {
            ID = UserInput.readLine("The ID is already taken." + System.lineSeparator() + "Type another ID for item: ");
        }
        while (ID.isBlank()) {
            System.out.println("Invalid data for item.");
            ID = UserInput.readLine("Type ID for item: ");
        }
        String name = UserInput.readLine("Type name for item: ");
        while (name.isBlank()) {
            System.out.println("Invalid data for item.");
            name = UserInput.readLine("Type name for item: ");
        }
        double pricePerUnit = UserInput.readDouble("Type unit price of item: ");
        while (pricePerUnit == 0 || pricePerUnit < 0) {
            System.out.println("Invalid data for item.");
            pricePerUnit = UserInput.readDouble("Type unit price of item: ");
        }
        facade.createItem(ID, name, pricePerUnit);

    }


    //2.3 - Update item name and price
    public void updateItemName() { //(String itemID, String newName)

        String IDInput = UserInput.readLine("Type current ID of the item: ");
        while (IDInput.isBlank() || IDInput.equals(IDInput)) {
            System.out.println("Invalid data for item.");
            IDInput = UserInput.readLine("Type new name for the item: ");
        }
        String newNameInput = UserInput.readLine("Type new name for the item: ");

        facade.updateItemName(IDInput,newNameInput);;
        }


    public void updateItemPrice(){

        String IDInput = UserInput.readLine("Type current ID of the item: ");
        double newPriceInput = UserInput.readDouble("Type new price for the item: ");

        while (newPriceInput < 0 || newPriceInput == 0) {
            System.out.println("Invalid data for item.");
            newPriceInput = UserInput.readDouble("Type new price for the item: ");
        }
        facade.updateItemPrice(IDInput, newPriceInput);
;
    }

    //2.5 - Remove items
    public void removeItem() {

        String itemID = UserInput.readLine("Type ID of item you would like to remove: ");
        facade.removeItem(itemID);

    }

    public void buyItem() {

        String itemID = UserInput.readLine("Type ID of item you want to purchase: ");
        int amount = UserInput.readInt("Type the amount of items you want to purchase: ");
        facade.buyItem(itemID, amount);

    }


    //2.6 - print an specific item
    public void printItem() {

        String itemID = UserInput.readLine("Type ID of item to be printed: ");
        facade.printItem(itemID);
    }

//____________________________________________Reviews___________________________________________________

    public void reviewItem() { //User Story 3.1

        System.out.println("To create a review for a item please enter ID of the item:");

        String itemID = UserInput.readLine("Enter the ID number: ");

        while(itemID.isEmpty()) {
            System.out.println("ID needed to review item: ");
            itemID = UserInput.readLine("Enter ID number: ");
        } while (!facade.containsItem(itemID)){
            System.out.println("Item " + itemID + " was not registered yet.");
            itemID = UserInput.readLine("Enter a valid ID number: ");
        }
        String reviewComment = UserInput.readLine("What did you like or dislike about this item?: ");
        int reviewGrade = UserInput.readInt("Enter a grade between 1 to 5: ");
        while (reviewGrade < 1.0 || reviewGrade > 5.0){

            reviewGrade = UserInput.readInt("Grade values must be between 1 and 5.");
        }

        String review = facade.reviewItem(itemID, reviewComment, reviewGrade);

        System.out.println("Your item review was registered successfully.");

    }

    public void getPrintedItemReview() { // User story 3.2

        String itemID = UserInput.readLine("Enter the ID of Item: ");
        int reviewNumber = UserInput.readInt("Enter an index of the review: ");

        facade.getPrintedItemReview( itemID, reviewNumber);
    }

    public void getPrintedReviews(){ //User story 3.3
        String itemID = UserInput.readLine("Enter ID: ");
        facade.getPrintedReviews( itemID);
    }

    public void getItemMeanGrade() { //User Story 3.4
        String itemID = UserInput.readLine("Enter ID: ");
        facade.getItemMeanGrade(itemID);
    }

    public void getItemCommentsPrinted() { //User Story 3.5
        String itemID = UserInput.readLine("Enter the ID of Item: ");

        facade.getItemCommentsPrinted(itemID);
    }

    public void printAllReviews() { //User Story 3.6

        facade.printAllReviews();
    }

    public void printLeastReviewedItems(){ //User Story 3.7

        facade.printLeastReviewedItems();
    }

    public void printMostReviewedItems() {

        facade.printMostReviewedItems();
    }

    public void printBestReviewedItems()  {

        facade.printBestReviewedItems();
    }

    public String printWorseReviewedItems(){

        return facade.printWorseReviewedItems();
    }


/*
    public String getPrintedItemReview(String itemID, int reviewNumber) { // User story 3.2

        System.out.println("Size of list: " + Item.getReviewList().size());
        itemID = UserInput.readLine("Enter the ID of Item: ");

        if (!facade.containsItem(itemID)) { // Check if item exists

            System.out.println("Item " + itemID + " was not registered yet.");
            itemID = UserInput.readLine("Enter a valid ID number: ");

        }  else if (!Controller.containsReview(itemID)) { // checks if there is a review of item
            System.out.println("Item " + Item.getItemName(itemID) + " has not been reviewed yet.");
        }
        else {

            int index = UserInput.readInt("Enter an index of the review: ");

            if (index < 1 || index > Item.getReviewList().size()){
                System.out.println("Invalid review number. Choose between 1 and "
                        + Item.getReviewList().size() + ".");
            } else {
                Review reviewItem = Item.getReviewList().get(index - 1);
                System.out.println(reviewItem);
            }


        }

        return "";
    }*/

    /*public String getPrintedReviews(String itemID) { //User story 3.3

        itemID = UserInput.readLine("Enter ID: ");

        if (!facade.containsItem(itemID)) {
            return "Item " + itemID + " was not registered yet.";
        }
        else if (Item.getReviewList().size() > 0) {
            String printedOutput =  "Review(s) for " + itemID + ": "
                    + Controller.getItemName(itemID) + ". "
                    + Controller.getItemPrice(itemID) + " SEK" + System.lineSeparator();
            for (int i = 0; i < Item.getReviewList().size(); i++) {
                    printedOutput += Item.getReviewList().get(i).toString();

            }
            return printedOutput;
        } else  {
            return "Item " + Item.getItemName() + " has not been reviewed yet.";
        }
    }*/

    /*public String getPrintedReviews () { //User story 3.3
        String itemID = UserInput.readLine("Enter the ID of Item: ");

        if (!facade.containsItem(itemID)) {
            System.out.println("Item <" + itemID + "> was not registered yet.");

        } else if (!Controller.containsReview(itemID)) {
            System.out.println("Review(s) for <" + itemID + ">: <"
                    + Controller.getItemName(itemID) + ">. <"
                    + Controller.getItemPrice(itemID) + "> SEK");
            System.out.println("Item <" + Controller.getItemName(itemID) + "> has not been reviewed yet.");


        } else if (Controller.containsReview(itemID)) {
            System.out.println("Review(s) for <" + itemID + ">: <"
                    + Controller.getItemName(itemID) + ">. " + "<"
                    + Controller.getItemPrice(itemID) + "> SEK.");

            for (int i = 0; i < Item.getReviews().size(); i++) {
                if (item.getReviews().get(i).getID().equals(itemID)) {
                    System.out.println(Item.getReviews().get(i).toString());

                }
            }
        }
    }*/


    /*public double getItemMeanGrade(String itemID) { //User Story 3.4

        itemID = UserInput.readLine("Enter ID of item: ");

        double sumGrade = 0.0;
        int counter = 0;
        if (!Controller.containsReview(itemID)) {
            System.out.println("Item " + itemID + "was not registered yet.");
        } else if (Controller.findReview(itemID).getItemComment().isEmpty()) {
            System.out.println("Item " + itemID + " has not been reviewed yet.");
        } else {
            for (int i = 0; i < Item.getReviewList().size(); i++) {
                if (Item.getReviewList().get(i).getID().equals(itemID)) {
                    sumGrade += Item.getReviewList().get(i).getItemGrade();
                    counter += 1;
                }
            }
        }
        double meanGrade = Controller.changeDecimalToOne(double value)
        return meanGrade;
    }*/


   /*public void getItemComments() { //User Story 3.5

        String itemID = UserInput.readLine("Enter the ID of Item: ");

        if (Controller.containsReview(itemID)) {
            for (int i = 0; i < Item.reviewList.size(); i++) {
                if (Item.getReviewList().get(i).equals(itemID)) {
                    Controller.commentsList.add(Controller.getReviewList().get(i).getItemComment());

                    System.out.print(Controller.getcommentsList());
            for (String review : Controller.commentsList) {
            System.out.println(reviewNumber);
        }
                }
            }
        }
    }*/


    /*public String printAllReviews() { //User Story 3.6

        facade.printAllReviews();

        return "";
    }*/




//_______________________________TransactionsHistory_____________________________________________


    // 4.3 - Print all transactions for a specific item
    public String printItemTransactions() {

        String itemID = UserInput.readLine("Type the ID of the desired item for transaction to be printed:");
        facade.printItemTransactions(itemID);

        return "";
    }

    // Print total profit for a specific item
    public double printProfit() {

        String itemID = UserInput.readLine("Type the ID of the desired item for profit to be printed:");
        facade.getProfit(itemID);

        return 0.0;
    }

    //Print total units sold for a specific item
    public int printUnitsSolds() {

        String itemID = UserInput.readLine("Type the ID of the desired item for units sold to be printed:");
        facade.getUnitsSolds(itemID);

        return 0;
    }


   /* public String printItemTransactions() {

        String itemID = UserInput.readLine("Type the ID of the desired item for transaction to be printed:");

        if (!controller.containsItem(itemID)) {
            System.out.println("Item < " + Controller.findItemName(itemID) + "> was not registered.");
        } else if (!Controller.containsTransaction(itemID)) {
            System.out.println("Transactions for item: <" + itemID + ">: <" + Controller.getItemName(itemID) + ">. <" + Controller.getUnitPrice(itemID) + "> SEK\n" + "No transactions have been registered for item <" + itemID + "> yet.\n");
        } else {facade.printItemTransactions(itemID);
        }
        return "";

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
    }*/
    // 4.3 print transaction for specific item
/*

    public String printTransactionSpecificItem() {
            String itemID = UserInput.readLine("Type the ID of the desired item for transaction to be printed");
       if (facade.containsTransaction(itemID)) {
            Item foundItem = facade.findItem(itemID);
            System.out.println(foundItem);
    } else {
        System.out.println("Item <" + itemID + " > was not registered yet.");
       }
       return "";
    }
*/

//____________________________________________ Employee ___________________________________________________

    public void createEmployee() throws Exception {
        String employeeID = UserInput.readLine("Tye ID for employee:");
        String employeeName = UserInput.readLine("Type name for employee:");
        double grossSalary = UserInput.readDouble("Type gross salary for employee:");

        String employee = facade.createEmployee(employeeID, employeeName, grossSalary);
    }

    public void createEmployeeManager() throws Exception {
        String employeeID = UserInput.readLine("Type ID for employee:");
        String employeeName = UserInput.readLine("Type name for employee:");
        double grossSalary = UserInput.readDouble("Type gross salary for employee:");
        String degree = UserInput.readLine("Type degree for employee:");

        String employee = facade.createEmployee(employeeID, employeeName, grossSalary, degree);
    }

    public void createEmployeeDirector() throws Exception {
        String employeeID = UserInput.readLine("Type ID for employee:");
        String employeeName = UserInput.readLine("Type name for employee:");
        double grossSalary = UserInput.readDouble("Type gross salary for employee");
        String degree = UserInput.readLine("Type degree for employee:");
        String department = UserInput.readLine("Type department for employee:");

        String employee = facade.createEmployee(employeeID, employeeName, grossSalary, degree, department);
    }

    public void createEmployeeIntern() throws Exception {
        String employeeID = UserInput.readLine("Type ID for employee:");
        String employeeName = UserInput.readLine("Type name for employee:");
        double grossSalary = UserInput.readDouble("Type gross salary for employee:");
        int GPA = UserInput.readInt("Type GPA for employee:");


        String employee = facade.createEmployee(employeeID, employeeName, grossSalary, GPA);
    }

    public void removeEmployee() throws Exception {
        String empID = UserInput.readLine("Type ID of employee you would like to remove:");
        facade.removeEmployee(empID);

    }

    public void printEmployee() throws Exception {
        String empID = UserInput.readLine("Type ID of employee you would like to print:");
        facade.printEmployee(empID);

    }


    public void itemOption() throws Exception {

        int option = UserInput.readInt("Item options menu:\n" +
                "0. Return to Main Menu.\n" +
                "1. Create an Item.\n" +
                "2. Remove an Item.\n" +
                "3. Print all registered Items.\n" +
                "4. Buy an Item.\n" +
                "5. Update an item’s name.\n" +
                "6. Update an item’s price.\n" +
                "7. Print a specific Item.\n\n" +
                "Type an option number: ");

        while (option < 0 || option > 7) {

            option = UserInput.readInt("Invalid menu option. Please type another option");
        }

        switch (option) {
            case 0 : MainMenu();
                break;
            // all println below are temporary.
            case 1 : //create an item
                createItem();
                itemOption(); //can be moved at the end of createItem()
                break;
            case 2 :
                removeItem();
                itemOption();
                break;
            case 3 :
                facade.printAllItems();
                itemOption();
                break;
            case 4 :
                buyItem(); //as for now buyItem is in obj
                itemOption();
                break;
            //5. Update an item’s name.
            case 5 : //Update an item’s name.
                updateItemName();
                itemOption();
                break;
            //6. Update an item’s price.
            case 6 :
                updateItemPrice();
                itemOption();
                break;
            case 7 :
                printItem();
                itemOption();
        }

        UserInput.scanner.close();
    }
    public void ReviewMenu() throws Exception {

        int option = UserInput.readInt("Reviews options menu:\n" +
                "0. Return to Main Menu.\n" +
                "1. Create a review for an Item.\n" +
                "2. Print a specific review of an Item.\n" +
                "3. Print all reviews of an Item.\n" +
                "4. Print mean grade of an Item\n" +
                "5. Print all comments of an Item.\n" +
                "6. Print all registered reviews.\n" +
                "7. Print item(s) with most reviews.\n" +
                "8. Print item(s) with least reviews.\n" +
                "9. Print item(s) with best mean review grade.\n" +
                "10. Print item(s) with worst mean review grade.\n\n" +
                "Type an option number: ");


        while (option < 0 || option > 10) {

            option = UserInput.readInt("Invalid menu option. Please type another option");
        }

        switch (option) {
            case 0 : MainMenu();
                break;
            case 1 : reviewItem(); // User Story 3.1
                ReviewMenu();
                break;
            case 2 : getPrintedItemReview();// User Story 3.2
                ReviewMenu();
                break;
            case 3 : getPrintedReviews (); // User Story 3.3
                ReviewMenu();
                break;
            case 4 : getItemMeanGrade(); // User Story 3.4
                ReviewMenu();
                break;
            case 5 : getItemCommentsPrinted();// User Story 3.5
                ReviewMenu();
                break;
            case 6 : printAllReviews(); // User Story 3.6
                ReviewMenu();
                break;
            case 7 : printMostReviewedItems();// User Story 3.7
                ReviewMenu();
                break;
            case 8 : printLeastReviewedItems();// User Story 3.7
                ReviewMenu();
                break;
            case 9 : printBestReviewedItems() ;// User Story 3.8
                break;
            default : printWorseReviewedItems(); // User Story 3.8
                break;
        }
        UserInput.scanner.close();
    }
    public void transactionHistoryMenu() throws Exception {

        int option = UserInput.readInt("Transaction History options menu:\n" +
                "0. Return to Main Menu.\n" +
                "1. Print total profit from all item purchases\n" +
                "2. Print total units sold from all item purchases\n" +
                "3. Print the total number of item transactions made.\n" +
                "4. Print all transactions made.\n" +
                "5. Print the total profit of a specific item.\n" +
                "6. Print the number of units sold of a specific item.\n" +
                "7. Print all transactions of a specific item.\n" +
                "8. Print item with highest profit.\n\n" +
                "Type an option number:\n");

        while (option < 0 || option > 8) {

            option = UserInput.readInt("Invalid menu option. Please type another option");
        }

        switch (option) {
            case 0 : MainMenu();
                break;
            case 1 : facade.getTotalProfit();
                transactionHistoryMenu();
                break;
            case 2 : facade.getTotalUnitsSold();
                transactionHistoryMenu();
                break;
            case 3 : facade.getTotalTransactions();
                transactionHistoryMenu();
                break;
            case 4 : facade.printAllTransactions();
                transactionHistoryMenu();
                break;
            case 5 : printProfit();
                transactionHistoryMenu();
                break;
            case 6 : printUnitsSolds();
                transactionHistoryMenu();
                break;
            case 7 : printItemTransactions();
                transactionHistoryMenu();
                break;
            case 8 : facade.printMostProfitableItems();
                transactionHistoryMenu();
                break;
            default : System.out.println("Please enter a valid option");
                break;
        }

        UserInput.scanner.close();
    }

    public void EmployeeMenu() throws Exception {
        int option = UserInput.readInt("Employee options menu:\n" +
                "0. Return to Main Menu.\n" +
                "1. Create an employee (Regular Employee).\n" +
                "2. Create an employee (Manager).\n" +
                "3. Create an employee (Director).\n" +
                "4. Create an employee (Intern).\n" +
                "5. Remove an employee.\n" +
                "6. Print specific employee.\n" +
                "7. Print all registered employees.\n" +
                "8. Print the total expense with net salary.\n" +
                "9. Print all employees sorted by gross salary.\n" +
                "\n" +
                "Type an option number:\n");

        while (option < 0 || option > 7){

            option = UserInput.readInt("Invalid menu option. Please type another option");
        }

            switch (option) {
                case 0: EmployeeMenu();
                    MainMenu();
                    break;// create method, need help from TA with this / Carl
                case 1: createEmployee();
                    EmployeeMenu();
                    break;
                case 2: createEmployeeManager();
                    EmployeeMenu();
                    break;
                case 3: createEmployeeDirector();
                    EmployeeMenu();
                    break;
                case 4: createEmployeeIntern();
                    EmployeeMenu();
                    break;
                case 5: removeEmployee();
                    EmployeeMenu();
                    break;
                case 6: printEmployee();
                    EmployeeMenu();
                    break;
                case 7: facade.printAllEmployees();
                    EmployeeMenu();
                    break;
                case 8: facade.getTotalNetSalary();
                    EmployeeMenu();
                    break;
                case 9: facade.printSortedEmployees();
                    EmployeeMenu();
                    break;
                default : System.out.println("Please enter a valid option");
                    break;


        }
    }

    public void MainMenu() throws Exception {

        int option = UserInput.readInt(
                "Main Menu: Please chose among the options below \n" +
                        "0. Close System.\n" +
                        "1. Open Item Options.\n" +
                        "2. Open Review options.\n" +
                        "3. Open Transaction History Options.\n" +
                        "4. Open Employee options.\n" +
                        "Type any Option Number:");

        while (option < 0 || option > 4) {

            option = UserInput.readInt("Invalid menu option. Please type another option");
        }

        switch (option) {
            case 0:
                System.out.println("Closed");
                break;// create method, need help from TA with this / Carl
            case 1:
                itemOption();
                break;
            case 2:
                ReviewMenu();
                break;
            case 3:
                transactionHistoryMenu();
                break;
            case 4:
                EmployeeMenu();
                break;
            default : System.out.println("Please enter a valid option");
                break;
        }

        UserInput.scanner.close();

    }

    public static void main(String[] args) throws Exception {

        MenuClass mainmenu = new MenuClass();
        mainmenu.MainMenu();

        }
    }

