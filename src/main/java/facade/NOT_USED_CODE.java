

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
    }*/




