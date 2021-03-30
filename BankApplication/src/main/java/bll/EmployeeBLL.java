package bll;

import dao.EmployeeDAO;
import model.Client;
import model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class EmployeeBLL {

    private static EmployeeDAO employeeDAO;

    public EmployeeBLL(){

        employeeDAO = new EmployeeDAO();

    }

    public Employee insert(String idEmployee, String nameEmployee, String username, String password ){
        Employee employee = employeeDAO.insert(idEmployee,nameEmployee,username,password);
        if (employee==null){
            throw new NoSuchElementException("The employee with id " + idEmployee + " was not inserted!");
        }

        return employee;
    }

    public Employee delete(String nameEmployee){
        Employee employee = employeeDAO.delete(nameEmployee);
        if (employee == null){
            throw new NoSuchElementException("The employee with id " + nameEmployee + " was not deleted!");
        }

        return employee;
    }

    public  Employee findByUsername(String username){
        Employee employee=employeeDAO.findByUsername(username);

        if (employee == null){
            throw new NoSuchElementException("The employee with username: " + username + " was not found!");
        }
        return employee;
    }

    public  Employee findByName(String name){
        Employee employee=employeeDAO.findByName(name);

        if (employee == null){
            throw new NoSuchElementException("The employee with name: " + name + " was not found!");
        }
        return employee;
    }

    public Employee update(String name, String username, String password) {
        Employee employee = employeeDAO.update(name,username,password);

        if (employee == null) {
            throw new NoSuchElementException("The employee with username =" + username + " was not updated!");
        }
        return employee;
    }

    public static List<Employee> selectAll() {
        List<Employee>employees = new ArrayList<Employee>();
        employees = employeeDAO.selectAll();
        if (employees == null) {
            throw new NoSuchElementException("Elements were not found!");
        }
        return employees;
    }
}
