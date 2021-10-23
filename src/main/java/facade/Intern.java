package facade;

import java.text.DecimalFormat;

public class Intern extends Employee {

    private int GPA;

    public Intern(String employeeID, String employeeName, double grossSalary, int GPA) {
        super(employeeID, employeeName, grossSalary);
        this.GPA = GPA;
    }

    @Override
    public double getGrossSalary() {
        if (GPA < 5 || GPA == 5) {
            return 0.0;

        } else if (GPA > 5 && GPA < 8) {
            return super.getGrossSalary();
        } else {
            return super.getGrossSalary() + 1000;
        }
    }

    @Override
    protected double getNetSalary() {
        return getGrossSalary();
    }

    //We know that this method is not in use, but will leave it here for possible future usage.
    protected int getGPA() {
        return GPA;
    }

    protected void setGPA(int newGPA) {
        this.GPA = newGPA;
    }

    @Override
    public String toString() {
        DecimalFormat decimal2 = new DecimalFormat("##0.00");
        String grossSalary = decimal2.format(this.getGrossSalary());
        return getEmployeeName() + "'s gross salary is " + grossSalary + " SEK per month. GPA: " + this.GPA;
    }


}
