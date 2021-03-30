package controller.Client;

import javax.swing.*;
import java.awt.*;

import controller.Login.EmployeeView;
import presentation.ClientOrganizer;
import model.Client;

public class UpdateClientInformation {

    private JFrame frame;
    private static JTextField nameClientTextField;
    private JButton btnNext = new JButton("Next");
    private JButton btnBack = new JButton("Back");
    private JLabel lblName;
    private final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    public UpdateClientInformation(){

        frame = new JFrame("Find client by name");
        frame.setVisible(true);
        initialize();
        addItemsToFrame();
    }

    public void initialize(){

        lblName = new JLabel("Client Name");
        lblName.setFont(new Font("Franklin Gothic Demi",  Font.ITALIC, 16));
        lblName.setBounds(10,50,150,22);

        btnNext.setBounds(200, 196, 100, 30);
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
        frame.getContentPane().add(btnBack);
        frame.getContentPane().add(btnNext);
        frame.getContentPane().add(nameClientTextField);

    }

    private void getDataFromTextField(){
        String nameClient = nameClientTextField.getText();
        Client client = new Client();
        client = ClientOrganizer.findClient(nameClient);
        if (client == null){
            JOptionPane.showMessageDialog(frame, "Client not found");
        }else{
            new NewClientInformation();
            frame.setVisible(false);
        }
    }

    public static Client getClientToUpdate(){

        String nameClient = nameClientTextField.getText();
        Client client = new Client();
        ClientOrganizer.findClient(nameClient);
        if (client == null){
            return null;
        }else{
            return client;
        }

    }

    private void buttonActionListeners() {
        btnBack.addActionListener(e -> {
            new EmployeeView();
            frame.setVisible(false);
        });

        btnNext.addActionListener(e -> {
            getDataFromTextField();
        });


    }

}
