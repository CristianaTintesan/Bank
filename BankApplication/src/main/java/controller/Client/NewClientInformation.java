package controller.Client;

import controller.Login.EmployeeView;
import model.Client;
import presentation.ClientOrganizer;

import javax.swing.*;
import java.awt.*;

public class NewClientInformation {

    private JFrame frame;
    private JTextField nameUpdateTextField;
    private JTextField identityCardTextField;
    private JTextField cnpTextField;
    private JTextField addressTextField;
    private JButton btnUpdate = new JButton("Update");
    private JButton btnBack = new JButton("Back");
    private JLabel lblName;
    private JLabel lblIdentityCard;
    private JLabel lblCnp;
    private JLabel lblAddress;
    private final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    public NewClientInformation(){

        frame = new JFrame("Update client information");
        frame.setVisible(true);
        initialize();
        addItemsToFrame();
    }

    public void initialize(){

        lblName = new JLabel("Client Name");
        lblName.setFont(new Font("Franklin Gothic Demi",  Font.ITALIC, 16));
        lblName.setBounds(10,50,150,22);

        lblIdentityCard = new JLabel("Identity Card Number");
        lblIdentityCard.setFont(new Font("Franklin Gothic Demi",  Font.ITALIC, 16));
        lblIdentityCard.setBounds(10, 80, 150, 22);

        lblCnp = new JLabel("Client CNP");
        lblCnp.setFont(new Font("Franklin Gothic Demi",  Font.ITALIC, 16));
        lblCnp.setBounds(10,110,150,22);

        lblAddress = new JLabel("Client Address");
        lblAddress.setFont(new Font("Franklin Gothic Demi",  Font.ITALIC, 16));
        lblAddress.setBounds(10,140,150,22);

        btnUpdate.setBounds(200, 196, 100, 30);
        btnBack.setBounds(30, 196, 100, 30);


        nameUpdateTextField = new JTextField();
        nameUpdateTextField.setBounds(175,50,150,22);

        identityCardTextField = new JTextField();
        identityCardTextField.setBounds(175,83,150,22);

        cnpTextField = new JTextField();
        cnpTextField.setBounds(175,110,150,22);

        addressTextField = new JTextField();
        addressTextField.setBounds(175,141,150,22);

        frame.setBounds(500, 500, 380, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);

        buttonActionListeners();

    }

    public void addItemsToFrame(){

        frame.getContentPane().add(lblName);
        frame.getContentPane().add(lblIdentityCard);
        frame.getContentPane().add(lblCnp);
        frame.getContentPane().add(lblAddress);
        frame.getContentPane().add(btnUpdate);
        frame.getContentPane().add(btnBack);
        frame.getContentPane().add(nameUpdateTextField);
        frame.getContentPane().add(identityCardTextField);
        frame.getContentPane().add(cnpTextField);
        frame.getContentPane().add(addressTextField);
    }

    private void getDataFromTextFields(){
        Client client = UpdateClientInformation.getClientToUpdate();
        String name = nameUpdateTextField.getText();
        String identitycard = identityCardTextField.getText();
        String cnp = cnpTextField.getText();
        String address = addressTextField.getText();

        client.setName(name);
        client.setIdentityCard(identitycard);
        client.setPersonalNumericalCode(cnp);
        client.setAddress(address);
        ClientOrganizer.updateClient(name, identitycard, cnp, address);

    }

    private void buttonActionListeners() {
        btnBack.addActionListener(e -> {
            new EmployeeView();
            frame.setVisible(false);
        });

        btnUpdate.addActionListener(e -> {
            getDataFromTextFields();
            new EmployeeView();
            frame.setVisible(false);
        });
    }
}
