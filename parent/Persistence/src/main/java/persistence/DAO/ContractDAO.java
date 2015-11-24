package persistence.DAO;

import persistence.GenericDAOInterface;
import persistence.PO.ContractPO;

/**
 * Created by echerkas on 24.11.2015.
 */
public interface ContractDAO extends GenericDAOInterface <ContractPO> {
    public ContractPO findByNumber(String number);
    public ContractPO findByTarif(String tarif);
}
