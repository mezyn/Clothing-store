
public class MainMenu {

    //item menu

    Controller obj = new Controller();
    //method for creating items

    public void createItem(){

        String ID = ItemScanner.readLine("Type ID of item: ");
        while(obj.checkForDuplicates(ID)== true) ID = ItemScanner.readLine("Type ID of item: ");
        String name = ItemScanner.readLine("Type name of item: ");
        double pricePerUnit = ItemScanner.readDouble("Type unit price of item: ");
        double grade = 0.0;
        String comment = " ";

        obj.createItem(ID,name,pricePerUnit);
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
            case 0 : MainMenuPage();
                break;
            // all println below are temporary.
            case 1 : //create an item

                createItem();
                itemOption(); //can be moved at the end of createItem()
                break;
            case 2 : System.out.println("3");
                break;
            case 3 : System.out.println("4");
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
            case 0 : MainMenuPage();
                break;
            case 1 : CreateReview.reviewer();
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
            case 0 : MainMenuPage();
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

    public void MainMenuPage(){

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

        MainMenu mainmenu = new MainMenu();
        mainmenu.MainMenuPage();

        }
    }
