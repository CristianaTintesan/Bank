package presentation;

import bll.AccountBLL;
import bll.PredefinedAccountBLL;
import model.Account;
import model.PredefinedAccount;
import start.ApplicationStart;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PredefinedAccountOrganizer {

    protected static final Logger LOGGER = Logger.getLogger(ApplicationStart.class.getName());
    private List<PredefinedAccount> predefinedAccounts = new ArrayList<PredefinedAccount>();

    public static PredefinedAccount findPredefinedAccount(String name){

        PredefinedAccountBLL predefinedAccountBLL = new PredefinedAccountBLL();
        try {
            PredefinedAccount predefinedAccount = predefinedAccountBLL.findPredefinedAccountByName(name);
            if (predefinedAccount.getName() != "")
                return predefinedAccount;
        } catch (Exception ex) {
            LOGGER.log(Level.INFO, ex.getMessage());
        }
        return null;
    }

    public static PredefinedAccount updatePredefinedAccount( String identificationNumber, String name, Float amountOfMoney){

        PredefinedAccountBLL predefinedAccountBLL = new PredefinedAccountBLL();
        try {
            PredefinedAccount predefinedAccount = predefinedAccountBLL.update(identificationNumber,name,amountOfMoney);
            return predefinedAccount;
        } catch (Exception ex) {
            LOGGER.log(Level.INFO, ex.getMessage());
        }
        return null;
    }

}
