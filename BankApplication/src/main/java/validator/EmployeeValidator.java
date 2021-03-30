package validator;

import model.Client;
import model.Employee;

public class EmployeeValidator {

    public static void validateInsertNewEmployee(Employee employee){
        if(employee.getNameEmployee() == null | employee.getNameEmployee().length()<6){
            throw new IllegalArgumentException("Name must have at least 6 characters long!");

        }
        if(employee.getUsername()==null | employee.getUsername().length()<6){
            throw new IllegalArgumentException("Username must have at leats 6 characters long!");
        }
        if (employee.getPassword()==null | employee.getPassword().length()<6){
            throw new IllegalArgumentException("Password must have at leats 6 characters long!");
        }

    }

    public static void validateUpdateNewEmployee(String name, String username, String password){
        if(name.length()<6){
            throw new IllegalArgumentException("Name must have at least 6 characters long!");
        }
        if(username.length()<6){
            throw new IllegalArgumentException("Username must have at leats 6 characters long!");
        }
        if (password.length()<6){
            throw new IllegalArgumentException("Password must have at leats 6 characters long!");
        }

    }

}
