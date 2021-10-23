package facade;

import java.text.DecimalFormat;

public class Employee implements Comparable<Employee> {

    protected final String employeeID;
    protected String employeeName;
    protected double grossSalary;

    // This constructor is needed to prevent creating employees with no employeeID.
    public Employee(String employeeID) {
        this.employeeID = employeeID;
    }

    //Constructor
    public Employee(String employeeID, String employeeName, double grossSalary) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.grossSalary = grossSalary;
    }

    //Getters and setters

    public String getID() {
        return employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public double getRawSalary(){
        return grossSalary;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    //Net salary of regular employee
    public double getNetSalary() {
        double netSalary = grossSalary - (grossSalary * 0.1);
        return netSalary;
    }

    public String toString() {

        DecimalFormat decimal2 = new DecimalFormat("###.00");
        String grossSalary = decimal2.format(this.grossSalary);
        return employeeName + "'s gross salary is " + grossSalary + " SEK per month.";
    }

    @Override
    public int compareTo(Employee anotherEmployee) {

        double anotherSalary = anotherEmployee.getGrossSalary();
        double comparisonResult = this.getGrossSalary() - anotherSalary;
        //System.out.println("Comparing " this.employeeName + " to " + anotherEmployee.employeeName);

        if (comparisonResult > 0.0) {
            return 1;
        } else if (comparisonResult == 0.0) {
            return 0;
        } else {
            return -1;
        }
    }

 }


