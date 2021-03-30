package controller.Login;
import javax.swing.*;
import java.awt.*;

import controller.Login.ApplicationView;
import controller.Login.EmployeeView;
import model.Employee;
import presentation.EmployeeOrganizer;


public class EmployeeLogInView {
    private JFrame frame;
    private JTextField usernameTextField;
    private JPasswordField passwordField;
    private JButton btnLogIn = new JButton("Login");
    private JButton btnBack = new JButton("Back");
    private JLabel lblUsername;
    private JLabel lblPassword;
    private JLabel lblNewLabel;
    private final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    public EmployeeLogInView(){

        frame = new JFrame("Employee Login");
        frame.setVisible(true);
        initialize();
        addItemsToFrame();
    }

    public void initialize(){

        lblUsername = new JLabel("Username");
        lblUsername.setBounds(50, 88, 98, 22);

        lblPassword = new JLabel("Password");
        lblPassword.setBounds(50, 140, 98, 22);

        usernameTextField = new JTextField();
        usernameTextField.setBounds(126,89,166,20);
        usernameTextField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(126,141,166,20);


        btnLogIn.setBounds(230, 196, 75, 30);
        btnBack.setBounds(50, 196, 75, 30);

        lblNewLabel = new JLabel("Introduce credentials");
        lblNewLabel.setFont(new Font("Franklin Gothic Demi", Font.BOLD | Font.ITALIC, 16));
        lblNewLabel.setBounds(103, 25, 227, 22);

        frame.setBounds(500, 500, 380, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);

        buttonActionListeners();


    }

    public void addItemsToFrame(){
        frame.getContentPane().add(btnLogIn);
        frame.getContentPane().add(usernameTextField);
        frame.getContentPane().add(passwordField);
        frame.getContentPane().add(lblUsername);
        frame.getContentPane().add(lblNewLabel);
        frame.getContentPane().add(lblPassword);
        frame.getContentPane().add(btnBack);
    }

    public void verifyUsernamePassword(){
        String username = usernameTextField.getText();
        String password = new String (passwordField.getPassword());
        EmployeeOrganizer organizer = new EmployeeOrganizer();
        Employee employee = organizer.findEmployee(username);

        if (employee == null) {
            JOptionPane.showMessageDialog(frame, "Invalid username");
        }
        else if (employee.getPassword().equals(password)==false){
            JOptionPane.showMessageDialog(frame, "Invalid password");
            }
        else {
            new EmployeeView();
            frame.setVisible(false);

        }

    }

    private void buttonActionListeners() {
        btnBack.addActionListener(e -> {
            new ApplicationView();
            frame.setVisible(false);
        });

        btnLogIn.addActionListener(e -> {
            verifyUsernamePassword();
        });

    }
}
