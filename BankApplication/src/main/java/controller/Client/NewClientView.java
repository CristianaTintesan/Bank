package controller.Client;

import javax.swing.*;
import java.awt.*;

import controller.Login.EmployeeView;
import model.Client;
import presentation.ClientOrganizer;
import utils.ApplicationUtils;

public class NewClientView {

    private JFrame frame;
    private JTextField nameClientTextField;
    private JTextField identityCardTextField;
    private JTextField cnpTextField;
    private JTextField addressTextField;
    private JButton btnAddClient = new JButton("Add Client");
    private JButton btnBack = new JButton("Back");
    private JLabel lblName;
    private JLabel lblIdentityCard;
    private JLabel lblCnp;
    private JLabel lblAddress;
    private final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    public NewClientView(){

        frame = new JFrame("Add Client");
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

        btnAddClient.setBounds(200, 196, 100, 30);
        btnBack.setBounds(30, 196, 100, 30);


        nameClientTextField = new JTextField();
        nameClientTextField.setBounds(175,50,150,22);

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
        frame.getContentPane().add(btnAddClient);
        frame.getContentPane().add(btnBack);
        frame.getContentPane().add(nameClientTextField);
        frame.getContentPane().add(identityCardTextField);
        frame.getContentPane().add(cnpTextField);
        frame.getContentPane().add(addressTextField);

    }

    private void getDataFromTextFields(){
        Client client = new Client ();
        String name = nameClientTextField.getText();
        String identitycard = identityCardTextField.getText();
        String cnp = cnpTextField.getText();
        String address = addressTextField.getText();

        client.setIdClient(ApplicationUtils.generateNewUUID());
        client.setName(name);
        client.setAddress(address);
        client.setIdentityCard(identitycard);
        client.setPersonalNumericalCode(cnp);
        ClientOrganizer.insertClient2(client);
    }

    private void buttonActionListeners() {
        btnBack.addActionListener(e -> {
            new EmployeeView();
            frame.setVisible(false);
        });

        btnAddClient.addActionListener(e -> {
            getDataFromTextFields();
            JOptionPane.showMessageDialog(frame, "Client inserted!");
            new EmployeeView();
        });
    }
}
