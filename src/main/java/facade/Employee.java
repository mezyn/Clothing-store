package facade;

public class Employee {

    //attributes of the Employee class
    private String employeeID;
    private String employeeName;
    private double grossSalary;

    //Default constructor - necessary?
    public Employee () {}

    //Constructor
    public Employee (String employeeID, String employeeName, double grossSalary) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.grossSalary = grossSalary;
    }

    //Getters and setters


    protected String getID() {
        return employeeID;
    }

    protected String getEmployeeName() {
        return employeeName;
    }

    protected double getGrossSalary() {
        return grossSalary;
    }

    protected void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    protected void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    //Net salary of regular employee
    protected double getNetSalary() {
        double netSalary = grossSalary - (grossSalary * 0.1);
        return netSalary;
    }

    public String toString() {

        return employeeName + "'s gross salary is " + grossSalary + " SEK per month.";
    }
}
