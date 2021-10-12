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

    public String reviewItem(String itemID, String reviewComment, int reviewGrade) { // 3.1 user story

        return controller.reviewItem(itemID, reviewComment, reviewGrade);
    }

    public String reviewItem(String itemID, int reviewGrade) { // 3.1 user story
        reviewItem(itemID, "", reviewGrade);
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

    public String getPrintedItemReview(String itemID, int reviewNumber) {// 3.2 user Story


        return controller.getPrintedItemReview(itemID, reviewNumber);
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

        controller.printAllReviews();

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
        controller.getTotalTransactions();
        return -1;
    }

    public double getProfit(String itemID) {
        return -1.0;
    }

    public int getUnitsSolds(String itemID) {
        return -1;
    }

    /*public boolean containsTransaction(String itemID) {
        controller.containsTransaction(itemID);
        return controller.containsItem(itemID);
    }*/

    public String printAllTransactions() {
        controller.printAllTransactions();
        return "";
    }


    public String printMostProfitableItems() {
        return "";
    }

    // ------------------------------- for Employee ---------------------------------

    public String createEmployee(String employeeID, String employeeName, double grossSalary) throws Exception {
        controller.createEmployee(employeeID, employeeName, grossSalary);
        return "";
    }

    public String printEmployee(String employeeID) throws Exception {
        return "";
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree) throws Exception {
        return "";
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, int gpa) throws Exception {
        return "";
    }

    public double getNetSalary(String employeeID) throws Exception {
        return -1.0;
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree, String dept) throws Exception {
        return "";
    }

    public String removeEmployee(String empID) throws Exception {
        return "";
    }

    public String printAllEmployees() throws Exception {
        return "";
    }

    public double getTotalNetSalary() throws Exception {
        return -1.0;
    }

    public String printSortedEmployees() throws Exception {
        return "";
    }

    public String updateEmployeeName(String empID, String newName) throws Exception {
        return "";
    }

    public String updateInternGPA(String empID, int newGPA) throws Exception {
        return "";
    }

    public String updateManagerDegree(String empID, String newDegree) throws Exception {
        return "";
    }

    public String updateDirectorDept(String empID, String newDepartment) throws Exception {
        return "";
    }

    public String updateGrossSalary(String empID, double newSalary) throws Exception {
        return "";
    }

    /*public Map<String, Integer> mapEachDegree() throws Exception {
        return null;
    }*/

    public String promoteToManager(String empID, String degree) throws Exception {
        return "";

    }

    public String promoteToDirector(String empID, String degree, String department) throws Exception {
        return "";
    }

    public String promoteToIntern(String empID, int gpa) throws Exception {
        return "";
    }
}




