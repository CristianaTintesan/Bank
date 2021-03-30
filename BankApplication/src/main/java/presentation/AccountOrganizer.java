package presentation;
import bll.AccountBLL;
import bll.ClientBLL;
import model.Account;
import model.Client;
import start.ApplicationStart;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import validator.AccountValidator;

public class AccountOrganizer {

    protected static final Logger LOGGER = Logger.getLogger(ApplicationStart.class.getName());
    private  List<Account> accounts = new ArrayList<Account>();

    public static void insertAccount(Account account){
        AccountBLL accountBLL = new AccountBLL();
        AccountValidator.validateInsertNewAccount(account);
        try {
            accountBLL.insert(account.getIdAccount(), account.getIdentificationNumber(), account.getType(), account.getAmountOfMoney(), account.getDateOfCreation(), account.getOwner());
        } catch (Exception ex) {
            LOGGER.log(Level.INFO, ex.getMessage());
        }


    }

    public static void deleteAccount(String nameOwner) {

       AccountBLL accountBLL = new AccountBLL();
        try {
            accountBLL.delete(nameOwner);
        } catch (Exception ex) {
            LOGGER.log(Level.INFO, ex.getMessage());
        }

    }

    public static Account findAccount(String nameOwner){

       AccountBLL accountBLL = new AccountBLL();
        try {
            Account account = accountBLL.findAccountByName(nameOwner);
            if (account.getOwner() != "")
                return account;
        } catch (Exception ex) {
            LOGGER.log(Level.INFO, ex.getMessage());
        }
        return null;
    }

    public static Account findAccountByIdentificationNumber(String identificationNumber){

        AccountBLL accountBLL = new AccountBLL();
        try {
            Account account = accountBLL.findAccountByIdentificationNumber(identificationNumber);
            if (account.getIdentificationNumber() != "")
                return account;
        } catch (Exception ex) {
            LOGGER.log(Level.INFO, ex.getMessage());
        }
        return null;
    }

    public static Account updateAccount( String identificationNumber, String type, Float amountOfMoney, String dateOfCreation){
        AccountBLL accountBLL = new AccountBLL();
        AccountValidator.validateUpdateNewAccount(identificationNumber, type, amountOfMoney, dateOfCreation);
        try {
            Account account = accountBLL.update(identificationNumber,type,amountOfMoney,dateOfCreation);
            return account;
        } catch (Exception ex) {
            LOGGER.log(Level.INFO, ex.getMessage());
        }
        return null;
    }

    public static List<Account> selectAllAccounts(){

        AccountBLL accountBLL = new AccountBLL();
        try{
            List<Account> accounts = accountBLL.selectAllAccounts();
            return accounts;
        }catch (Exception ex){
            LOGGER.log(Level.INFO, ex.getMessage());
        }
        return null;
    }



}
