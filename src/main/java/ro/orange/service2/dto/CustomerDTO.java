package ro.orange.service2.dto;

import ro.orange.service2.validation.CNP;
//import lombok.Data;

//@Data
public class CustomerDTO {

    private Long id;
    private String firstname;
    private String lastname;
    @CNP
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
}
