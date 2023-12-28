package org.example;

public class Employees {
    private int id;
    private String name;
    private String position;
    private Double salary;

    public Employees(int id, String name, String position, Double salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public Double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "name: " + name +
                "\nposition: " + position +
                "\nsalary: " + salary +
                "\n------------------------";
    }
}
