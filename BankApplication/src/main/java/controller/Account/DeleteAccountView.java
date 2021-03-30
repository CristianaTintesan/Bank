package controller.Account;

import javax.swing.*;
import java.awt.*;

import controller.Login.EmployeeView;
import presentation.AccountOrganizer;
import presentation.ClientOrganizer;

public class DeleteAccountView {

    private JFrame frame;
    private JTextField nameClientTextField;
    private JButton btnDeleteClient = new JButton("Delete Account");
    private JButton btnBack = new JButton("Back");
    private JLabel lblName;
    private final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    public DeleteAccountView(){
        frame = new JFrame("Delete Account");
        frame.setVisible(true);
        initialize();
        addItemsToFrame();
    }

    public void initialize(){

        lblName = new JLabel("Client Name");
        lblName.setFont(new Font("Franklin Gothic Demi",  Font.ITALIC, 16));
        lblName.setBounds(10,50,150,22);

        btnDeleteClient.setBounds(200, 196, 100, 30);
        btnBack.setBounds(30, 196, 100, 30);

        nameClientTextField = new JTextField();
        nameClientTextField.setBounds(175,50,150,22);

        frame.setBounds(500, 500, 380, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);

        buttonActionListeners();

    }

    public void addItemsToFrame(){

        frame.getContentPane().add(lblName);
        frame.getContentPane().add(nameClientTextField);
        frame.getContentPane().add(btnBack);
        frame.getContentPane().add(btnDeleteClient);

    }

    private void getDataFromTextField(){
        String name = nameClientTextField.getText();
        if(ClientOrganizer.findClient(name)==null){
            JOptionPane.showMessageDialog(frame, "This client doesn't exist in our database!");
        }else if(AccountOrganizer.findAccount(name)==null){
            JOptionPane.showMessageDialog(frame, "This client doesn't have an account!");
        }
        else{
            AccountOrganizer.deleteAccount(name);
            JOptionPane.showMessageDialog(frame, "Client deleted");

        }

    }

    private void buttonActionListeners(){

        btnBack.addActionListener(e -> {
            new EmployeeView();
            frame.setVisible(false);
        });

        btnDeleteClient.addActionListener(e -> {
            getDataFromTextField();
        });

    }
}
