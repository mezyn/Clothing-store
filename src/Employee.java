public class Employee {

    //attributes of the Employee class
    private String ID;
    private String name;
    private double grossSalary;


    //Constructor
    public Employee (String ID, String name, double grossSalary) {
        this.ID = ID;
        this.name = name;
        this.grossSalary = grossSalary;
    }

    //Getters and setters


    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    //toString

    public String toString() {
        return "<" + this.name + ">'s gross salary is <" + grossSalary + "> SEK per month.";
    }
}
