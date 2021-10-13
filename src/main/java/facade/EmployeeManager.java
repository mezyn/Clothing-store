package facade;

public class EmployeeManager extends Employee {

    String degree;

    public EmployeeManager (String employeeID, String employeeName, double grossSalary, String degree) {
        super(employeeID, employeeName, grossSalary);
        this.degree = degree;
    }

    @Override
    protected double getGrossSalary() {

        double grossSalary = super.getGrossSalary();
        if (degree.equals("BSc")) {
            grossSalary = grossSalary * 1.1;
        } else if (degree.equals("MSc")) {
            grossSalary = grossSalary * 1.2;
        } else if (this.degree.equals("PhD")) {
            grossSalary = grossSalary * 1.35;
        }

        return grossSalary;
    }

    //need to fix it later
    /*
    public String toString() {
        return this. + "'s gross salary is " + grossSalary + " SEK per month.";
    }
     */

    //    public String getDegree
}
