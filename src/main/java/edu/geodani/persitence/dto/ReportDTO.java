package edu.geodani.persitence.dto;

import lombok.Data;
import org.apache.bval.extras.constraints.checkdigit.IBAN;
import edu.geodani.persitence.validation.CNP;

import java.util.List;

@Data
public class ReportDTO {

    private Long id;
    @CNP
    private String cnp;
    @IBAN
    private String iban;

    private CustomerDTO customer;

    private List<TransactionDTO> transactions;

}
