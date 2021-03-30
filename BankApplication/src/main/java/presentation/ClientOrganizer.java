package presentation;
import bll.ClientBLL;
import bll.EmployeeBLL;
import model.Client;
import model.Employee;
import start.ApplicationStart;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import validator.ClientValidator;

public class ClientOrganizer {

    protected static final Logger LOGGER = Logger.getLogger(ApplicationStart.class.getName());
    private  List<Client> c1 = new ArrayList<Client>();

    public static void insertClient2(Client client){
        ClientBLL clientBLL = new ClientBLL();
        ClientValidator.validateInsertNewClient(client);
        try {
            clientBLL.insert(client.getIdClient(),client.getName(),client.getIdentityCard(),client.getPersonalNumericalCode(),client.getAddress());
        } catch (Exception ex) {
            LOGGER.log(Level.INFO, ex.getMessage());
        }

    }

    public static Client findClient(String name){

        ClientBLL clientBLL = new ClientBLL();
        try {
            Client client = clientBLL.findByName(name);
            if (client.getName() != "")
                return client;
        } catch (Exception ex) {
            LOGGER.log(Level.INFO, ex.getMessage());
        }
        return null;
    }

    public static Client updateClient(String name, String identityCard, String cnp, String address){
        ClientBLL clientBLL = new ClientBLL();
        ClientValidator.validateUpdateNewClient(name, identityCard, cnp, address);
        try {
            Client client = clientBLL.update(name, identityCard, cnp, address);
            return client;
        } catch (Exception ex) {
            LOGGER.log(Level.INFO, ex.getMessage());
        }
        return null;
    }

    public static List<Client> selectAllClients(){

        ClientBLL clientBLL = new ClientBLL();
        try{
            List<Client> clients = clientBLL.selectAll();
            return clients;
        }catch (Exception ex){
            LOGGER.log(Level.INFO, ex.getMessage());
        }
        return null;
    }



}
