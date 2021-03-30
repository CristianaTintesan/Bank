package controller.Login;
import controller.Employee.DeleteEmployeeView;
import controller.Employee.EmployeesTableView;
import controller.Employee.NewEmployeeView;
import controller.Employee.UpdateEmployeeInformation;
import model.Employee;
import presentation.EmployeeOrganizer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class AdministratorView {

    private JFrame frame;
    private JButton btnCreateEmployeeInf = new JButton("Add a new Employee");
    private JButton btnUpdateEmployeeInf = new JButton("Update the informartions about employees");
    private JButton btnDeleteEmployee = new JButton("Delete the information about one employee");
    private JButton btnReadEmployeeInf = new JButton("Read the informations about employees");
    private JButton btnGenerateRaports = new JButton("Generate Raports");
    private JButton btnBack = new JButton("Back");
    private final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    public AdministratorView(){

        frame = new JFrame("Select Operation");
        frame.setVisible(true);
        initialize();
        addItemsToFrame();
    }

    public void initialize(){

        btnCreateEmployeeInf.setBounds(70, 30, 300, 45);
        btnUpdateEmployeeInf.setBounds(70, 90, 300, 45);
        btnDeleteEmployee.setBounds(70, 150, 300, 45);
        btnReadEmployeeInf.setBounds(70, 210, 300, 45);
        btnGenerateRaports.setBounds(70, 270, 300, 45);

        btnBack.setBounds(70, 350, 100, 45);

        frame.setBounds(500, 500, 450, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);

        buttonActionListeners();

    }

    private void viewEmployeesInformation(){

        EmployeesTableView employeesTableView = new EmployeesTableView();
        List<Employee> list = EmployeeOrganizer.selectAllEmployees();
        DefaultTableModel employeesTable = new DefaultTableModel();

        Object titleColumn1 = "Id";
        Object titleColumn2 = "Name";
        Object titleColumn3 = "Username";
        Object titleColumn4 = "Password";
        employeesTable.addColumn("idEmployee");
        employeesTable.insertRow(0,new Object[] { "Client id"});
        employeesTable.addColumn("nameEmployee");
        employeesTable.addColumn("Username");
        employeesTable.addColumn("Password");


        for (Employee e : list){
            employeesTable.insertRow(1, new Object[] {e.getIdEmployee(),e.getNameEmployee(),e.getUsername(),e.getPassword()});
        }

        employeesTable.setValueAt(titleColumn1, 0, 0);
        employeesTable.setValueAt(titleColumn2, 0, 1);
        employeesTable.setValueAt(titleColumn3, 0, 2);
        employeesTable.setValueAt(titleColumn4, 0, 3);

        employeesTableView.employeesTable.setModel(employeesTable);
        employeesTable.fireTableDataChanged();
        frame.setVisible(false);

    }


    public void addItemsToFrame(){

        frame.getContentPane().add(btnCreateEmployeeInf);
        frame.getContentPane().add(btnUpdateEmployeeInf);
        frame.getContentPane().add(btnDeleteEmployee);
        frame.getContentPane().add(btnReadEmployeeInf);
        frame.getContentPane().add(btnGenerateRaports);
        frame.getContentPane().add(btnBack);

    }

    private void buttonActionListeners() {

        btnBack.addActionListener(e -> {
            new ApplicationView();
            frame.setVisible(false);
        });

        btnReadEmployeeInf.addActionListener(e -> {
            viewEmployeesInformation();
            frame.setVisible(false);
        });

        btnCreateEmployeeInf.addActionListener(e -> {
            new NewEmployeeView();
            frame.setVisible(false);
        });

        btnDeleteEmployee.addActionListener(e -> {
            new DeleteEmployeeView();
            frame.setVisible(false);
        });

        btnUpdateEmployeeInf.addActionListener(e -> {
            new UpdateEmployeeInformation();
            frame.setVisible(false);
        });
    }

}
