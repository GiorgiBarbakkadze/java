package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDao {
    private final Connect connect;

    public EmployeesDao(Connect connect) {
        this.connect = connect;
    }

    public List<Employees> getAllEmployees() throws SQLException {
        List<Employees> allEmployees = new ArrayList<>();
        String query = "SELECT * FROM emps";

        Connection connection = connect.getConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Employees employee = new Employees(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("position"),
                    resultSet.getDouble("salary"));
            allEmployees.add(employee);
        }

        return allEmployees;
    }

    public void addEmployee(Employees employee) throws SQLException {
        String query = "INSERT INTO emps (name, position, salary) VALUES (?,?,?)";
        Connection connection = connect.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, employee.getName());
        preparedStatement.setString(2, employee.getPosition());
        preparedStatement.setDouble(3, employee.getSalary());
        preparedStatement.executeUpdate();
    }

    public void updateEmployee(Employees employee) throws SQLException{
        String query = "UPDATE emps SET name=?, position=?, salary=? WHERE id=?";

        Connection connection = connect.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, employee.getName());
        preparedStatement.setString(2, employee.getPosition());
        preparedStatement.setDouble(3, employee.getSalary());
        preparedStatement.setDouble(4, employee.getId());
        preparedStatement.executeUpdate();
    }
}
