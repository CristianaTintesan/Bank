package controller.Account;

import controller.Client.NewClientView;
import controller.Login.EmployeeView;
import model.Account;
import model.Client;
import presentation.AccountOrganizer;
import presentation.ClientOrganizer;
import utils.ApplicationUtils;

import javax.swing.*;
import java.awt.*;

public class NewAccountView {

    private JFrame frame;
    private JTextField identificationNumberTextField;
    private JTextField typeTextField;
    private JTextField amountOfMoneyTextField;
    private JTextField dateOfCreationTextField;
    private JTextField ownerTextField;
    private JButton btnAddAccount = new JButton("Add Account");
    private JButton btnAddClient = new JButton("Add Client");
    private JButton btnBack = new JButton("Back");
    private JLabel lblIdentificationNumber;
    private JLabel lblType;
    private JLabel lblAmountOfMoney;
    private JLabel lblDateOfCreation;
    private JLabel lblOwner;
    private final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    public NewAccountView(){

        frame = new JFrame("Add Account");
        frame.setVisible(true);
        initialize();
        addItemsToFrame();

    }

    public void initialize(){

        lblIdentificationNumber = new JLabel("Identification Number");
        lblIdentificationNumber.setFont(new Font("Franklin Gothic Demi",  Font.ITALIC, 16));
        lblIdentificationNumber.setBounds(10,50,155,22);

        lblType = new JLabel("Type");
        lblType.setFont(new Font("Franklin Gothic Demi",  Font.ITALIC, 16));
        lblType.setBounds(10, 80, 150, 22);

        lblAmountOfMoney = new JLabel("Amount Of Money");
        lblAmountOfMoney.setFont(new Font("Franklin Gothic Demi",  Font.ITALIC, 16));
        lblAmountOfMoney.setBounds(10,110,150,22);

        lblDateOfCreation = new JLabel("Date of Creation");
        lblDateOfCreation.setFont(new Font("Franklin Gothic Demi",  Font.ITALIC, 16));
        lblDateOfCreation.setBounds(10,140,150,22);

        lblOwner = new JLabel("Owner Name");
        lblOwner.setFont(new Font("Franklin Gothic Demi",  Font.ITALIC, 16));
        lblOwner.setBounds(10,170,150,22);


        btnBack.setBounds(10, 225, 100, 30);
        btnAddAccount.setBounds(120,225,115,30);
        btnAddClient.setBounds(240, 225, 100, 30);

        identificationNumberTextField = new JTextField();
        identificationNumberTextField.setBounds(175,50,150,22);

        typeTextField = new JTextField();
        typeTextField.setBounds(175,83,150,22);

        amountOfMoneyTextField = new JTextField();
        amountOfMoneyTextField.setBounds(175,110,150,22);

        dateOfCreationTextField = new JTextField();
        dateOfCreationTextField.setBounds(175,141,150,22);

        ownerTextField = new JTextField();
        ownerTextField.setBounds(175,170,150,22);



        frame.setBounds(500, 500, 380, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);

        buttonActionListeners();


    }

    public void addItemsToFrame(){

        frame.getContentPane().add(lblIdentificationNumber);
        frame.getContentPane().add(lblType);
        frame.getContentPane().add(lblAmountOfMoney);
        frame.getContentPane().add(lblDateOfCreation);
        frame.getContentPane().add(lblOwner);
        frame.getContentPane().add(btnBack);
        frame.getContentPane().add(btnAddAccount);
        frame.getContentPane().add(btnAddClient);
        frame.getContentPane().add(identificationNumberTextField);
        frame.getContentPane().add(typeTextField);
        frame.getContentPane().add(amountOfMoneyTextField);
        frame.getContentPane().add(dateOfCreationTextField);
        frame.getContentPane().add(ownerTextField);

    }

    private void getDataFromTextFields(){
        Account account = new Account();
        Client client = new Client();
        String identificationNumber = identificationNumberTextField.getText();
        String type = typeTextField.getText();
        String amountOfMoney = amountOfMoneyTextField.getText();
        String date = dateOfCreationTextField.getText();
        String owner = ownerTextField.getText();

        account.setIdAccount(ApplicationUtils.generateNewUUID());
        account.setIdentificationNumber(identificationNumber);
        account.setType(type);
        account.setAmountOfMoney(Float.parseFloat(amountOfMoney));
        account.setDateOfCreation(date);
        account.setOwner(owner);
        if (ClientOrganizer.findClient(owner)==null){
            JOptionPane.showMessageDialog(frame, "This client doesn't exist.\n Can't create a new account for a client which " +
                    "doesn't exist in our database");
        } else{
            AccountOrganizer.insertAccount(account);
        }

    }

    private  void buttonActionListeners(){

        btnBack.addActionListener(e -> {
            new EmployeeView();
            frame.setVisible(false);
        });

        btnAddClient.addActionListener(e -> {
            new NewClientView();
            frame.setVisible(false);
        });

        btnAddAccount.addActionListener(e -> {
            getDataFromTextFields();
        });


    }



}
