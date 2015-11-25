package interfaces;

import interfaces.PO.ClientPO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by echerkas on 24.11.2015.
 */
public class Main {

//    public EntityManager openConnection() {
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnit");
//        EntityManager em = factory.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//        return em;
//    }
//
//    ClientPO clientPO = new ClientPO();
//    clientPO.
////    Main(em){
////        System.out.println("Done");
////    }
//
//    ClientDAOImpl clientDao = new ClientDAOImpl();
//    //update student
//    ClientPO client = ClientPO.setName("Kate");

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        ClientPO notemployee = new ClientPO();
        notemployee.setName("Chandan");
        System.out.println("COMIITING");
        em.persist(notemployee);
        em.getTransaction().commit();
        System.out.println("Done");
    }
}





//    }
//        ClientDAOImpl clientDao = new ClientDAOImpl(factory);
//        clientDao.findByName("Katya");
//        System.out.println(clientDao);
//    }
