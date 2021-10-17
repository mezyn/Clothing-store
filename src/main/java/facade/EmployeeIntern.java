package facade;

import java.text.DecimalFormat;

public class EmployeeIntern extends Employee {

    int GPA;

    public EmployeeIntern(String employeeID, String employeeName, double grossSalary, int GPA) {
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
    public double getNetSalary() {
        return getGrossSalary();
    }

    public int getGPA(){
        return this.GPA;
    }
    public void setGPA(int newGPA) {
        this.GPA = newGPA;
    }

    @Override
    public String toString() {
        DecimalFormat decimal2 = new DecimalFormat("##0.00");
        String grossSalary = decimal2.format(this.getGrossSalary());
        return getEmployeeName() + "'s gross salary is " + grossSalary + " SEK per month. GPA: " + this.GPA;
    }
}
