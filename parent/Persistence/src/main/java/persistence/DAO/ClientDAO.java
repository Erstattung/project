package persistence.DAO;

import persistence.GenericDAOInterface;
import persistence.PO.ClientPO;

/**
 * Created by echerkas on 24.11.2015.
 */
public interface ClientDAO extends GenericDAOInterface<ClientPO> {
    public ClientPO findByFullName(String name, String surname);
    public ClientPO findBySurname (String surname);
    public ClientPO findByName(String name);
    public ClientPO findByNumber(String number);

}