package edu.geodani.persitence.mapper;

import edu.geodani.persitence.dto.CustomerDTO;
import edu.geodani.persitence.model.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface CustomerMapper {

    CustomerDTO customerToCustomerDTO(Customer customer);

    List<CustomerDTO> customersToCustomerDTOs(List<Customer> customers);

    Customer customerDTOToCustomer(CustomerDTO customer);

    List<Customer> customerDTOsToCustomers(List<CustomerDTO> customers);

    default Customer customerFromId(Long id) {
        if (id == null) {
            return null;
        }
        Customer customer = new Customer();
        customer.setId(id);
        return customer;
    }
}
