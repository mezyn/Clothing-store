package facade;

public class MenuClass {

    Facade facade = new Facade();

    //method for creating items
    public void createItem(){

        String ID = UserInput.readLine("Type ID for item: ");
        while(facade.containsItem(ID)) {
            ID = UserInput.readLine("The ID is already taken." + ls() + "Type another ID for item: ");
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
        System.out.println(facade.createItem(ID, name, pricePerUnit));

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

        System.out.println(facade.updateItemName(itemID,newName));
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
        System.out.println(facade.updateItemPrice(itemID, newPrice));

    }

    //2.5 - Remove items
    public void removeItem() {

        String itemID = UserInput.readLine("Type ID of item you would like to remove: ");
        while (itemID.isBlank() || !facade.containsItem(itemID)) {
            System.out.println("Invalid data for item.");
            itemID = UserInput.readLine("Type ID of item you would like to remove: ");
        }

        System.out.println(facade.removeItem(itemID));

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
        System.out.println(facade.printItem(itemID));
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

        System.out.println(facade.reviewItem(itemID, reviewComment, reviewGrade));

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
    public void printItemTransactions() {

        String itemID = UserInput.readLine("Type the ID of the desired item for transaction to be printed:");

        System.out.println(facade.printItemTransactions(itemID));
    }

    // Print total profit for a specific item
    public double printProfit() {

        String itemID = UserInput.readLine("Type the ID of the desired item for profit to be printed:");

        return facade.getProfit(itemID);
    }

    //Print total units sold for a specific item
    public int printUnitsSolds() {

        String itemID = UserInput.readLine("Type the ID of the desired item for units sold to be printed:");

        return facade.getUnitsSolds(itemID);
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
        String employeeID = UserInput.readLine("Type ID for employee: ");
        String employeeName = UserInput.readLine("Type name for employee: ");
        double grossSalary = UserInput.readDouble("Type gross salary for employee: ");

        System.out.println(facade.createEmployee(employeeID, employeeName, grossSalary));
    }

    public void createEmployeeManager() throws Exception {
        String employeeID = UserInput.readLine("Type ID for employee:");
        String employeeName = UserInput.readLine("Type name for employee:");
        double grossSalary = UserInput.readDouble("Type gross salary for employee:");
        String degree = UserInput.readLine("Type degree for employee:");

        System.out.println(facade.createEmployee(employeeID, employeeName, grossSalary, degree));
    }

    public void createEmployeeDirector() throws Exception {
        String employeeID = UserInput.readLine("Type ID for employee:");
        String employeeName = UserInput.readLine("Type name for employee:");
        double grossSalary = UserInput.readDouble("Type gross salary for employee");
        String degree = UserInput.readLine("Type degree for employee:");
        String department = UserInput.readLine("Type department for employee:");

        System.out.println(facade.createEmployee(employeeID, employeeName, grossSalary, degree, department));
    }

    public void createEmployeeIntern() throws Exception {
        String employeeID = UserInput.readLine("Type ID for employee:");
        String employeeName = UserInput.readLine("Type name for employee:");
        double grossSalary = UserInput.readDouble("Type gross salary for employee:");
        int GPA = UserInput.readInt("Type GPA for employee:");


        System.out.println(facade.createEmployee(employeeID, employeeName, grossSalary, GPA));
    }

    public void removeEmployee() throws Exception {
        String empID = UserInput.readLine("Type ID of employee you would like to remove:");
        System.out.println(facade.removeEmployee(empID));

    }

    public void printEmployee() throws Exception {
        String empID = UserInput.readLine("Type ID of employee you would like to print:");
        System.out.println(facade.printEmployee(empID));

    }

    public void itemOption() throws Exception {

        int option = UserInput.readInt("Item options menu:" + ls()+
                "0. Return to Main Menu." + ls()+
                "1. Create an Item." + ls()+
                "2. Remove an Item." + ls()+
                "3. Print all registered Items." + ls()+
                "4. Buy an Item." + ls()+
                "5. Update an item’s name." + ls()+
                "6. Update an item’s price." + ls()+
                "7. Print a specific Item." + ls()+
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

        int option = UserInput.readInt("Reviews options menu:" + ls()+
                "0. Return to Main Menu." + ls()+
                "1. Create a review for an Item." + ls()+
                "2. Print a specific review of an Item." + ls()+
                "3. Print all reviews of an Item." + ls()+
                "4. Print mean grade of an Item" + ls()+
                "5. Print all comments of an Item." + ls()+
                "6. Print all registered reviews." + ls()+
                "7. Print item(s) with most reviews." + ls()+
                "8. Print item(s) with least reviews." + ls()+
                "9. Print item(s) with best mean review grade." + ls()+
                "10. Print item(s) with worst mean review grade." + ls()+
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

        int option = UserInput.readInt("Transaction History options menu:" + ls()+
                "0. Return to Main Menu." + ls()+
                "1. Print total profit from all item purchases" + ls()+
                "2. Print total units sold from all item purchases" + ls()+
                "3. Print the total number of item transactions made." + ls()+
                "4. Print all transactions made." + ls()+
                "5. Print the total profit of a specific item." + ls()+
                "6. Print the number of units sold of a specific item." + ls()+
                "7. Print all transactions of a specific item." + ls()+
                "8. Print item with highest profit." + ls()+
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
        int option = UserInput.readInt("Employee options menu:" +ls()+
                "0. Return to Main Menu." + ls()+
                "1. Create an employee (Regular Employee). " + ls()+
                "2. Create an employee (Manager)." + ls()+
                "3. Create an employee (Director)." + ls()+
                "4. Create an employee (Intern)." + ls()+
                "5. Remove an employee." + ls()+
                "6. Print specific employee." + ls()+
                "7. Print all registered employees." + ls()+
                "8. Print the total expense with net salary." + ls()+
                "9. Print all employees sorted by gross salary." + ls()+
                "" + ls()+
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
        UserInput.scanner.close();
    }

    public void MainMenu() throws Exception {

        int option = UserInput.readInt(
                "Main Menu: Please chose among the options below " + ls() +
                        "0. Close System." + ls()+
                        "1. Open Item Options." + ls()+
                        "2. Open Review options." + ls()+
                        "3. Open Transaction History Options." + ls()+
                        "4. Open Employee options." + ls()+
                        "Type any Option Number:");

        while (option < 0 || option > 4) {

            option = UserInput.readInt("Invalid menu option. Please type another option");
        }

        switch (option) {
            case 0:
                System.out.println("Closed");
                break;
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
    public String ls (){ // System.lineSeparator()
        return System.lineSeparator();
    }
    public static void main(String[] args) throws Exception {

        MenuClass mainmenu = new MenuClass();
        mainmenu.MainMenu();

        }
    }

