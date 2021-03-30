package validator;

import model.Client;
import model.Account;
public class AccountValidator {

    public static void validateInsertNewAccount(Account account){
        if (account.getIdentificationNumber().length() !=4){
            throw new IllegalArgumentException("Account identification number must have exactly 4 characters!");
        }
        if(account.getType()==null){
            throw new IllegalArgumentException("Type  can't be null");
        }
        if(account.getAmountOfMoney()<0){
            throw new IllegalArgumentException("Amount of money can't be a negative number");
        }
        if(account.getDateOfCreation()==null){
            throw new IllegalArgumentException("date can't be null");
        }
        if(account.getOwner()==null){
            throw new IllegalArgumentException(" Owner can't be null");
        }
        if(account.getOwner().length()<6){
            throw new IllegalArgumentException("Name of the owner must be at least 6 characters long");
        }

    }

    public static void validateUpdateNewAccount(String identificationNumber, String type, Float amountOfMoney, String dateOfCreation){
        if (identificationNumber.length() !=4){
            throw new IllegalArgumentException("Account identification number must have exactly 4 characters");
        }
        if(type==null){
            throw new IllegalArgumentException("Type  can't be null");
        }
        if(amountOfMoney<0){
            throw new IllegalArgumentException("Amount of money can't be a negative number");
        }
        if(dateOfCreation==null){
            throw new IllegalArgumentException("date can't be null");
        }

    }

}
