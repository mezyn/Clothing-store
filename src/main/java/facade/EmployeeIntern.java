package facade;

import java.text.DecimalFormat;

public class EmployeeIntern extends Employee {

    double GPA;

    public EmployeeIntern(String employeeID, String employeeName, double grossSalary, double GPA) {
        super(employeeID, employeeName, grossSalary);
        this.GPA = GPA;
    }

    @Override
    public double getGrossSalary() {
        if (GPA < 5 || GPA == 5) {
            return 0;
        } else if (GPA > 5 || GPA < 8) {
            return super.getGrossSalary();
        } else {
            return super.getGrossSalary() + 1000;
        }
    }

    @Override
    public double getNetSalary() {
        return getGrossSalary();
    }

    public double getGPA(){
        return this.GPA;
    }
    public void setGPA(double newGPA) {
        this.GPA = newGPA;
    }

    @Override
    public String toString() {
        DecimalFormat decimal2 = new DecimalFormat("###.00");
        String grossSalary = decimal2.format(getGrossSalary());
        return getEmployeeName() + "'s gross salary is " + getGrossSalary() + " SEK per month. GPA: " + this.GPA;
    }
}
