package persistence.Implementation;

import persistence.DAO.ClientDAO;
import persistence.GenericDAOImpl;
import persistence.PO.ClientPO;

/**
 * Created by echerkas on 24.11.2015.
 */
public class ClientDAOImpl extends GenericDAOImpl<ClientPO> implements ClientDAO {
    public ClientPO findByName(String name) {
        return entityManager.createQuery("SELECT c from ClientPO c WHERE " +
                "c.name = :name", ClientPO.class)
                .setParameter("name", name).getSingleResult();
    }

    public ClientPO findBySurname(String surname) {
        return entityManager.createQuery("SELECT c from ClientPO c WHERE " +
                "c.surname = :surname", ClientPO.class)
                .setParameter("surname", surname).getSingleResult();
    }

    public ClientPO findByFullName(String name, String surname) {
        return entityManager.createQuery("SELECT c from ClientPO c WHERE " +
                "c.name = :name AND c.surname = :surname", ClientPO.class)
                .setParameter("name", name).setParameter("surname", surname).getSingleResult();
    }

    public ClientPO findByNumber (String number){
        return entityManager.createQuery("SELECT c FROM ContractPO c " +
                " WHERE c.number = :number", ClientPO.class).
                setParameter("number", number).getSingleResult();
    }
    }
