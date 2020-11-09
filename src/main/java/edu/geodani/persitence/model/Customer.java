package edu.geodani.persitence.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="customers")
@Data
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
}
