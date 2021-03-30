package bll;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import dao.ClientDAO;
import model.Client;
import model.Employee;

public class ClientBLL {

    private static ClientDAO clientDAO;

    public ClientBLL() {
        clientDAO = new ClientDAO();
    }

    public Client insert(String idClient, String name, String identityCard, String personalNumericalCode, String address)
    {
        Client cl = clientDAO.insert(idClient, name, identityCard, personalNumericalCode, address);
        if (cl == null) {
            throw new NoSuchElementException("The client with id " + idClient + " was not inserted!");
        }
        return cl;
    }

    public Client delete(String name) {
        Client cl = clientDAO.delete(name);
        if (cl == null) {
            throw new NoSuchElementException("The client  was not deleted!");
        }
        return cl;
    }

    public Client findByName(String name){
        Client client =clientDAO.findByName(name);

        if (client == null){
            throw new NoSuchElementException("The client with name: " + name + " was not found!");
        }
        return client;
    }

    public Client update(String name, String identityCard, String cnp, String address) {
        Client client=clientDAO.update(name,identityCard,cnp,address);

        if (client == null) {
            throw new NoSuchElementException("The client with name =" + name + " was not updated!");
        }
        return client;
    }

    public static List<Client> selectAll() {
        List<Client> cl = new ArrayList<Client>();
        cl = clientDAO.selectAll();
        if (cl == null) {
            throw new NoSuchElementException("Elements were not found!");
        }
        return cl;
    }
}
