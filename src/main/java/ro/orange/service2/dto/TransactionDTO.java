package ro.orange.service2.dto;

//import lombok.Data;
import org.apache.bval.extras.constraints.checkdigit.IBAN;

//@Data
public class TransactionDTO {

    private Long id;
    private CustomerDTO payer;
    private Long payerId;
    @IBAN
    private String payerIBAN;
    private CustomerDTO payee;
    private Long payeeId;
    @IBAN
    private String payeeIBAN;
    private Double amount;
    private int transactionTypeId;
    private int currencyId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPayerId() {
        return payerId;
    }

    public void setPayerId(Long payerId) {
        this.payerId = payerId;
    }

    public Long getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(Long payeeId) {
        this.payeeId = payeeId;
    }

    public CustomerDTO getPayer() {
        return payer;
    }

    public void setPayer(CustomerDTO payer) {
        this.payer = payer;
    }

    public String getPayerIBAN() {
        return payerIBAN;
    }

    public void setPayerIBAN(String payerIBAN) {
        this.payerIBAN = payerIBAN;
    }

    public CustomerDTO getPayee() {
        return payee;
    }

    public void setPayee(CustomerDTO payee) {
        this.payee = payee;
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

    @Override
    public String toString() {
        return "TransactionDTO{" +
                "id=" + id +
                ", payer=" + payer +
                ", payerId=" + payerId +
                ", payerIBAN='" + payerIBAN + '\'' +
                ", payee=" + payee +
                ", payeeId=" + payeeId +
                ", payeeIBAN='" + payeeIBAN + '\'' +
                ", amount=" + amount +
                ", transactionTypeId=" + transactionTypeId +
                ", currencyId=" + currencyId +
                '}';
    }
}
