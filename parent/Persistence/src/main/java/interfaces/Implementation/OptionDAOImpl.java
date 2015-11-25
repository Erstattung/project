package interfaces.Implementation;

import interfaces.GenericDAOImpl;
import interfaces.PO.OptionPO;

/**
 * Created by echerkas on 24.11.2015.
 */
public class OptionDAOImpl extends GenericDAOImpl <OptionPO> {
    public OptionPO findByName (String name){
        return entityManager.createQuery("SELECT c from OptionPO c WHERE " +
                "c.name = :name", OptionPO.class)
                .setParameter("name", name).getSingleResult();
    }
}
