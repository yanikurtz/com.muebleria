package dao.impl;

import dao.EmployeeDao;
import model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    private List<Employee> employees = new ArrayList<>();

    public EmployeeDaoImpl(){

        employees.add(new Employee(1, "angela"));
        employees.add(new Employee(2, "antonio"));
        employees.add(new Employee(3, "ulises"));
        
    }

    @Override
    public List<Employee> getEmployees(){
        return employees;
    }

    @Override
    public Employee getEmployeeById(Integer id){
        for (int i=0; i < employees.size(); i ++){
            if (employees.get(i).getId().equals(id)){
                return employees.get(i);
            }
        }
        return null;
    }

}
