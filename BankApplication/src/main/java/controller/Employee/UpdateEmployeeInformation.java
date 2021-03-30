package controller.Employee;

import controller.Login.AdministratorView;
import model.Employee;
import presentation.EmployeeOrganizer;

import javax.swing.*;
import java.awt.*;

public class UpdateEmployeeInformation {

    private JFrame frame;
    private static JTextField usernameEmployeeTextField;
    private JButton btnNext = new JButton("Next");
    private JButton btnBack = new JButton("Back");
    private JLabel lblUsername;
    private final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    public UpdateEmployeeInformation(){

        frame = new JFrame("Find employee by username");
        frame.setVisible(true);
        initialize();
        addItemsToFrame();
    }

    public void initialize(){

        lblUsername = new JLabel("Employee Username");
        lblUsername.setFont(new Font("Franklin Gothic Demi",  Font.ITALIC, 16));
        lblUsername.setBounds(10,50,150,22);

        btnNext.setBounds(200, 196, 100, 30);
        btnBack.setBounds(30, 196, 100, 30);

        usernameEmployeeTextField= new JTextField();
        usernameEmployeeTextField.setBounds(175,50,150,22);

        frame.setBounds(500, 500, 380, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);

        buttonActionListeners();

    }

    public void addItemsToFrame(){
        frame.getContentPane().add(lblUsername);
        frame.getContentPane().add(btnBack);
        frame.getContentPane().add(btnNext);
        frame.getContentPane().add(usernameEmployeeTextField);

    }

    private void getDataFromTextField(){
        String username = usernameEmployeeTextField.getText();
        Employee employee = new Employee();
        employee = EmployeeOrganizer.findEmployee(username);
        if (employee == null){
            JOptionPane.showMessageDialog(frame, "Employee not found");
        }else{
            new NewEmployeeInformation();
            frame.setVisible(false);
        }
    }

    public static Employee getEmployeeToUpdate(){

        String usernameEmployee = usernameEmployeeTextField.getText();
        Employee employee = new Employee();
        EmployeeOrganizer.findEmployee(usernameEmployee);
        if (employee == null){
            return null;
        }else{
            return employee;
        }

    }

    private void buttonActionListeners() {
        btnBack.addActionListener(e -> {
            new AdministratorView();
            frame.setVisible(false);
        });

        btnNext.addActionListener(e -> {
            getDataFromTextField();
        });


    }

}
