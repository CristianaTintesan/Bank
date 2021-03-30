package dao;

import model.Client;
import model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO extends AbstractDAO<Employee>{

    public Employee insert(String idEmployee, String nameEmployee, String username, String password){
        ArrayList<Object> list = new ArrayList<Object>();
        list.add(idEmployee);
        list.add(nameEmployee);
        list.add(username);
        list.add(password);
        return super.insert(list);
    }

    public Employee delete(String name) {
        ArrayList<Object> list = new ArrayList<Object>();
        ArrayList<String> names = new ArrayList<String>();
        if (name != "") {
            list.add(name);
            names.add("Username");
        }
        return super.delete(list, names);
    }

    public Employee findByName(String name){

        return super.findByUsername(name);
    }

    public Employee findByUsername(String username){

        return super.findByUsername(username);
    }

    public Employee update(String name, String username, String password) {
        ArrayList<Object> list = new ArrayList<Object>();
        list.add(name);
        list.add(username);
        list.add(password);
        ArrayList<String> names = new ArrayList<String>();
        names.add("nameEmployee");
        names.add("Username");
        names.add("Password");
        return super.update(list, names, name, "nameEmployee");
    }

    public List<Employee> selectAll() {
        return super.selectAll();
    }
}
