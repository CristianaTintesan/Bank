package controller.Client;

import controller.Login.EmployeeView;

import javax.swing.*;
import java.awt.*;

public class ClientsTableView {

    JFrame frame;
    public JTable clientsTable ;
    JButton btnBack;
    private final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    public ClientsTableView(){

        frame = new JFrame("View Clients Informations");
        clientsTable = new JTable();
        initialize();
        addItemsToPane();
        frame.setVisible(true);

    }

    public void initialize(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        clientsTable.setBounds(30, 40, 700, 230);

        frame.setSize(800,450);

        btnBack = new JButton("Back");
        btnBack.setBounds(30, 300, 75, 43);

        btnActionListeners();

    }

    public void addItemsToPane(){

        frame.getContentPane().add(clientsTable);
        frame.getContentPane().add(btnBack);
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
    }

    private void btnActionListeners(){
        btnBack.addActionListener(e -> {
            new EmployeeView();
            frame.setVisible(false);
        });


    }
}
