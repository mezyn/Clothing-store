package facade;

import java.text.DecimalFormat;
import java.util.Comparator;

public class Employee implements Comparable<Employee> {

    //attributes of the Employee class
    protected String employeeID;
    protected String employeeName;
    protected double grossSalary;

    //Default constructor - necessary?
    public Employee() {
    }

    //Constructor
    public Employee(String employeeID, String employeeName, double grossSalary) {
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

    //Is it really necessary??
    protected double getRawSalary(){
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


