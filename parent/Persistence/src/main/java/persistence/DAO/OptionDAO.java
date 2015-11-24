package persistence.DAO;

import persistence.GenericDAOInterface;
import persistence.PO.OptionPO;

/**
 * Created by echerkas on 24.11.2015.
 */
public interface OptionDAO extends GenericDAOInterface <OptionPO> {
    public OptionPO findByName (String name);
}
