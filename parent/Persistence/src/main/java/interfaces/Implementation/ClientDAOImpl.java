package interfaces.Implementation;

import interfaces.GenericDAOImpl;
import interfaces.PO.ClientPO;

import java.util.List;


/**
 * Created by echerkas on 24.11.2015.
 */
public class ClientDAOImpl extends GenericDAOImpl<ClientPO> {
    List<ClientPO> clients;

    public ClientDAOImpl() {
        super();
    }

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

    public ClientPO getById(Long id, ClientPO xx) {
        return entityManager.find(entityClass, id);
    }

    public List<ClientPO> getAllClients() {
        return clients;
    }

//    @Override
//    public List<T> getAll(Class xx) {
//        TypedQuery<T> query = entityManager.createQuery("from " + xx.getName(), xx);
//        return query.getResultList();
//    }
//
//    public List<ClientPO> getAll(ClientPO xx) {
//        TypedQuery<ClientPO> query = entityManager.createQuery("from " + xx.getName(), ClientPO <xx>);
//        return query.getResultList();
    }
//        return entityManager.find(entityClass, id);
//    }

