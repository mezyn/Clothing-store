import java.util.List;

public class Facade {
Controller controller = new Controller();


//----------------------------- For items --------------------------------------------

    public String createItem(String itemID, String itemName, double unitPrice){
        return controller.createItem(itemID, itemName, unitPrice);
    }

    public String updateItemName(String itemID, String newName) {
        controller.updateItemName(itemID,newName);
        return "";
    }

    public String updateItemPrice(String itemID, double newPrice) {
        controller.updateItemPrice(itemID, newPrice);
        return "";
    }

    public String removeItem(String itemID) {
        controller.removeItem(itemID);
        return "";
    }

    public boolean containsItem(String itemID) {
        controller.findReview(itemID);
        return controller.containsItem(itemID);
    }

    public boolean containsReview(String reviewID) { // added by Carl,
        controller.findReview(reviewID);
        return controller.containsItem(reviewID);
    }
    /*public String getItemName(String itemName) { // added by Carl, used in getPrintedReviews line 164 in main
        return controller.getItemName(itemID);
    }*/

    public double buyItem(String itemID, int amount) {
        controller.buyItem(itemID, amount);
        return 0.0;
    }

    public String printItem(String itemID) {

        controller.printItem(itemID);
        return "";
    }

    public String printAllItems() {

        controller.printAllItems();

        return "";
    }



    // ------------------------------- For reviews ------------------------------------

    public String reviewItem(String itemID, String reviewComment, int reviewGrade) {


        return controller.createReview(itemID, reviewComment, reviewGrade);
    }

    public String reviewItem(String itemID, int reviewGrade) { // Think we don't need this one since we have comment?
        //We need to keep this. We need two 'reviewItem()' which have difference in arguments.This one doesn't take 'comment' as an argument
        return "";
    }

    public String getItemCommentsPrinted(String itemID) {
        return "";
    }

    public List<String> getItemComments(String itemID) {
        return null;
    }

    public double getItemMeanGrade(String itemID) {
        return -1.0;
    }

    public int getNumberOfReviews(String itemID) {
        return -1;
    }

    public String getPrintedItemReview(String itemID, int reviewNumber) {
        return "";
    }

    public String getPrintedReviews(String itemID) { // 3.3 user story

        return "";
    }

    public String printMostReviewedItems() {
        return "";
    }

    public List<String> getMostReviewedItems() {
        return null;
    }

    public List<String> getLeastReviewedItems() {
        return null;
    }

    public String printLeastReviewedItems() {
        return "";
    }

    public String printWorseReviewedItems() {
        return "";
    }

    public String printBestReviewedItems() {
        return "";
    }

    public List<String> getWorseReviewedItems() {
        return null;
    }

    public List<String> getBestReviewedItems() {
        return null;
    }

    public String printAllReviews() {
        return "";
    }



    // ------------------------------- for transaction history ---------------------------------

    public double getTotalProfit() {
        return -1.0;
    }

    public String printItemTransactions(String itemID) {
        return "";
    }

    public int getTotalUnitsSold() {
        return -1;
    }

    public int getTotalTransactions() {
        return -1;
    }

    public double getProfit(String itemID) {
        return -1.0;
    }

    public int getUnitsSolds(String itemID) {
        return -1;
    }

    public String printAllTransactions() {
        return "";
    }


    public String printMostProfitableItems() {
        return "";
    }



}
