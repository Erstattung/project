package interfaces.PO;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by echerkas on 15.11.2015.
 */
@Entity
@Table(name="TARIF")
public class TarifPO {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Double price;
    @ManyToMany
    @JoinTable(
            name="Tarif_has_Option",
            joinColumns={@JoinColumn(name="id_x_tarif", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="id_x_option", referencedColumnName="id")})
    private Set<OptionPO> options = new HashSet<>();

    public TarifPO() {
    }

    public TarifPO(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<OptionPO> getOptions() {
        return options;
    }

    public void setOptions(Set<OptionPO> options) {
        this.options = options;
    }


}
