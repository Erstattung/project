package interfaces.PO;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by echerkas on 15.11.2015.
 */
@Entity
@Table(name="CONTRACT")
public class ContractPO {
    @Id
    @GeneratedValue
    @Column(name = "id", insertable = false, updatable = false)
    private Long idContract;

    private String number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_client", nullable = false)
    private ClientPO client;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_tarif", nullable = false)
    private TarifPO tarif;

    @ManyToMany
    @JoinTable(
            name="Option_has_Contract",
            joinColumns={@JoinColumn(name="Contract_id_contract", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="Option_id_option", referencedColumnName="id")})
    private Set<OptionPO> options = new HashSet<>();

    public ContractPO() {
    }

    public ContractPO(String number, ClientPO client, TarifPO tarif) {
        this.number = number;
        this.client = client;
        this.tarif = tarif;
    }

    public Long getIdContract() {
        return idContract;
    }

    public void setIdContract(Long idContract) {
        this.idContract = idContract;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ClientPO getClient() {
        return client;
    }

    public void setClient(ClientPO client) {
        this.client = client;
    }

    public TarifPO getTarif() {
        return tarif;
    }

    public void setTarif(TarifPO tarif) {
        this.tarif = tarif;
    }

    public Set<OptionPO> getOptions() {
        return options;
    }

    public void setOptions(Set<OptionPO> options) {
        this.options = options;
    }
}
