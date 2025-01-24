package dao;

import model.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> getEmployees();

    Employee getEmployeeById(Integer id);

    void addEmployee(Employee employee);
    void removeEmployee();
}
