package controller.Employee;

import controller.Login.AdministratorView;
import model.Employee;
import presentation.EmployeeOrganizer;

import javax.swing.*;
import java.awt.*;

public class NewEmployeeInformation {

    private JFrame frame;
    private JTextField nameUpdateTextField;
    private JTextField usernameTextField;
    private JTextField passwordTextField;
    private JButton btnUpdate = new JButton("Update");
    private JButton btnBack = new JButton("Back");
    private JLabel lblName;
    private JLabel lblUsername;
    private JLabel lblPassword;

    private final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    public NewEmployeeInformation(){

        frame = new JFrame("Update employee information");
        frame.setVisible(true);
        initialize();
        addItemsToFrame();
    }

    public void initialize(){

        lblName = new JLabel("Employee Name");
        lblName.setFont(new Font("Franklin Gothic Demi",  Font.ITALIC, 16));
        lblName.setBounds(10,50,150,22);

        lblUsername = new JLabel("Employee Username");
        lblUsername.setFont(new Font("Franklin Gothic Demi",  Font.ITALIC, 16));
        lblUsername.setBounds(10, 80, 150, 22);

        lblPassword = new JLabel("Employee Password");
        lblPassword.setFont(new Font("Franklin Gothic Demi",  Font.ITALIC, 16));
        lblPassword.setBounds(10,110,150,22);


        btnUpdate.setBounds(200, 196, 100, 30);
        btnBack.setBounds(30, 196, 100, 30);


        nameUpdateTextField = new JTextField();
        nameUpdateTextField.setBounds(175,50,150,22);

        usernameTextField = new JTextField();
        usernameTextField.setBounds(175,83,150,22);

        passwordTextField = new JTextField();
        passwordTextField.setBounds(175,110,150,22);

        frame.setBounds(500, 500, 380, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);

        buttonActionListeners();

    }

    public void addItemsToFrame(){

        frame.getContentPane().add(lblName);
        frame.getContentPane().add(lblUsername);
        frame.getContentPane().add(lblPassword);
        frame.getContentPane().add(btnUpdate);
        frame.getContentPane().add(btnBack);
        frame.getContentPane().add(nameUpdateTextField);
        frame.getContentPane().add(usernameTextField);
        frame.getContentPane().add(passwordTextField);

    }

    private void getDataFromTextFields(){
        Employee employee = UpdateEmployeeInformation.getEmployeeToUpdate();
        String name = nameUpdateTextField.getText();
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();
        employee.setNameEmployee(name);
        employee.setUsername(username);
        employee.setPassword(password);
        EmployeeOrganizer.updateEmployee(name, username, password);

    }

    private void buttonActionListeners() {
        btnBack.addActionListener(e -> {
            new AdministratorView();
            frame.setVisible(false);
        });

        btnUpdate.addActionListener(e -> {
            getDataFromTextFields();
            new AdministratorView();
            frame.setVisible(false);
        });
    }
}
