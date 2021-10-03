
public class MenuClass {

    //item menu

    Controller obj = new Controller();
    //method for creating items

    public void createItem(){

        String ID = UserInput.readLine("Type ID for item: ");
        while(obj.checkForDuplicates(ID)== true) {
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
        obj.createItem(ID,name,pricePerUnit);
    }
    public void createReview() {

        System.out.println("To create a review for a item please enter ID of the item:");

        String ID = UserInput.readLine("ID number: ");
        String comment = UserInput.readLine("What did you like or dislike about this item?: ");
        double grade = UserInput.readDouble("Enter a grade 1 to 5: ");

        obj.createReview(ID, comment, grade);

        System.out.println("Your item review was registered successfully.");

        // System.out.println("ID: " + ID + " Comment: " + comment + " Grade: " + grade);

        //System.out.println("Returning to Review Menu....");

    }
    public void itemOption() {

        int option = UserInput.readInt("Item options menu:\n" +
                "0. Return to Main Menu.\n" +
                "1. Create an Item.\n" +
                "2. Remove an Item.\n" +
                "3. Print all registered Items.\n" +
                "4. Buy an Item.\n" +
                "5. Update an item’s name.\n" +
                "6. Update an item’s price.\n\n" +
                "Type an option number: ");

        while (option < 0 || option > 6) {

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
            case 2 : System.out.println("3");
                break;
            case 3 :
                obj.printAllItems();
                //itemOption();
                break;
            case 4 : System.out.println("5");
                break;
            //5. Update an item’s name.
            case 5 : System.out.println("6");
                break;
            //6. Update an item’s price.
            case 6 : System.out.println("7");
                break;
        }

        UserInput.scanner.close();
    }
    public void ReviewMenu() {

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
            case 1 : createReview();
                break;
            case 2 : System.out.println("Option 3");
                break;
            case 3 : System.out.println("Option 4");
                break;
            case 4 : System.out.println("Option 5");
                break;
            case 5 : System.out.println("Option 6");
                break;
            case 6 : System.out.println("Option 7");
                break;
            case 7 : System.out.println("Option 8");
                break;
            case 8 : System.out.println("Option 9");
                break;
            case 9 : System.out.println("Option 10");
                break;
            default : System.out.println("Please enter a valid option");
                break;
        }
        UserInput.scanner.close();
    }
    public void transactionHistoryMenu() {

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
            case 1 : System.out.println("Option 2");
                break;
            case 2 : System.out.println("Option 3");
                break;
            case 3 : System.out.println("Option 4");
                break;
            case 4 : System.out.println("Option 5");
                break;
            case 5 : System.out.println("Option 6");
                break;
            case 6 : System.out.println("Option 7");
                break;
            case 7 : System.out.println("Option 8");
                break;
            case 8 : System.out.println("Option 9");
                break;
        }

        UserInput.scanner.close();
    }

    public void MainMenu(){

        int option = UserInput.readInt(
                "Main Menu: Please chose among the options below \n" +
                        "0. Close System.\n" +
                        "1. Open Item Options.\n" +
                        "2. Open Review options.\n" +
                        "3. Open Transaction History Options.\n\n" +
                        "Type any Option Number:");

        while (option < 0 || option > 3) {

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
                break; // Added method, so when "3" is pressed we have the transactionMenu printed /Carl

        }

        UserInput.scanner.close();

    }

    public static void main(String[] args) {

        MenuClass mainmenu = new MenuClass();
        mainmenu.MainMenu();

        }
    }
