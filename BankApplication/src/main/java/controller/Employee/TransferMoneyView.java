package controller.Employee;

import controller.Login.EmployeeView;
import model.Account;

import javax.swing.*;
import java.awt.*;
import presentation.AccountOrganizer;

public class TransferMoneyView {

    private JFrame frame;
    private  JTextField identificationNumber1TextField;
    private  JTextField identificationNumber2TextField;
    private JTextField amountOfMonetTextField;

    private JButton btnTransfer = new JButton("Transfer");
    private JButton btnBack = new JButton("Back");
    private JLabel lblAccount1;
    private JLabel lblAccount2;
    private JLabel lblamountOfMoney;
    private final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    public TransferMoneyView(){
        frame = new JFrame("Transfer Money");
        frame.setVisible(true);
        initialize();
        addItemsToFrame();
    }

    public void initialize(){

        lblAccount1 = new JLabel("Identification Nr Account1");
        lblAccount1.setFont(new Font("Franklin Gothic Demi",  Font.ITALIC, 16));
        lblAccount1.setBounds(10,50,190,22);

        lblAccount2 = new JLabel("Identification Nr Account2");
        lblAccount2.setFont(new Font("Franklin Gothic Demi",  Font.ITALIC, 16));
        lblAccount2.setBounds(10,100,190,22);

        lblamountOfMoney = new JLabel("Amount of money");
        lblamountOfMoney.setFont(new Font("Franklin Gothic Demi",  Font.ITALIC, 16));
        lblamountOfMoney.setBounds(10,150,190,22);

        btnTransfer.setBounds(200, 196, 100, 30);
        btnBack.setBounds(30, 196, 100, 30);

        identificationNumber1TextField= new JTextField();
        identificationNumber1TextField.setBounds(200,50,150,22);

        identificationNumber2TextField= new JTextField();
        identificationNumber2TextField.setBounds(200,100,150,22);

        amountOfMonetTextField= new JTextField();
        amountOfMonetTextField.setBounds(200,150,150,22);


        frame.setBounds(500, 500, 380, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);

        buttonActionListeners();

    }

    public void addItemsToFrame(){

        frame.getContentPane().add(lblAccount1);
        frame.getContentPane().add(lblAccount2);
        frame.getContentPane().add(lblamountOfMoney);
        frame.getContentPane().add(btnBack);
        frame.getContentPane().add(btnTransfer);
        frame.getContentPane().add(identificationNumber1TextField);
        frame.getContentPane().add(identificationNumber2TextField);
        frame.getContentPane().add(amountOfMonetTextField);

    }

    private void getDataFromTextField(){

        String idNumber1 = identificationNumber1TextField.getText();
        String idNumber2= identificationNumber2TextField.getText();
        String amountOfMoney = amountOfMonetTextField.getText();
        Account account1 = new Account();
        Account account2 = new Account();
        account1 = AccountOrganizer.findAccountByIdentificationNumber(idNumber1);
        account2 = AccountOrganizer.findAccountByIdentificationNumber(idNumber2);

        if (account1==null){
            JOptionPane.showMessageDialog(frame, "Account1 not found");
        }else if ( account2==null){
            JOptionPane.showMessageDialog(frame, "Account2 not found");
        }else{
            Float transferMoney = Float.parseFloat(amountOfMoney);
            Float sum1= account1.getAmountOfMoney();
            Float sum2 = account2.getAmountOfMoney();

            if(account1.getType().equals(account2.getType())) {

                if (transferMoney > sum1) {
                    JOptionPane.showMessageDialog(frame, "Not enough money!!");
                } else {
                    AccountOrganizer.updateAccount(idNumber1, account1.getType(), sum1 - transferMoney, account1.getDateOfCreation());
                    AccountOrganizer.updateAccount(idNumber2, account2.getType(), sum2 + transferMoney, account2.getDateOfCreation());
                }
            }else {
                JOptionPane.showMessageDialog(frame, "Diffrent types!!");
            }
        }

    }


    private void buttonActionListeners() {
        btnBack.addActionListener(e -> {
            new EmployeeView();
            frame.setVisible(false);
        });

        btnTransfer.addActionListener(e -> {
            getDataFromTextField();
        });

    }
}
