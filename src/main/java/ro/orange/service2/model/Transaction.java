package ro.orange.service2.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="transactions")
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPayerIBAN() {
        return payerIBAN;
    }

    public void setPayerIBAN(String payerIBAN) {
        this.payerIBAN = payerIBAN;
    }

    public String getPayeeIBAN() {
        return payeeIBAN;
    }

    public void setPayeeIBAN(String payeeIBAN) {
        this.payeeIBAN = payeeIBAN;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getPayer() {
        return payer;
    }

    public void setPayer(Customer payer) {
        this.payer = payer;
    }

    public Customer getPayee() {
        return payee;
    }

    public void setPayee(Customer payee) {
        this.payee = payee;
    }

    public int getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(int transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
