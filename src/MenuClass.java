import java.util.Collections;
import java.util.Iterator;

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
        String item = facade.createItem(ID, name, pricePerUnit);

    }


    //2.3 - Update item name and price
    public String updateItemName() { //(String itemID, String newName)

        String IDInput = UserInput.readLine("Type current ID of the item: ");
        while (IDInput.isBlank() || IDInput.equals(IDInput)) {
            System.out.println("Invalid data for item.");
            IDInput = UserInput.readLine("Type new name for the item: ");
        }
        String newNameInput = UserInput.readLine("Type new name for the item: ");

        facade.updateItemName(IDInput,newNameInput);
        
       
        return "";
        }


    public String updateItemPrice(){

        String IDInput = UserInput.readLine("Type current ID of the item: ");
        double newPriceInput = UserInput.readDouble("Type new price for the item: ");

        while (newPriceInput < 0 || newPriceInput == 0) {
            System.out.println("Invalid data for item.");
            newPriceInput = UserInput.readDouble("Type new price for the item: ");
        }
        facade.updateItemPrice(IDInput, newPriceInput);

        return "";
    }

    //2.5 - Remove items
    public String removeItem() {

        String itemID = UserInput.readLine("Type ID of item you would like to remove: ");
        facade.removeItem(itemID);

        return "";
    }

    public double buyItem() {

        String itemID = UserInput.readLine("Type ID of item you want to purchase: ");
        int amount = UserInput.readInt("Type the amount of items you want to purchase: ");
        facade.buyItem(itemID, amount);

        return 0.0;
    }


    //2.6 - print an specific item
    public String printItem() {

        String itemID = UserInput.readLine("Type ID of item to be printed: ");
        facade.printItem(itemID);

        return "";
    }

    public String printAllItems() {

        facade.printAllItems();

        return "";
    }





