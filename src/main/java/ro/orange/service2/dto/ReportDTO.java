package ro.orange.service2.dto;

import org.apache.bval.extras.constraints.checkdigit.IBAN;
import ro.orange.service2.validation.CNP;

import java.util.List;

public class ReportDTO {

    private Long id;
    @CNP
    private String cnp;
    @IBAN
    private String iban;

    private CustomerDTO customer;

    private List<TransactionDTO> transactions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public List<TransactionDTO> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionDTO> transactions) {
        this.transactions = transactions;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
}
