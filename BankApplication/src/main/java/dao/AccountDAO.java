package dao;

import model.Account;
import model.Client;

import java.util.ArrayList;
import java.util.List;

public class AccountDAO extends AbstractDAO<Account> {

    public Account insert(String idAccount, String identificationNumber, String type, Float amountOfMoney, String dateOfCreation, String owner) {
        ArrayList<Object> list = new ArrayList<Object>();
        list.add(idAccount);
        list.add(identificationNumber);
        list.add(type);
        list.add(amountOfMoney);
        list.add(dateOfCreation);
        list.add(owner);
        return super.insert(list);
    }

    public Account delete(String nameOwner) {
        ArrayList<Object> list = new ArrayList<Object>();
        ArrayList<String> names = new ArrayList<String>();
        if (nameOwner != "") {
            list.add(nameOwner);
            names.add("owner");
        }
        return super.delete(list, names);
    }

    public Account findAccountByName(String name){

        return super.findAccountByName(name);
    }

    public Account findAccountByIdentificationNumber(String identificationNumber){

        return super.findAccountByIdentificationNumber(identificationNumber);
    }

    public Account update ( String identificationNumber, String type, Float amountOfMoney, String dateOfCreation) {
        ArrayList<Object> list = new ArrayList<Object>();
        list.add(identificationNumber);
        list.add(type);
        list.add(amountOfMoney);
        list.add(dateOfCreation);
        ArrayList<String> names = new ArrayList<String>();
        names.add("identificationNumber");
        names.add("type");
        names.add("amountOfMoney");
        names.add("dateOfCreation");
        return super.update(list, names, identificationNumber, "identificationNumber");
    }

    public Account update2 ( Float amountOfMoney) {
        ArrayList<Object> list = new ArrayList<Object>();
        list.add(amountOfMoney);
        ArrayList<String> names = new ArrayList<String>();
        names.add("amountOfMoney");
        return super.update(list, names, amountOfMoney.toString(), "amountOfMoney");
    }

    public List<Account> selectAllAccounts() {
        return super.selectAllAccounts();
    }
}
