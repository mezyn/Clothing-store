package facade;

import java.text.DecimalFormat;

public class Director extends Manager {

    protected String department;

    public Director(String employeeID, String employeeName, double grossSalary, String degree, String department) {
        super(employeeID, employeeName, grossSalary, degree);
        this.department = department;
    }

    @Override
    protected double getNetSalary() {
        double grossSalary = getGrossSalary();
        if (grossSalary < 30000) {
            return super.getNetSalary();
        } else if (grossSalary == 30000 || (grossSalary > 30000 && grossSalary < 50000)) {
            return grossSalary - (grossSalary * 0.2);
        } else {
            double exceeding30000 = grossSalary - 30000;
            double netSalary = 30000 * (1 - 0.2) + exceeding30000 * (1 - 0.4);
            return netSalary;
        }
    }

    @Override
    protected double getGrossSalary(){
        double grossSalary = super.getGrossSalary();
        grossSalary = grossSalary + 5000;
        return grossSalary;
        }


    @Override
    public String toString() {
        DecimalFormat decimal2 = new DecimalFormat("###.00");
        String grossSalary = decimal2.format(this.getGrossSalary());
        return degree + " " + getEmployeeName() + "'s gross salary is " + grossSalary + " SEK per month. Dept: " + department;
    }

    //We know that these methods are not in use, but will leave them here for possible future usage.
    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String newDepartment) {
        this.department = newDepartment;
    }
}

