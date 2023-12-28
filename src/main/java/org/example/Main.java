package org.example;


import java.sql.SQLException;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        try {
            Connect connect = new Connect();
            connect.connectToDb();
            EmployeesDao employeesDao = new EmployeesDao(connect);
            EmployeesProcessor employeesProcessor = new EmployeesProcessor(employeesDao);
            employeesDao.updateEmployee(new Employees(6, "shorena begashvili", "ubralod kargi adamiani", 5000.0));
            List<Employees> employees = employeesDao.getAllEmployees();
            for (int i = 0; i < employees.size(); i++) {
                System.out.println(employees.get(i));
            }

            System.out.println("Average: " + employeesProcessor.averageSalary());
            System.out.println("Filtered: " + employeesProcessor.filterByPosition());
            System.out.println("Max salary: " + employeesProcessor.findMaxSalary());
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }
}