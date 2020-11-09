package edu.geodani.persitence.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="transactions")
@Data
public class Transaction implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="transactions_seq_gen")
    @SequenceGenerator(name="transactions_seq_gen", sequenceName="transactions_seq", allocationSize = 1)
    private Long id;

    @Column(name="payer_iban")
    private String payerIBAN;

    @Column(name="payee_iban")
    private String payeeIBAN;

    @Column(name="amount")
    private Double amount;

    @Column(name="date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Version
    @Column(name = "version")
    private int version;

    @ManyToOne
    @JoinColumn(name="payer_id")
    private Customer payer;

    @ManyToOne
    @JoinColumn(name="payee_id")
    private Customer payee;

    private int transactionTypeId;

    private int currencyId;
}
