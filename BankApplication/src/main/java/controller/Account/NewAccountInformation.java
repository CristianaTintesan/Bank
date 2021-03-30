package controller.Account;

import controller.Login.EmployeeView;
import model.Account;
import presentation.AccountOrganizer;

import javax.swing.*;
import java.awt.*;

public class NewAccountInformation {
    private JFrame frame;
    private JTextField identificationNumberTextField;
    private JTextField typeTextField;
    private JTextField amountOfMoneyTextField;
    private JTextField dateOfCreationTextField;

    private JButton btnUpdate = new JButton("Update");
    private JButton btnBack = new JButton("Back");

    private JLabel lblIdentificationNumber;
    private JLabel lblType;
    private JLabel lblAmountOfMoney;
    private JLabel lblDateOfCreation;

    private final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

  public NewAccountInformation(){
      frame = new JFrame("Update Account");
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


        btnUpdate.setBounds(200, 196, 100, 30);
        btnBack.setBounds(30, 196, 100, 30);

        identificationNumberTextField = new JTextField();
        identificationNumberTextField.setBounds(175,50,150,22);

        typeTextField = new JTextField();
        typeTextField.setBounds(175,83,150,22);

        amountOfMoneyTextField = new JTextField();
        amountOfMoneyTextField.setBounds(175,110,150,22);

        dateOfCreationTextField = new JTextField();
        dateOfCreationTextField.setBounds(175,141,150,22);

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
        frame.getContentPane().add(btnBack);
        frame.getContentPane().add(btnUpdate);
        frame.getContentPane().add(identificationNumberTextField);
        frame.getContentPane().add(typeTextField);
        frame.getContentPane().add(amountOfMoneyTextField);
        frame.getContentPane().add(dateOfCreationTextField);


    }

    private void getDataFromTextFields(){
        Account account = UpdateAccountInformation.getAccountToUpdate();
        String identificationNumber = identificationNumberTextField.getText();
        String type = typeTextField.getText();
        String amountOfMoney = amountOfMoneyTextField.getText();
        String dateOfCreation = dateOfCreationTextField.getText();

        account.setIdentificationNumber(identificationNumber);
        account.setDateOfCreation(dateOfCreation);
        account.setType(type);
        account.setAmountOfMoney(Float.parseFloat(amountOfMoney));


        AccountOrganizer.updateAccount(identificationNumber, type, Float.parseFloat(amountOfMoney), dateOfCreation);




    }

    private void buttonActionListeners() {
        btnBack.addActionListener(e -> {
            new EmployeeView();
            frame.setVisible(false);
        });

        btnUpdate.addActionListener(e -> {
            getDataFromTextFields();
            JOptionPane.showMessageDialog(frame, "Update done");
            new EmployeeView();
            frame.setVisible(false);
        });
    }


}
