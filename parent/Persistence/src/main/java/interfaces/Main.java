package interfaces;

import interfaces.PO.ClientPO;
import interfaces.PO.ContractPO;
import interfaces.PO.TarifPO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by echerkas on 24.11.2015.
 */
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

//        New client name in DB

        ClientPO notemployee = new ClientPO();
        notemployee.setName("thirdPerson");
        System.out.println("COMIITING");
        em.persist(notemployee);
//        em.getTransaction().commit();
        System.out.println("Done");

        //New Tarif in DB

        TarifPO newTarif = new TarifPO();
        newTarif.setName("AnotherTarif");
        newTarif.setPrice(12.00);
        System.out.println("COMIITING");
        em.persist(newTarif);
//        em.getTransaction().commit();
        System.out.println("Done");

        //New contract in DB (not working yet)

        ContractPO newContract = new ContractPO();
        newContract.getClient();
        newContract.setClient(notemployee);
        newContract.setNumber("666-333-666");
        newContract.getTarif();
        newContract.setTarif(newTarif);
        System.out.println("COMIITING");
        em.persist(newContract);
        em.getTransaction().commit();
        System.out.println("Done");
    }
    }


//    }
//        ClientDAOImpl clientDao = new ClientDAOImpl(factory);
//        clientDao.findByName("Katya");
//        System.out.println(clientDao);
//    }
