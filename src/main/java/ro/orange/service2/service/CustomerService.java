package ro.orange.service2.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.orange.service2.dto.CustomerDTO;
import ro.orange.service2.mapper.CustomerMapper;
import ro.orange.service2.model.Customer;
import ro.orange.service2.repository.CustomerRepository;

import java.util.Optional;

@Service
@Transactional
public class CustomerService {

    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerMapper customerMapper,
                           CustomerRepository customerRepository){
        this.customerMapper = customerMapper;
        this.customerRepository = customerRepository;
    }

    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
        customer = customerRepository.save(customer);
        return customerMapper.customerToCustomerDTO(customer);
    }

    @Transactional(readOnly = true)
    public CustomerDTO findCustomerById(Long id){
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()){
            return customerMapper.customerToCustomerDTO(customer.get());
        }
        return null;
    }

    @Transactional(readOnly = true)
    public CustomerDTO findCustomerByCNP(String cnp){
        Optional<Customer> customer = customerRepository.findOneByCnp(cnp);
        if (customer.isPresent()){
            return customerMapper.customerToCustomerDTO(customer.get());
        }
        return null;
    }
}
