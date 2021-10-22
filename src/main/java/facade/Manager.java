package facade;

import java.text.DecimalFormat;

public class Manager extends Employee {

    protected String degree;

    public Manager(String employeeID, String employeeName, double grossSalary, String degree) {
        super(employeeID, employeeName, grossSalary);
        this.degree = degree;
    }


    @Override
    protected double getGrossSalary() {

        double grossSalary = super.grossSalary;
        if (degree.equals("BSc")) {
            grossSalary = grossSalary * 1.1;
        } else if (degree.equals("MSc")) {
            grossSalary = grossSalary * 1.2;
        } else if (degree.equals("PhD")) {
            grossSalary = grossSalary * 1.35;
        }
        return Controller.changeDecimal(grossSalary, 2);
    }

    @Override
    protected double getNetSalary() {
        double netSalary = getGrossSalary() - (getGrossSalary() * 0.1);
        return netSalary;
    }

    @Override
    public String toString() {

        DecimalFormat decimal2 = new DecimalFormat("###.00");
        String grossSalary = decimal2.format(getGrossSalary());
        return degree + " " + this.getEmployeeName() + "'s gross salary is " + grossSalary + " SEK per month.";
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String newDegree) {

        this.degree = newDegree;

    }
}
