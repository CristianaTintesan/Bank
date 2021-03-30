package presentation;
import bll.ClientBLL;
import bll.EmployeeBLL;
import model.Client;
import model.Employee;
import start.ApplicationStart;
import validator.EmployeeValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeOrganizer {

    protected static final Logger LOGGER = Logger.getLogger(ApplicationStart.class.getName());

    public static Employee findEmployee(String username){

        EmployeeBLL employeeBLL = new EmployeeBLL();
        try {
            Employee employee = employeeBLL.findByUsername(username);
            if (employee.getUsername() != "")
                return employee;
        } catch (Exception ex) {
            LOGGER.log(Level.INFO, ex.getMessage());
        }

        return null;
    }

    public static Employee findEmployeeByName(String name){

        EmployeeBLL employeeBLL = new EmployeeBLL();
        try {
            Employee employee = employeeBLL.findByName(name);
            if (employee.getNameEmployee() != "")
                return employee;
        } catch (Exception ex) {
            LOGGER.log(Level.INFO, ex.getMessage());
        }

        return null;
    }

    public static void insertEmployee(Employee employee){
        EmployeeValidator.validateInsertNewEmployee(employee);
        EmployeeBLL employeeBLL = new EmployeeBLL();
        try{
            employeeBLL.insert(employee.getIdEmployee(),employee.getNameEmployee(),employee.getUsername(),employee.getPassword());
        } catch (Exception ex){
            LOGGER.log(Level.INFO, ex.getMessage());
        }
    }

    public static void deleteEmployee(String name){
        EmployeeBLL employeeBLL = new EmployeeBLL();
        try{
            employeeBLL.delete(name);
        }catch (Exception ex){
            LOGGER.log(Level.INFO, ex.getMessage());
        }
    }

    public static Employee updateEmployee(String name, String username, String password) {
        EmployeeBLL employeeBLL = new EmployeeBLL();
        EmployeeValidator.validateUpdateNewEmployee(name, username, password);
        try {
            Employee employee = employeeBLL.update(name, username, password);
            return employee;
        } catch (Exception ex) {
            LOGGER.log(Level.INFO, ex.getMessage());
        }
        return null;
    }

    public static List<Employee> selectAllEmployees(){

        EmployeeBLL employeeBLL = new EmployeeBLL();
        try{
            List<Employee> employees = employeeBLL.selectAll();
            return employees;
        }catch (Exception ex){
            LOGGER.log(Level.INFO, ex.getMessage());
        }
        return null;
    }
}
