package interfaces.DAO;

import interfaces.GenericDAOInterface;
import interfaces.PO.OptionPO;

/**
 * Created by echerkas on 24.11.2015.
 */
public interface OptionDAO extends GenericDAOInterface <OptionPO> {
    public OptionPO findByName (String name);
}