//____________________________________________Reviews___________________________________________________
    public void createReview() { //User Story 3.1

        System.out.println("To create a review for a item please enter ID of the item:");

        String itemID = UserInput.readLine("Enter the ID number: ");
        while(itemID.isEmpty()) {
            System.out.println("ID needed to review item: ");
            itemID = UserInput.readLine("Enter ID number: ");
        } while (!facade.containsItem(itemID)){
            System.out.println("Item <" + itemID + "> was not registered yet.");
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

      public String getPrintedItemReview() { // User story 3.2

          System.out.println("Size of list: " + Controller.reviewList.size());
          int index = UserInput.readInt("Enter index: press 0 for first. 1 for second, and so on: ");

          Review review = Controller.reviewList.get(index);
          System.out.println("Review number["+ index +"] : "+ review);


          /*String itemID = UserInput.readLine("Enter the ID of Item: ");

          if (!facade.containsItem(itemID)) { // Check if item exists

              System.out.println("Item <" + itemID + "> was not registered yet.");
              itemID = UserInput.readLine("Enter a valid ID number: ");

          } else if (facade.containsItem(itemID) && !facade.containsReview(itemID)) { // checks if there is a review of item
              System.out.println("Item < " + Controller.getItemName(itemID) + "> has not been reviewed yet.");

          } else if (facade.containsReview(itemID)) {

              //System.out.println("Review <" + itemID + ">");
              Review foundReview = Controller.findReview(itemID);
              System.out.println(foundReview);

          } else {

              System.out.println("Number of reviews for item " + itemID + " : " + Controller.reviewList.size());

              int i = UserInput.readInt("Enter reviewNumber to retrieve the review: ");
              int reviewNumber = Controller.reviewList.indexOf(i);

              if (reviewNumber > Controller.reviewList.size() || reviewNumber < Controller.reviewList.size()) {
                  System.out.println("Invalid review number. Choose between 1 and <"
                          + Controller.reviewList.size() + ">.");
              } else {
                  for (Review review : Controller.reviewList) { // parameter review never used?
                      System.out.println("Grade: " + "[" + reviewNumber + "]"
                              + "<" + Controller.getItemGrade((itemID)) + ">.< "
                              + Controller.getItemComment(itemID) + ">");
                  }

              }

          }*/
          return "";
      }

/*Controller.itemList().retainAll(Controller.reviewList);

          System.out.println(Controller.reviewList);
*/

    public String getPrintedReviews () { //User story 3.3
        String itemID = UserInput.readLine("Enter the ID of Item: ");

        if (facade.containsReview(itemID)) {
            System.out.println("Review(s) for <" + itemID + ">: <"
                    + Controller.getItemName(itemID) + ">. " + "<"
                        + Controller.getItemPrice(itemID) + "> SEK.");

                Review foundReview = Controller.findReview(itemID);
                    System.out.println(foundReview);

        } else if (!facade.containsItem(itemID)) {
            System.out.println("Item <" + itemID + "> was not registered yet.");

        } else if (facade.containsItem(itemID) && !facade.containsReview(itemID)){
            System.out.println("Review(s) for <"+itemID+">: <"
                    + Controller.getItemName(itemID) + ">. <"
                        + Controller.getItemPrice(itemID)+"> SEK");
            System.out.println("Item <"+Controller.getItemName(itemID)+"> has not been reviewed yet.");

        }
        return "";
    }

     public String getItemMeanGrade(){ //User Story 3.4 Retrieve the mean grade of a specific item
         String userInput = UserInput.readLine("Enter the ID of Item: ");






        /*String itemID = UserInput.readLine("Enter the ID of Item: ");
         if (facade.containsReview(itemID)) {
             Review foundReview = Controller.findReview(itemID);
             System.out.println(foundReview);
         }else {
             Iterator iterator = Controller.reviewList.iterator();

             while (iterator.hasNext())
                 System.out.print(iterator.next() + System.lineSeparator());

             System.out.println();

         }*/
        return "";
    }

     public String getItemComments() { //User Story 3.5
        String itemID = UserInput.readLine("Enter the ID of Item");
        if(facade.containsReview(itemID)){
            Review foundReview = Controller.findReview(itemID);
            System.out.println(foundReview);

        }else {
            for (Review reviewItem : Controller.reviewList) {
                System.out.println("Comment: " + "<" + Controller.getItemComment(itemID) + ">");

            }
        }

        return "";

    }

    public String printAllReviews() { //User Story 3.6

        facade.printAllReviews();

        return "";
        }




//___________________________________________________________________________________________________________

    // 4.3 print transaction for specific item
    /*public String printTransactionSpecificItem() {
            String itemID = UserInput.readLine("Type the ID of the desired item for transaction to be printed");
       if (obj.containsTransaction(itemID)) {
            Item foundItem = obj.findItem(itemID);
            System.out.println(foundItem);
    } else {
        System.out.println("Item <" + itemID + " > was not registered yet.");
       }
       return "";
    }
     */

//____________________________________________ Employee ___________________________________________________
  /*
    public Employee createEmployee() {

    }
    */

    public void itemOption() {

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

        while (option < 0 || option > 7) { // 7 instead of 6 (temporarily)

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
            case 1 : createReview(); // User Story 3.1
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
            case 5 : getItemComments();// User Story 3.5
                ReviewMenu();
                break;
            case 6 : printAllReviews(); // User Story 3.6
                ReviewMenu();
                break;
            case 7 : System.out.println("Option 8");// User Story 3.7
                break;
            case 8 : System.out.println("Option 9");// User Story 3.8
                break;
            case 9 : System.out.println("Option 10");// User Story 3.9
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
            case 4 : facade.printAllTransactions();
                transactionHistoryMenu();
                break;
            case 5 : System.out.println("Option 6");
                break;
            case 6 : System.out.println("Option 7");
                break;
            case 7 : //printTransactionSpecificItem();
                transactionHistoryMenu();
                break;
            case 8 : System.out.println("Option 9");
                break;
            default : System.out.println("Please enter a valid option");
                break;
        }

        UserInput.scanner.close();
    }

    public void EmployeeMenu(){
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
                case 0:
                    MainMenu();
                    break;// create method, need help from TA with this / Carl
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

                    break;
                default : System.out.println("Please enter a valid option");
                    break;


        }
    }

    public void MainMenu(){

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

    public static void main(String[] args) {

        MenuClass mainmenu = new MenuClass();
        mainmenu.MainMenu();

        }
    }

