package controller.Employee;

import controller.Login.AdministratorView;

import javax.swing.*;
import java.awt.*;

public class EmployeesTableView {

    JFrame frame;
    public JTable employeesTable ;
    JButton btnBack;
    private final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    public EmployeesTableView(){

        frame = new JFrame("View Employees Informations");
        employeesTable = new JTable();
        initialize();
        addItemsToPane();
        frame.setVisible(true);

    }

    public void initialize(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        employeesTable.setBounds(30, 40, 700, 230);

        frame.setSize(800,450);

        btnBack = new JButton("Back");
        btnBack.setBounds(30, 300, 75, 43);

        btnActionListeners();

    }

    public void addItemsToPane(){

        frame.getContentPane().add(employeesTable);
        frame.getContentPane().add(btnBack);
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
    }

    private void btnActionListeners(){
        btnBack.addActionListener(e -> {
            new AdministratorView();
            frame.setVisible(false);
        });


    }
}
