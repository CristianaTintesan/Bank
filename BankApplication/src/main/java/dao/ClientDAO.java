package dao;
import java.util.ArrayList;
import java.util.List;
import model.Client;
import model.Employee;

public class ClientDAO extends AbstractDAO <Client> {

    public Client insert(String id, String name, String identityCard, String personalNumericalCode, String address) {
        ArrayList<Object> list = new ArrayList<Object>();
        list.add(id);
        list.add(name);
        list.add(identityCard);
        list.add(personalNumericalCode);
        list.add(address);
        return super.insert(list);
    }

    public Client delete(String name) {
        ArrayList<Object> list = new ArrayList<Object>();
        ArrayList<String> names = new ArrayList<String>();
        if (name != "") {
            list.add(name);
            names.add("name");
        }
        return super.delete(list, names);
    }

    public Client findByName(String name){

        return super.findByName(name);
    }

    public Client update(String name, String identityCard, String cnp, String address) {
        ArrayList<Object> list = new ArrayList<Object>();
        list.add(name);
        list.add(identityCard);
        list.add(cnp);
        list.add(address);
        ArrayList<String> names = new ArrayList<String>();
        names.add("name");
        names.add("identityCard");
        names.add("personalNumericalCode");
        names.add("address");
        return super.update(list, names, name, "name");
    }

    public List<Client> selectAll() {
        return super.selectAll();
    }
}
