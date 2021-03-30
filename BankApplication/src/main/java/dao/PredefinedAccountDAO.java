package dao;

import model.Account;
import model.PredefinedAccount;

import java.util.ArrayList;

public class PredefinedAccountDAO extends AbstractDAO<PredefinedAccount> {

    public PredefinedAccount findPredefinedAccountByName(String name){
        return super.findPredefinedAccountByName(name);
    }

    public PredefinedAccount update (  String identificationNumber, String name, Float amountOfMoney) {
        ArrayList<Object> list = new ArrayList<Object>();
        list.add(identificationNumber);
        list.add(name);
        list.add(amountOfMoney);
        ArrayList<String> names = new ArrayList<String>();
        names.add("identificationNumber");
        names.add("name");
        names.add("amountOfMoney");
        return super.update(list, names, identificationNumber, "identificationNumber");
    }
}
