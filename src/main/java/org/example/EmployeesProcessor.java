package org.example;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeesProcessor {
    private EmployeesDao employeesDao;

    public  EmployeesProcessor (EmployeesDao employeesDao) {
        this.employeesDao = employeesDao;
    }


    public List<Employees> filterByPosition() throws SQLException {
        return employeesDao.getAllEmployees()
                .stream()
                .filter(employees -> employees.getPosition().equals("ubralod kargi adamiani"))
                .collect(Collectors.toList());
    }

    public Double findMaxSalary() throws SQLException {
        return employeesDao.getAllEmployees()
                .stream()
                .mapToDouble(Employees::getSalary)
                .max().orElse(0);
    }

    public Double averageSalary() throws SQLException {
        return employeesDao.getAllEmployees()
                .stream()
                .mapToDouble(Employees::getSalary)
                .average()
                .orElse(0);
    }
}
