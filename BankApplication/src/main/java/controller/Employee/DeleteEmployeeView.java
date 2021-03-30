package controller.Employee;

import controller.Login.AdministratorView;
import model.Employee;
import presentation.EmployeeOrganizer;

import javax.swing.*;
import java.awt.*;

public class DeleteEmployeeView {

    private JFrame frame;
    private JTextField usernameEmployeeTextField;
    private JButton btnDeleteEmployee = new JButton("Delete Employee");
    private JButton btnBack = new JButton("Back");
    private JLabel lblUsername;
    private final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    public DeleteEmployeeView(){

        frame = new JFrame("Delete Employee");
        frame.setVisible(true);
        initialize();
        addItemsToFrame();

    }

    public void initialize(){

        lblUsername = new JLabel("Employee Username");
        lblUsername.setFont(new Font("Franklin Gothic Demi",  Font.ITALIC, 16));
        lblUsername.setBounds(10,50,150,22);

        btnDeleteEmployee.setBounds(200, 196, 150, 30);
        btnBack.setBounds(30, 196, 100, 30);

        usernameEmployeeTextField = new JTextField();
        usernameEmployeeTextField.setBounds(175,50,150,22);

        frame.setBounds(500, 500, 380, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);

        buttonActionListeners();

    }

    public void addItemsToFrame(){

        frame.getContentPane().add(lblUsername);
        frame.getContentPane().add(usernameEmployeeTextField);
        frame.getContentPane().add(btnBack);
        frame.getContentPane().add(btnDeleteEmployee);

    }

    private void getDataFromTextField(){

        String username = usernameEmployeeTextField.getText();
        EmployeeOrganizer employeeOrganizer = new EmployeeOrganizer();
        Employee employee = new Employee();
        employee = employeeOrganizer.findEmployeeByName(username);

        if(employee ==null){
            JOptionPane.showMessageDialog(frame, "This employee doesn't exist in our database!");
        }
        else{
            EmployeeOrganizer.deleteEmployee(username);
            JOptionPane.showMessageDialog(frame, "Employee deleted");

        }

    }

    private void buttonActionListeners(){

        btnBack.addActionListener(e -> {
            new AdministratorView();
            frame.setVisible(false);
        });

        btnDeleteEmployee.addActionListener(e -> {
            getDataFromTextField();
        });

    }

}
