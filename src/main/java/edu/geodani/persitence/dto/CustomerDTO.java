package edu.geodani.persitence.dto;

import edu.geodani.persitence.validation.CNP;
import lombok.Data;

@Data
public class CustomerDTO {

    private Long id;
    private String firstname;
    private String lastname;
    @CNP
    private String cnp;
}
