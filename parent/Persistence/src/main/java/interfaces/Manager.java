package interfaces;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by echerkas on 18.11.2015.
 */
public class Manager {

//    public Manager(EntityManager em) {
//        this.em = em;
//    }

    public static EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnit");

    public Manager() {
    }

    public static EntityManager openConnection() {
        EntityManager em = factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        return em;
    }

    public static void closeConnection(EntityManager em) {
        try {
            em.getTransaction().commit();
        } finally {
            em.close();
            factory.close();
        }
    }
}

//    private testMethod(Manager test) {
//        ClientPO client = new ClientPO();
//        client.findByName("Katya", "Che");
//        System.out.println(client);
//        return client;
//    }
//
//    public static void main(String[] args) {
//}
//
////        , new Date(), "UE845", "Hell", "dark@.com", "666"
//
//try {
//
//        em.getTransaction().begin();
//        Employee employee = new Employee();
//        employee.setName("Chandan");
//        System.out.println("COMIITING");
//        em.persist(employee);
//        em.getTransaction().commit();
//    }
//
//
////        test.
////        ContractPO contractPO = em.find(ContractPO.class, 3L);
////        OptionPO optionPO = em.find(OptionPO.class, 3L);
////        contractPO.getOptions().add(optionPO);
////        contractPO.getTarif().getOptions().add(optionPO);
////        em.remove(contractPO);
////            TarifPO tarifPO = em.find(TarifPO.class, 1L);
////            em.remove(tarifPO);
////
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        tx.commit();
////
////        System.out.println(".. done");
////    }
////
////
////
////        int price = 12;
////        double connection_cost = 12;
////        String blabla = "blabla";
////
////        OptionPO option = new OptionPO(blabla, price, connection_cost);
////        System.out.println(option);
////        test.em.persist(option);
////
////        TarifPO tarif = new TarifPO("tarif1", 66.06);
////        System.out.println(tarif);
////
////        ContractPO contract = new ContractPO("firstContract", client, tarif);
////        System.out.println(tarif);
////
////        test.em.persist(contract);
////    }
////
////    private OptionPO createOption(int i, String katya, String che, Date date, String ue845, String hell, String s, String s1, String s2) {
////        return null;
////    }
////
////    public ClientPO createClient(String name, String surname, Date birthday,
////                                 String passport, String address, String mail, String password) {
////
////        ClientPO client = new ClientPO();
////        client.setName(name);
////        client.setSurname(surname);
////        client.setBirthday(birthday);
////        client.setPassport(passport);
////        client.setAddress(address);
////        client.setMail(mail);
////        client.setPassword(password);
//////        client.setContracts();
////        em.persist(client);
////        System.out.print(client);
////        return client;
////    }
////
////    public ClientPO changeClientName(int id, String name) {
////        ClientPO client = em.find(ClientPO.class, id);
////        if (client != null) {
////            client.setName(name);
////        }
////        return client;
////    }
////
////    public void removeClient(List<ClientPO> clientList) {
////        for (ClientPO clientPO : clientList) {
////            em.remove(clientPO);
////            System.out.print(clientPO);
////        }
////
////
////    }
////
////    public ClientPO findClient(int id) {
////        return em.find(ClientPO.class, id);
////    }
////
////    public List<ClientPO> findAllClients() {
////        TypedQuery<ClientPO> query = em.createQuery("SELECT a FROM ClientPO a", ClientPO.class);
////        return query.getResultList();
////    }
////}
////
//
//
//        }
//        }
