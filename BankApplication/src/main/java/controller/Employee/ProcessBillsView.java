package controller.Employee;

import controller.Login.EmployeeView;
import model.Account;
import model.PredefinedAccount;
import presentation.AccountOrganizer;
import presentation.PredefinedAccountOrganizer;

import javax.swing.*;
import java.awt.*;

public class ProcessBillsView {

    private JFrame frame;
    private static JTextField nameCompanyTextField;
    private static JTextField nameClientTextField;
    private static JTextField moneyTextField;
    private JButton btnPay = new JButton("Pay");
    private JButton btnBack = new JButton("Back");
    private JLabel lblName;
    private JLabel lblNameClient;
    private JLabel lblMoney;
    private final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    public ProcessBillsView(){
        frame = new JFrame("Find company by name");
        frame.setVisible(true);
        initialize();
        addItemsToFrame();
    }

    public void initialize(){

        lblName = new JLabel("Company Name");
        lblName.setFont(new Font("Franklin Gothic Demi",  Font.ITALIC, 16));
        lblName.setBounds(10,50,150,22);

        lblNameClient = new JLabel("Client Name");
        lblNameClient.setFont(new Font("Franklin Gothic Demi",  Font.ITALIC, 16));
        lblNameClient.setBounds(10,100,150,22);

        lblMoney = new JLabel("Company Name");
        lblMoney.setFont(new Font("Franklin Gothic Demi",  Font.ITALIC, 16));
        lblMoney.setBounds(10,150,150,22);

        btnPay.setBounds(200, 196, 100, 30);
        btnBack.setBounds(30, 196, 100, 30);

        nameCompanyTextField = new JTextField();
        nameCompanyTextField.setBounds(175,50,150,22);
        nameClientTextField = new JTextField();
        nameClientTextField.setBounds(175,100,150,22);
        moneyTextField = new JTextField();
        moneyTextField.setBounds(175,150,150,22);

        frame.setBounds(500, 500, 380, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);

        buttonActionListeners();

    }

    public void addItemsToFrame(){
        frame.getContentPane().add(lblName);
        frame.getContentPane().add(lblNameClient);
        frame.getContentPane().add(lblMoney);
        frame.getContentPane().add(btnBack);
        frame.getContentPane().add(btnPay);
        frame.getContentPane().add(nameCompanyTextField);
        frame.getContentPane().add(nameClientTextField);
        frame.getContentPane().add(moneyTextField);

    }

    private void getDataFromTextField(){
        String nameCompany = nameCompanyTextField.getText();
        String nameClient = nameClientTextField.getText();
        String money = moneyTextField.getText();
        PredefinedAccount predefinedAccount = new PredefinedAccount();
        Account account = new Account();
        predefinedAccount= PredefinedAccountOrganizer.findPredefinedAccount(nameCompany);
        account = AccountOrganizer.findAccount(nameClient);
        if (predefinedAccount == null){
            JOptionPane.showMessageDialog(frame, "Company not found");
        }else if (account == null){
            JOptionPane.showMessageDialog(frame, "Invalid Client");
        }else{
            Float sum = Float.parseFloat(money);
            Float accountMoney = account.getAmountOfMoney();
            if (account.getType().equals("lei")){
                if ( sum> accountMoney){
                    JOptionPane.showMessageDialog(frame, "Not enough money!!!");
                }else{
                   Float x= account.getAmountOfMoney() - sum;
                   Float y= predefinedAccount.getAmountOfMoney()+sum;
                   AccountOrganizer.updateAccount(account.getIdentificationNumber(), account.getType(), x, account.getDateOfCreation());
                   PredefinedAccountOrganizer.updatePredefinedAccount(predefinedAccount.getIdentificationNumber(), predefinedAccount.getName(), y);
                }
            }else{
                JOptionPane.showMessageDialog(frame, "Type account must be lei");
            }
        }
    }

    public static PredefinedAccount getPredefinedAccount(){

        String nameCompany = nameCompanyTextField.getText();
        PredefinedAccount predefinedAccount = new PredefinedAccount();
        PredefinedAccountOrganizer.findPredefinedAccount(nameCompany);
        if (predefinedAccount == null){
            return null;
        }else{
            return predefinedAccount;
        }

    }

    private void buttonActionListeners() {
        btnBack.addActionListener(e -> {
            new EmployeeView();
            frame.setVisible(false);
        });

        btnPay.addActionListener(e -> {
            getDataFromTextField();
        });


    }

}
