package bll;

import dao.AbstractDAO;
import dao.AccountDAO;
import dao.ClientDAO;
import model.Account;
import model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class AccountBLL {

    private static AccountDAO accountDAO;

    public AccountBLL() {
        accountDAO = new AccountDAO();
    }

    public Account insert(String idAccount, String identificationNumber, String type, Float amountOfMoney, String dateOfCreation, String owner)
    {
        Account account = accountDAO.insert(idAccount,identificationNumber,type,amountOfMoney,dateOfCreation,owner);
        if (account == null) {
            throw new NoSuchElementException("The account with id " + idAccount + " was not inserted!");
        }
        return account;
    }

    public Account delete(String name) {
        Account account= accountDAO.delete(name);
        if (account == null) {
            throw new NoSuchElementException("The account  was not deleted!");
        }
        return account;
    }

    public Account findAccountByName(String name){
        Account account=accountDAO.findAccountByName(name);

        if (account == null){
            throw new NoSuchElementException("The account with name of the owner: " + name + " was not found!");
        }
        return account;
    }

    public Account findAccountByIdentificationNumber(String identificationNumber){
        Account account=accountDAO.findAccountByIdentificationNumber(identificationNumber);

        if (account == null){
            throw new NoSuchElementException("The account with the identification number: " + identificationNumber + " was not found!");
        }
        return account;
    }

    public Account update(String identificationNumber, String type, Float amountOfMoney, String dateOfCreation) {
        Account account= accountDAO.update(identificationNumber,type,amountOfMoney,dateOfCreation);

        if (account == null) {
            throw new NoSuchElementException("The account with identification number =" + identificationNumber + " was not updated!");
        }
        return account;
    }

    public Account update2( Float amountOfMoney) {
        Account account= accountDAO.update2(amountOfMoney);

        if (account == null) {
            throw new NoSuchElementException("The account with identification number =" + amountOfMoney + " was not updated!");
        }
        return account;
    }

    public static List<Account> selectAllAccounts() {
        List<Account> accounts = new ArrayList<Account>();
        accounts = accountDAO.selectAllAccounts();
        if (accounts == null) {
            throw new NoSuchElementException("Elements were not found!");
        }
        return accounts;
    }
}
