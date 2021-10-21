

// Here I will store code which is not being used. But might need in later

/* public boolean containsItemComment(String itemComment) {

        for (int i = 0; i < Item.getReviewsList().size(); i++) {
            if (Item.getReviewsList().get(i).getID().equals(itemComment)) {
                return true;
            }
        }
        return false;
    }

     public Review findItemComment(String itemComment) {

        for (Review review : Item.getReviewList()) {
            //the code below won't work, because here you're comparing 'review.getID()' and 'itemComment', which will
            //never be equal. So you need to add 'getItemComment()' after 'getID()', so that you're actually comparing
            //comment to comment.
            if (review.getID().equals(itemComment)) {
                return review;
            }
        }
        return null;
    }



     public String getItemGrade(String itemID) { // Used in getItemMeanGrade
        double itemGrade = findItemGrade(itemID).getItemGrade();
        return String.valueOf(itemGrade);
    }



    public Review findItemGrade(String itemGrade) {

        for (Review review : Item.getReviewList()) {
            if (review.getID().equals(itemGrade)) {
                return review;
            }
        }
        return null;
    }
     public boolean containsItemGrade(String itemGrade) {

        for (int i = 0; i < Item.getReviewList().size(); i++) {
            if (Item.getReviewList().get(i).getID().equals(itemGrade)) {
                return true;
            }
        }
        return false;
    }

     public boolean containsItemName(String itemName) {

        for (int i = 0; i < Item.getReviewList().size(); i++) {
            if (Item.getReviews().get(i).getID().equals(itemName)) {
                return true;
            }
        }
        return false;
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

    //_______________________________Mean Grade of Review____________________________________________

    public String getItemMeanGrade() {
          if (reviewList.size() == 0) {
              System.out.println("No reviews have been added:" + System.lineSeparator());
          } else {
              System.out.println("Grade of item: ");
          }
          for (Review reviewGrade : reviewList) {
              System.out.print( reviewGrade + System.lineSeparator());

          }
          return "";
      }

       public String getItemID(String itemID) {
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

     /* Old version
       String itemID = UserInput.readLine("Enter the ID of Item");
        if(Controller.containsReview(itemID)){
            Review foundReview = Controller.findReview(itemID);
            System.out.println(foundReview);

        }else {
            for (Review reviewItem : Controller.reviewList) {
                System.out.println("Comment: " + "<" + Controller.getItemComment(itemID) + ">");

            }
        }

        return "";

    }
      // old print all review.
        /* public String printAllReviews() { // User Story 3.6 //
        String allReview = null;
        if (Item.getReviewList().size() == 0) {
            return ("No items registered yet.");
        } else {

            allReview = "All registered reviews:" +
                    System.lineSeparator() +
                    "------------------------------------" +
                    System.lineSeparator();

            for (Review review : Item.getReviewList()) {
                System.out.println("Review(s) for <ID>: <Item Name>. <Price> SEK");
                //"Review(s) for "+  +": "+ getItemName() +". "+ getItemName() +" SEK"); // ask TA

                System.out.println(review);
                allReview += review + System.lineSeparator();
            }
        }
        return allReview;
    }
    /* public String printMostReviewedItems() {

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

    } */

    /*ArrayList<String> mostReviewItemList = new ArrayList<>();

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

    /*public Review findReview(String review) {
          Item item = findItem(itemID);

           for (int i = 0; i < Item.getReviews().size(); i++) {
               if (Item.getReviews().get(i).getID().equals(itemID)) {
                   return Item.getReviews().get(i);
               }
           }
           return null;
       }*

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
    }
    /*public String printAllReviews() { // User Story 3.6 // OLD VERSION

            if(itemList.size() == 0) {
                return "No items registered yet.";
            }else if (getReviewList().size()==0) {
                return "No items were reviewed yet.";
            }else {
                String header = "All registered reviews:" +
                        System.lineSeparator() +
                        "------------------------------------" +
                        System.lineSeparator();
                String reviewtext = "Grade: <grade>.<written comment>";

                for (Item item : getItemList()) {
                    return "Review(s) for " + item;

                        for (Review review : item.getReviewList()) {
                            return "" + review;
                    }
                }
            }
            return " ";
        }
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
                String toReturn = "Review(s) for "+item.toString() + System.lineSeparator();
                Review reviewItem = item.getReviewList().get(reviewNumber - 1);
                        return toReturn + reviewItem.toString();
                        }
                        }
                        }
                        */

/* /*public List<String> printMostReviewedItems() { // getMostReviewedItems // old

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
    }
     /*  public Review findReview(String review) { // In case its wrong ^

        for (int i = 0; i < Item.getReviewList().size(); i++) {
            if (Item.getReviewList().get(i).getID().equals(itemID)) {
                return Item.getReviewList().get(i);
            }
        }
        return null;
    }


        /* public List<String> getBestReviewedItems() {
            int bestGradeReview = itemList.get(0).getReviewList().size();

            double sumGrade = 0.0;
            double meanGrade;

            ArrayList<String> bestGradeList = new ArrayList<>();

            for (int i = 0; i < itemList.size(); i++) {
                bestGradeReview += itemList.get(i).getReviewList().size();

                if (itemList.size() == 0) { // Checks if item list is empty.
                    System.out.println("No items registered yet.");
                } else if (bestGradeReview == 0) { // Checks if review list is empty.
                    System.out.println("No items were reviewed yet.");
                } else {

                    int reviewList = itemList.get(i).getReviewList().size();

                    for (i = 0; i < reviewList; i++) {
                        sumGrade += itemList.get(i).getReviewList().get(i).getItemGrade();

                        meanGrade = changeDecimal(sumGrade / reviewList, 1);

                        for (i = 0; i < itemList.size(); i++) {
                            if (itemList.get(i).getReviewList().size() > meanGrade) {

                                meanGrade = itemList.get(i).getReviewList().size();
                            }
                        }
                        for (i = 0; i < itemList.size(); i++) {
                            if (itemList.get(i).getReviewList().size() == meanGrade) {
                                bestGradeList.add(itemList.get(i).getID());
                            }
                        }
                        if (bestGradeList.size() > 1) {
                            int index = bestGradeList.size() - 1;
                            bestGradeList.remove(index);
                        }
                    }
                }
            }
            return bestGradeList;
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
    }

    */
        /*public String getItemName(String itemID) { // In Use

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

                }*/