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
        } else if (degree.equals("PhD")) {
            grossSalary = grossSalary * 1.35;
        }

        return grossSalary;
    }

    public String toString() {
        return degree + " " + this.getEmployeeName() + "'s gross salary is " + this.getGrossSalary() + " SEK per month.";
    }

}
