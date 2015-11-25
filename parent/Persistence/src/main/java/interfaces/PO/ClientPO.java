package interfaces.PO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by echerkas on 15.11.2015.
 */

@Entity
@Table(name="CLIENT", uniqueConstraints = @UniqueConstraint(columnNames = {"name", "surname"}))
public class ClientPO {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;
    private String name, surname, passport, address, mail, password;
    private Date birthday;

    @OneToMany(mappedBy="client",cascade=CascadeType.ALL)
    private List<ContractPO> contracts = new ArrayList<>();

    public ClientPO() {
    }

    public ClientPO(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long clientId) {
        this.id = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ContractPO> getContracts() {
        return contracts;
    }

    public void setContracts(List<ContractPO> contracts) {
        this.contracts = contracts;
    }

    @Override
    public String toString() {
        return "ClientPO{" +
                "clientId=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", passport='" + passport + '\'' +
                ", address='" + address + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                ", contracts=" + contracts +
                '}';
    }
}
