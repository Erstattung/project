package persistence;

import persistence.PO.ClientPO;
import persistence.PO.ContractPO;
import persistence.PO.OptionPO;
import persistence.PO.TarifPO;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by echerkas on 18.11.2015.
 */
public class Manager {

    private EntityManager em;

    public Manager(EntityManager em) {
        this.em = em;
    }

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = factory.createEntityManager();
        Manager test = new Manager(em);

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
//            testMethod(test);
            ContractPO contractPO = em.find(ContractPO.class, 3L);
            OptionPO optionPO = em.find(OptionPO.class, 3L);
            contractPO.getOptions().add(optionPO);
            contractPO.getTarif().getOptions().add(optionPO);
            em.remove(contractPO);
//            TarifPO tarifPO = em.find(TarifPO.class, 1L);
//            em.remove(tarifPO);

        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();

        System.out.println(".. done");
    }

    private static void testMethod(Manager test) {
        ClientPO client = test.createClient("Katya", "Che", new Date(), "UE845", "Hell", "dark@.com", "666");
        System.out.println(client);

        int price = 12;
        double connection_cost = 12;
        String blabla = "blabla";

        OptionPO option = new OptionPO(blabla, price, connection_cost);
        System.out.println(option);
        test.em.persist(option);

        TarifPO tarif = new TarifPO("tarif1", 66.06);
        System.out.println(tarif);

        ContractPO contract = new ContractPO("firstContract", client, tarif);
        System.out.println(tarif);

        test.em.persist(contract);
    }

    private OptionPO createOption(int i, String katya, String che, Date date, String ue845, String hell, String s, String s1, String s2) {
        return null;
    }

    public ClientPO createClient(String name, String surname, Date birthday,
                                 String passport, String address, String mail, String password) {

        ClientPO client = new ClientPO();
        client.setName(name);
        client.setSurname(surname);
        client.setBirthday(birthday);
        client.setPassport(passport);
        client.setAddress(address);
        client.setMail(mail);
        client.setPassword(password);
//        client.setContracts();
        em.persist(client);
        System.out.print(client);
        return client;
    }

    public ClientPO changeClientName(int id, String name) {
        ClientPO client = em.find(ClientPO.class, id);
        if (client != null) {
            client.setName(name);
        }
        return client;
    }

    public void removeClient(List<ClientPO> clientList) {
        for (ClientPO clientPO : clientList) {
            em.remove(clientPO);
            System.out.print(clientPO);
        }


    }

    public ClientPO findClient(int id) {
        return em.find(ClientPO.class, id);
    }

    public List<ClientPO> findAllClients() {
        TypedQuery<ClientPO> query = em.createQuery("SELECT a FROM ClientPO a", ClientPO.class);
        return query.getResultList();
    }
}


