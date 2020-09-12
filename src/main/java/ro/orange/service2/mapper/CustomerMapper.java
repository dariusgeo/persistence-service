package ro.orange.service2.mapper;

import org.mapstruct.Mapper;
import ro.orange.service2.dto.CustomerDTO;
import ro.orange.service2.model.Customer;

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
