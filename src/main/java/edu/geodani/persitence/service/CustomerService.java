package edu.geodani.persitence.service;

import edu.geodani.persitence.dto.CustomerDTO;
import edu.geodani.persitence.model.Customer;
import edu.geodani.persitence.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import edu.geodani.persitence.mapper.CustomerMapper;

import java.util.Optional;

import static java.util.Optional.empty;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;

    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
        customer = customerRepository.save(customer);
        return customerMapper.customerToCustomerDTO(customer);
    }

    @Transactional(readOnly = true)
    public CustomerDTO findCustomerById(Long id){
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.map(customerMapper::customerToCustomerDTO).orElse(null);
    }

    @Transactional(readOnly = true)
    public CustomerDTO findCustomerByCNP(String cnp){
        Optional<Customer> customer = customerRepository.findOneByCnp(cnp);
        return customer.map(customerMapper::customerToCustomerDTO).orElse(null);
    }
}
