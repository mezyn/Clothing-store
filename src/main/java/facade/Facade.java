package facade;

import java.util.List;
import java.util.Map;

public class Facade {
Controller controller = new Controller();


//----------------------------- For items --------------------------------------------

    public String createItem(String itemID, String itemName, double unitPrice){
        return controller.createItem(itemID, itemName, unitPrice);
    }

    public String updateItemName(String itemID, String newName) {
        return controller.updateItemName(itemID,newName);

    }

    public String updateItemPrice(String itemID, double newPrice) {
        return controller.updateItemPrice(itemID, newPrice);

    }

    public String removeItem(String itemID) {
        return controller.removeItem(itemID);

    }

    public boolean containsItem(String itemID) {
        return controller.containsItem(itemID);
    }

    public double buyItem(String itemID, int amount) {
        return controller.buyItem(itemID, amount);
    }

    public String printItem(String itemID) {

        return controller.printItem(itemID);
    }

    public String printAllItems() {

        return controller.printAllItems();

    }


    // ------------------------------- For reviews ------------------------------------

    public String reviewItem(String itemID, String reviewComment, int reviewGrade) { // 3.1 user story

        return controller.reviewItem(itemID, reviewComment, reviewGrade);
    }

    public String reviewItem(String itemID, int reviewGrade) { // 3.1 user story

        return controller.reviewItemWithoutComment(itemID, reviewGrade);
    }

    public String getItemCommentsPrinted(String itemID) {

        return controller.getItemCommentsPrinted(itemID);
    }

    public List<String> getItemComments(String itemID) {

        return controller.getItemComments(itemID);
    }

    public double getItemMeanGrade(String itemID) {

        return controller.getItemMeanGrade(itemID);
    }

    public int getNumberOfReviews(String itemID) {

        return controller.getNumberOfReviews(itemID);
    }

    public String getPrintedItemReview(String itemID, int reviewNumber) {// 3.2 user Story

        return controller.getPrintedItemReview(itemID, reviewNumber);
    }

    public String getPrintedReviews(String itemID) { // 3.3 user story

        return controller.getPrintedReviews(itemID);
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


    public String printAllReviews() {  // for US 3.6

        return controller.printAllReviews();
    }



    // ------------------------------- for transaction history ---------------------------------

    public double getTotalProfit() {return controller.getTotalProfit();}

    public String printItemTransactions(String itemID) {return controller.printItemTransactions(itemID);}

    public int getTotalUnitsSold() {return controller.getTotalUnitsSold();}

    public int getTotalTransactions() {return controller.getTotalTransactions();}

    public double getProfit(String itemID) {return controller.getProfit(itemID);}

    public int getUnitsSolds(String itemID) {return controller.getUnitsSolds(itemID);}

    public String printAllTransactions() {return controller.printAllTransactions();}

    public String printMostProfitableItems() {return controller.printMostProfitableItems();}

    // ------------------------------- for Employee ---------------------------------

    /*public String createEmployee(String employeeID, String employeeName, double grossSalary) throws Exception {
        controller.createEmployee(employeeID, employeeName, grossSalary);
        return "";
    }*/

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

    public Map<String, Integer> mapEachDegree() throws Exception {
        return null;
    }

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




