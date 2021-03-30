package controller.Employee;

import controller.Login.AdministratorView;
import model.Employee;
import presentation.EmployeeOrganizer;
import utils.ApplicationUtils;

import javax.swing.*;
import java.awt.*;

public class NewEmployeeView {

    private JFrame frame;
    private JTextField nameEmployeeTextField;
    private JTextField usernameTextField;
    private JTextField passwordTextField;
    private JButton btnAddEmployee = new JButton("Add Employee");
    private JButton btnBack = new JButton("Back");
    private JLabel lblName;
    private JLabel lblUsername;
    private JLabel lblPassword;

    private final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    public NewEmployeeView(){
        frame = new JFrame("Add Employee");
        frame.setVisible(true);
        initialize();
        addItemsToFrame();
    }

    public void initialize(){

        lblName = new JLabel("Employee Name");
        lblName.setFont(new Font("Franklin Gothic Demi",  Font.ITALIC, 16));
        lblName.setBounds(10,50,150,22);

        lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Franklin Gothic Demi",  Font.ITALIC, 16));
        lblUsername.setBounds(10, 80, 150, 22);

        lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Franklin Gothic Demi",  Font.ITALIC, 16));
        lblPassword.setBounds(10,110,150,22);

        btnAddEmployee.setBounds(200, 196, 150, 30);
        btnBack.setBounds(30, 196, 100, 30);


        nameEmployeeTextField = new JTextField();
        nameEmployeeTextField.setBounds(175,50,150,22);

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
        frame.getContentPane().add(nameEmployeeTextField);
        frame.getContentPane().add(usernameTextField);
        frame.getContentPane().add(passwordTextField);
        frame.getContentPane().add(btnAddEmployee);
        frame.getContentPane().add(btnBack);
    }

    private void getDataFromTextFields(){
        Employee employee = new Employee();
        String name = nameEmployeeTextField.getText();
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        employee.setIdEmployee(ApplicationUtils.generateNewUUID());
        employee.setNameEmployee(name);
        employee.setUsername(username);
        employee.setPassword(password);
        EmployeeOrganizer.insertEmployee(employee);

    }

    private void buttonActionListeners() {
        btnBack.addActionListener(e -> {
            new AdministratorView();
            frame.setVisible(false);
        });

        btnAddEmployee.addActionListener(e -> {
            getDataFromTextFields();
            JOptionPane.showMessageDialog(frame, "Employee inserted");
        });
    }
}
