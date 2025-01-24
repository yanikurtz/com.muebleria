package dao.impl;

import dao.EmployeeDao;
import model.Employee;

import java.util.ArrayList;
import java.util.List;


public class EmployeeDaoImpl implements EmployeeDao {

    private List<Employee> employees = new ArrayList<>();

    public EmployeeDaoImpl(){

        employees.add(new Employee(1, "Angela"));
        employees.add(new Employee(2, "Antonio"));
        employees.add(new Employee(3, "Ulises"));
        
    }

    @Override
    public List<Employee> getEmployees(){
        return new ArrayList<>(employees);
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employees.stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void addEmployee(Employee employee) {
        if (employees.stream().anyMatch(e -> e.getId().equals(employee.getId()))) {
            throw new IllegalArgumentException("Employee with ID " + employee.getId() + " already exists.");
        }
        employees.add(employee);
    }

    @Override
    void removeEmployee(Integer Id) {
        employees.removeIf(employee -> employee.getId().equals(Id));
    }

}
