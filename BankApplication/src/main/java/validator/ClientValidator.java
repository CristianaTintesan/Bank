package validator;
import model.Client;

public class ClientValidator {

    public static void validateInsertNewClient(Client client){
        if (client.getName() == null){
            throw new IllegalArgumentException("Client name can't be null");
        }
        if(client.getIdentityCard().length() != 8){
            throw new IllegalArgumentException("Identity card mush have exactly 8 characters");
        }
        if(client.getPersonalNumericalCode()==null){
            throw new IllegalArgumentException("CNP  can't be null");
        }
        if(client.getPersonalNumericalCode().length() != 13){
            throw new IllegalArgumentException(" CNP mush have exactly 13 characters");
        }
        if(client.getAddress()==null){
            throw new IllegalArgumentException("Address can't be null");
        }
        if(client.getAddress().length()<8){
            throw new IllegalArgumentException("Address must have at least 8 characters long");

        }
    }

    public static void validateUpdateNewClient(String name, String identityCard,  String cnp, String address){
        if (name.length()< 5){
            throw new IllegalArgumentException("Client nama mush have at least 5 characters");
        }
        if(identityCard.length() != 8){
            throw new IllegalArgumentException("Identity card mush have exactly 8 characters!");
        }

        if(cnp.length() != 13){
            throw new IllegalArgumentException("CNP must have exactly 13 characters");
        }
        if(address.length()<8){
            throw new IllegalArgumentException("Address must have at least 8 characters long");

        }
    }
}
