package ro.orange.service2.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="customers")
public class Customer {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="customer_seq_gen")
    @SequenceGenerator(name="customer_seq_gen", sequenceName="customers_seq", allocationSize = 1)
    private Long id;

    @Column(name="first_name")
    private String firstname;

    @Column(name="last_name")
    private String lastname;

    @Column(name="cnp")
    private String cnp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) &&
                Objects.equals(firstname, customer.firstname) &&
                Objects.equals(lastname, customer.lastname) &&
                Objects.equals(cnp, customer.cnp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, cnp);
    }
}
