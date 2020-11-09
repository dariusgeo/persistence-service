package edu.geodani.persitence.dto;

import lombok.Data;
import lombok.ToString;
import org.apache.bval.extras.constraints.checkdigit.IBAN;

@Data
@ToString
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

}
