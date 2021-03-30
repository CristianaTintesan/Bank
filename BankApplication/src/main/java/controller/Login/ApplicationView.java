package controller.Login;

import javax.swing.*;
import java.awt.*;

public class ApplicationView {

    public JFrame frame;
    public JButton btnAdmin = new JButton("Administator");
    public JButton btnEmployee = new JButton("Employee");
    //private ImageIcon loginIcon;
    //public JLabel myLabel;
    public ImageIcon bankIcon;
    private final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    public ApplicationView(){
        bankIcon = new ImageIcon("src/main/java/controller/carwash.jpg");
       // myLabel = new JLabel(bankIcon);
        frame = new JFrame("What kind of user are you?");
        frame.setVisible(true);
        initialize();
    }

    public void initialize(){

        btnEmployee.setBounds(135, 70, 130, 70);
        btnAdmin.setBounds(135, 160, 130, 70);

        frame.setBounds(500, 500, 430, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        //loginIcon = new ImageIcon("src/main/java/controller/img1.jpg");
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);

        addItemsToFrame();
        buttonActionListeners();

    }


    public void addItemsToFrame(){
        //frame.getContentPane().add(myLabel);
        frame.getContentPane().add(btnAdmin);
        frame.getContentPane().add(btnEmployee);

    }

    private void buttonActionListeners() {
        btnAdmin.addActionListener(e -> {
            new AdministratorLogInView();
            frame.setVisible(false);
        });

        btnEmployee.addActionListener(e -> {
            new EmployeeLogInView();
            frame.setVisible(false);
        });

    }

}
