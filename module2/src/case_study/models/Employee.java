package case_study.models;

import java.io.Serializable;

public class Employee extends Person implements Serializable{
    private String level;
    private String location;
    private double salary;

    public Employee() {
    }

    public Employee(String level, String location, double salary) {
        this.level = level;
        this.location = location;
        this.salary = salary;
    }

    public Employee(String id, String name, String dateOfBirth, String gender, int numberCMND, int phone, String email, String level, String location, double salary) {
        super(id, name, dateOfBirth, gender, numberCMND, phone, email);
        this.level = level;
        this.location = location;
        this.salary = salary;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "level='" + level + '\'' +
                ", location='" + location + '\'' +
                ", salary='" + salary + '\'' +
                '}' + ", which is a subclass of " +
                super.toString();
    }
}
