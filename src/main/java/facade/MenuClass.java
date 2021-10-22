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

        String itemID = UserInput.readLine("Type current ID of the item: ");
        while (itemID.isBlank() || !facade.containsItem(itemID)) {
            System.out.println("Invalid data for item.");
            itemID = UserInput.readLine("Type current ID of the item: ");
        }
        String newName = UserInput.readLine("Type new name for the item: ");
        while (newName.isBlank()) {
            System.out.println("Invalid data for item.");
            itemID = UserInput.readLine("Type new name for the item: ");
        }

        facade.updateItemName(itemID,newName);;
        }


    public void updateItemPrice(){

        String itemID = UserInput.readLine("Type current ID of the item: ");
        while (itemID.isBlank() || !facade.containsItem(itemID)) {
            System.out.println("Invalid data for item.");
            itemID = UserInput.readLine("Type current ID of the item: ");
        }
        double newPrice = UserInput.readDouble("Type new price for the item: ");
        while (newPrice < 0 || newPrice == 0) {
            System.out.println("Invalid data for item.");
            newPrice = UserInput.readDouble("Type new price for the item: ");
        }
        facade.updateItemPrice(itemID, newPrice);
;
    }

    //2.5 - Remove items
    public void removeItem() {

        String itemID = UserInput.readLine("Type ID of item you would like to remove: ");
        while (itemID.isBlank() || !facade.containsItem(itemID)) {
            System.out.println("Invalid data for item.");
            itemID = UserInput.readLine("Type ID of item you would like to remove: ");
        }

        facade.removeItem(itemID);

    }

    public void buyItem() {

        String itemID = UserInput.readLine("Type ID of item you want to purchase: ");
        while (itemID.isBlank() || !facade.containsItem(itemID)) {
            System.out.println("Invalid data for item.");
            itemID = UserInput.readLine("Type ID of item you want to purchase: ");
        }

        int amount = UserInput.readInt("Type the amount of items you want to purchase: ");
        while (amount < 0 || amount == 0) {
            System.out.println("Invalid data for item.");
            amount = UserInput.readInt("Type the amount of items you want to purchase: ");
        }
        facade.buyItem(itemID, amount);

    }


    //2.6 - print an specific item
    public void printItem() {

        String itemID = UserInput.readLine("Type ID of item to be printed: ");
        while (itemID.isBlank() || !facade.containsItem(itemID)) {
            System.out.println("Invalid data for item.");
            itemID = UserInput.readLine("Type ID of item you want to purchase: ");
        }
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

    }

    public void getPrintedItemReview() { // User story 3.2

         String itemID = UserInput.readLine("Enter the ID of Item: ");
         int reviewNumber = UserInput.readInt("Enter an index of the review: ");

        System.out.println(facade.getPrintedItemReview( itemID, reviewNumber));

    }

    public void getPrintedReviews(){ //User story 3.3
        String itemID = UserInput.readLine("Enter ID: ");
        System.out.println(facade.getPrintedReviews(itemID));
    }

    public void getItemMeanGrade() { //User Story 3.4
        String itemID = UserInput.readLine("Enter ID: ");
        System.out.println(facade.getItemMeanGrade(itemID));
    }

    public void getItemCommentsPrinted() { //User Story 3.5
        String itemID = UserInput.readLine("Enter the ID of Item: ");

        System.out.println(facade.getItemCommentsPrinted(itemID));
    }

