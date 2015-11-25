package interfaces.PO;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by echerkas on 15.11.2015.
 */
@Entity
@Table(name="OPTIONS")
public class OptionPO {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private double price;

    @Column(name = "connection_cost")
    private double connectionCost;

    @ManyToMany
    @JoinTable(
            name="allowed_options",
            joinColumns={@JoinColumn(name="id_option", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="allowed_option", referencedColumnName="id")})
    private Set<OptionPO> options = new HashSet<>();

    public OptionPO() {
    }

    public OptionPO(String name, double price, double connectionCost) {
        this.name = name;
        this.price = price;
        this.connectionCost = connectionCost;
    }

    public Set<OptionPO> getOptions() {
        return options;
    }

    public void setOptions(Set<OptionPO> options) {
        this.options = options;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long idOption) {
        this.id = idOption;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getConnectionCost() {
        return connectionCost;
    }

    public void setConnectionCost(double connection_cost) {
        this.connectionCost = connection_cost;
    }

}
