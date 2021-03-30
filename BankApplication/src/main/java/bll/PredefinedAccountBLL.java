package bll;

import dao.AccountDAO;
import dao.PredefinedAccountDAO;
import model.Account;
import model.PredefinedAccount;

import java.util.NoSuchElementException;

public class PredefinedAccountBLL {

    private static PredefinedAccountDAO predefinedAccountDAO;

    public PredefinedAccountBLL() {
        predefinedAccountDAO = new PredefinedAccountDAO();
    }

    public PredefinedAccount findPredefinedAccountByName(String name){
        PredefinedAccount predefinedAccount=predefinedAccountDAO.findPredefinedAccountByName(name);

        if (predefinedAccount == null){
            throw new NoSuchElementException("The predefined account with name : " + name + " was not found!");
        }
        return predefinedAccount;
    }

    public PredefinedAccount update(String identificationNumber, String name, Float amountOfMoney) {
        PredefinedAccount predefinedAccount= predefinedAccountDAO.update(identificationNumber,name, amountOfMoney);

        if (predefinedAccount == null) {
            throw new NoSuchElementException("The prededfined account with identification number =" + identificationNumber + " was not updated!");
        }
        return predefinedAccount;
    }

}
