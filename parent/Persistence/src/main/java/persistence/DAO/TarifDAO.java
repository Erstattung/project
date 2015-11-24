package persistence.DAO;

import persistence.GenericDAOInterface;
import persistence.PO.TarifPO;

/**
 * Created by echerkas on 24.11.2015.
 */
public interface TarifDAO extends GenericDAOInterface <TarifPO> {
    public TarifPO findByName (String name);
}
