package controller.Login;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

import controller.Account.AccountsTableView;
import controller.Account.DeleteAccountView;
import controller.Account.NewAccountView;
import controller.Account.UpdateAccountInformation;
import controller.Client.ClientsTableView;
import controller.Client.NewClientView;
import controller.Client.UpdateClientInformation;
import controller.Employee.ProcessBillsView;
import controller.Employee.TransferMoneyView;
import model.Client;
import model.Account;
import presentation.AccountOrganizer;
import presentation.ClientOrganizer;

public class EmployeeView {

    private JFrame frame;
    private JButton btnViewClientInf = new JButton("View Client Information");
    private JButton btnAddClient = new JButton("Add New Client");
    private JButton btnUpdateClientInf = new JButton("Update Client Information");
    private JButton btnCreateClientAccount = new JButton("Create New Client Account");
    private JButton btnDeleteClientAccount = new JButton("Delete Client Account");
    private JButton btnUpdateClientAccount = new JButton("Update Client Account");
    private JButton btnViewClientAccount = new JButton("View Client Account");
    private JButton btnTransferMoney = new JButton("Transfer Money Between Accounts");
    private JButton btnProcessUtilitiesBills = new JButton("Process Utilities Bills");

    private JButton btnBack = new JButton("Back");

    private final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();


    public EmployeeView(){
        frame = new JFrame("Select Operation");
        frame.setVisible(true);
        initialize();
        addItemsToFrame();
    }

    public void initialize(){

        btnAddClient.setBounds(90, 20, 250, 40);
        btnUpdateClientInf.setBounds(90, 70, 250, 40);
        btnViewClientInf.setBounds(90, 120, 250, 40);
        btnCreateClientAccount.setBounds(90, 170, 250, 40);
        btnUpdateClientAccount.setBounds(90, 220, 250, 40);
        btnDeleteClientAccount.setBounds(90, 270, 250, 40);
        btnViewClientAccount.setBounds(90, 320, 250, 40);
        btnTransferMoney.setBounds(90, 370, 250, 40);
        btnProcessUtilitiesBills.setBounds(90, 420, 250, 40);
        btnBack.setBounds(90, 470, 100, 40);

        frame.setBounds(500, 500, 450, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);

        buttonActionListeners();

    }

    public void addItemsToFrame(){
        frame.getContentPane().add(btnAddClient);
        frame.getContentPane().add(btnUpdateClientInf);
        frame.getContentPane().add(btnViewClientInf);
        frame.getContentPane().add(btnCreateClientAccount);
        frame.getContentPane().add(btnUpdateClientAccount);
        frame.getContentPane().add(btnDeleteClientAccount);
        frame.getContentPane().add(btnViewClientAccount);
        frame.getContentPane().add(btnTransferMoney);
        frame.getContentPane().add(btnProcessUtilitiesBills);
        frame.getContentPane().add(btnBack);

    }

    private void viewClientsInformation(){

        ClientsTableView clientsTableView= new ClientsTableView();
        List<Client> list = ClientOrganizer.selectAllClients();
        DefaultTableModel clientsTable = new DefaultTableModel();

        Object titleColumn1 = "Id";
        Object titleColumn2 = "Name";
        Object titleColumn3 = "Identity Card";
        Object titleColumn4 = "CNP";
        Object titleColumn5 = "Address";
        clientsTable.addColumn("idClient");
        clientsTable.insertRow(0,new Object[] { "Client id"});
        clientsTable.addColumn("name");
        clientsTable.addColumn("identityCard");
        clientsTable.addColumn("personalNumericalCode");
        clientsTable.addColumn("address");

        for (Client c : list){
            clientsTable.insertRow(1, new Object[] {c.getIdClient(), c.getName(), c.getIdentityCard(),c.getPersonalNumericalCode(),c.getAddress()});
        }

        clientsTable.setValueAt(titleColumn1, 0, 0);
        clientsTable.setValueAt(titleColumn2, 0, 1);
        clientsTable.setValueAt(titleColumn3, 0, 2);
        clientsTable.setValueAt(titleColumn4, 0, 3);
        clientsTable.setValueAt(titleColumn5, 0, 4);

        clientsTableView.clientsTable.setModel(clientsTable);
        clientsTable.fireTableDataChanged();
        frame.setVisible(false);

    }

    private void viewAccountsInformation(){

        AccountsTableView accountsTableView= new AccountsTableView();
        List<Account> list = AccountOrganizer.selectAllAccounts();
        DefaultTableModel accountsTable = new DefaultTableModel();

        Object titleColumn1 = "Id Account";
        Object titleColumn2 = "Identification Nr";
        Object titleColumn3 = "Type";
        Object titleColumn4 = "Amount Of Money";
        Object titleColumn5 = "Date";
        Object titleColumn6 = "Owner";

        accountsTable.addColumn("idAccount");
        accountsTable.insertRow(0,new Object[] { "Client id"});
        accountsTable.addColumn("identificationNumber");
        accountsTable.addColumn("type");
        accountsTable.addColumn("amountOfMoney");
        accountsTable.addColumn("dateOfCreation");
        accountsTable.addColumn("owner");

        for (Account a : list){
            accountsTable.insertRow(1, new Object[] {a.getIdAccount(),a.getIdentificationNumber(),a.getType(),a.getAmountOfMoney().toString(),a.getDateOfCreation().toString(),a.getOwner()});
        }

        accountsTable.setValueAt(titleColumn1, 0, 0);
        accountsTable.setValueAt(titleColumn2, 0, 1);
        accountsTable.setValueAt(titleColumn3, 0, 2);
        accountsTable.setValueAt(titleColumn4, 0, 3);
        accountsTable.setValueAt(titleColumn5, 0, 4);
        accountsTable.setValueAt(titleColumn6, 0, 5);


        accountsTableView.accountsTable.setModel(accountsTable);
        accountsTable.fireTableDataChanged();
        frame.setVisible(false);

    }

    private void buttonActionListeners() {
        btnAddClient.addActionListener(e -> {
            new NewClientView();
            frame.setVisible(false);
        });

        btnUpdateClientInf.addActionListener(e -> {
            new UpdateClientInformation();
            frame.setVisible(false);
        });

        btnViewClientInf.addActionListener(e -> {
            viewClientsInformation();
            frame.setVisible(false);
        });

        btnViewClientAccount.addActionListener(e -> {
            viewAccountsInformation();
            frame.setVisible(false);
        });

        btnCreateClientAccount.addActionListener(e -> {
            new NewAccountView();
            frame.setVisible(false);
        });

        btnDeleteClientAccount.addActionListener(e -> {
           new DeleteAccountView();
        });

        btnUpdateClientAccount.addActionListener(e -> {
            new UpdateAccountInformation();
            frame.setVisible(false);
        });

        btnTransferMoney.addActionListener(e -> {
            new TransferMoneyView();
            frame.setVisible(false);
        });

        btnProcessUtilitiesBills.addActionListener(e -> {
            new ProcessBillsView();
            frame.setVisible(false);
        });






    }


}