//_______________________________TransactionsHistory_____________________________________________


    // 4.3 - Print all transactions for a specific item
    public String printItemTransactions() {

        String itemID = UserInput.readLine("Type the ID of the desired item for transaction to be printed:");

        return facade.printItemTransactions(itemID);
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

        int option = UserInput.readInt("Item options menu:" + System.lineSeparator()+
                "0. Return to Main Menu." + System.lineSeparator()+
                "1. Create an Item." + System.lineSeparator()+
                "2. Remove an Item." + System.lineSeparator()+
                "3. Print all registered Items." + System.lineSeparator()+
                "4. Buy an Item." + System.lineSeparator()+
                "5. Update an item’s name." + System.lineSeparator()+
                "6. Update an item’s price." + System.lineSeparator()+
                "7. Print a specific Item." + System.lineSeparator()+
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
                System.out.println(facade.printAllItems());
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

        int option = UserInput.readInt("Reviews options menu:" + System.lineSeparator()+
                "0. Return to Main Menu." + System.lineSeparator()+
                "1. Create a review for an Item." + System.lineSeparator()+
                "2. Print a specific review of an Item." + System.lineSeparator()+
                "3. Print all reviews of an Item." + System.lineSeparator()+
                "4. Print mean grade of an Item" + System.lineSeparator()+
                "5. Print all comments of an Item." + System.lineSeparator()+
                "6. Print all registered reviews." + System.lineSeparator()+
                "7. Print item(s) with most reviews." + System.lineSeparator()+
                "8. Print item(s) with least reviews." + System.lineSeparator()+
                "9. Print item(s) with best mean review grade." + System.lineSeparator()+
                "10. Print item(s) with worst mean review grade." + System.lineSeparator()+
                "Type an option number: ");


        while (option < 0 || option > 10) {

            option = UserInput.readInt("Invalid menu option. Please type another option");
        }

        switch (option) {
            case 0 : MainMenu();
                break;
            case 1 :
                reviewItem(); // User Story 3.1
                ReviewMenu();
                break;
            case 2 : getPrintedItemReview();// User Story 3.2
                ReviewMenu();
                break;
            case 3 : getPrintedReviews(); // User Story 3.3
                ReviewMenu();
                break;
            case 4 : getItemMeanGrade(); // User Story 3.4
                ReviewMenu();
                break;
            case 5 : getItemCommentsPrinted();// User Story 3.5
                ReviewMenu();
                break;
            case 6 :
                System.out.println(facade.printAllReviews()); // User Story 3.6
                ReviewMenu();
                break;
            case 7 :
                System.out.println(facade.printMostReviewedItems());// User Story 3.7
                ReviewMenu();
                break;
            case 8 : System.out.println(facade.printLeastReviewedItems());// User Story 3.7
                ReviewMenu();
                break;
            case 9 : System.out.println(facade.printBestReviewedItems()) ;// User Story 3.8
                ReviewMenu();
                break;
            case 10 :System.out.println(facade.printWorseReviewedItems()); // User Story 3.8
                ReviewMenu();

                default : System.out.println("Please enter a valid option");
                break;
        }
        UserInput.scanner.close();
    }
    public void transactionHistoryMenu() throws Exception {

        int option = UserInput.readInt("Transaction History options menu:" + System.lineSeparator()+
                "0. Return to Main Menu." + System.lineSeparator()+
                "1. Print total profit from all item purchases" + System.lineSeparator()+
                "2. Print total units sold from all item purchases" + System.lineSeparator()+
                "3. Print the total number of item transactions made." + System.lineSeparator()+
                "4. Print all transactions made." + System.lineSeparator()+
                "5. Print the total profit of a specific item." + System.lineSeparator()+
                "6. Print the number of units sold of a specific item." + System.lineSeparator()+
                "7. Print all transactions of a specific item." + System.lineSeparator()+
                "8. Print item with highest profit." + System.lineSeparator()+
                "Type an option number:");

        while (option < 0 || option > 8) {

            option = UserInput.readInt("Invalid menu option. Please type another option");
        }

        switch (option) {
            case 0 : MainMenu();
                break;
            case 1 : System.out.println(facade.getTotalProfit());
                transactionHistoryMenu();
                break;
            case 2 : System.out.println(facade.getTotalUnitsSold());
                transactionHistoryMenu();
                break;
            case 3 : System.out.println(facade.getTotalTransactions());
                transactionHistoryMenu();
                break;
            case 4 : System.out.println(facade.printAllTransactions());
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
            case 8 : System.out.println(facade.printMostProfitableItems());
                transactionHistoryMenu();
                break;
            default : System.out.println("Please enter a valid option");
                break;
        }

        UserInput.scanner.close();
    }

    public void EmployeeMenu() throws Exception {
        int option = UserInput.readInt("Employee options menu:" +System.lineSeparator()+
                "0. Return to Main Menu." + System.lineSeparator()+
                "1. Create an employee (Regular Employee). " + System.lineSeparator()+
                "2. Create an employee (Manager)." + System.lineSeparator()+
                "3. Create an employee (Director)." + System.lineSeparator()+
                "4. Create an employee (Intern)." + System.lineSeparator()+
                "5. Remove an employee." + System.lineSeparator()+
                "6. Print specific employee." + System.lineSeparator()+
                "7. Print all registered employees." + System.lineSeparator()+
                "8. Print the total expense with net salary." + System.lineSeparator()+
                "9. Print all employees sorted by gross salary." + System.lineSeparator()+
                "" + System.lineSeparator()+
                "Type an option number: ");

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
                case 7: System.out.println(facade.printAllEmployees());
                    EmployeeMenu();
                    break;
                case 8: System.out.println(facade.getTotalNetSalary());
                    EmployeeMenu();
                    break;
                case 9: System.out.println(facade.printSortedEmployees());
                    EmployeeMenu();
                    break;
                default : System.out.println("Please enter a valid option");
                    break;


        }
    }

    public void MainMenu() throws Exception {

        int option = UserInput.readInt(
                "Main Menu: Please chose among the options below " + System.lineSeparator()+
                        "0. Close System." + System.lineSeparator()+
                        "1. Open Item Options." + System.lineSeparator()+
                        "2. Open Review options." + System.lineSeparator()+
                        "3. Open Transaction History Options." + System.lineSeparator()+
                        "4. Open Employee options." + System.lineSeparator()+
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

