package ro.orange.service2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.orange.service2.dto.ReportDTO;
import ro.orange.service2.mapper.CustomerMapper;
import ro.orange.service2.mapper.TransactionMapper;
import ro.orange.service2.model.Customer;
import ro.orange.service2.model.Transaction;
import ro.orange.service2.repository.CustomerRepository;
import ro.orange.service2.repository.TransactionRepository;

import javax.persistence.NonUniqueResultException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReportService {

    Logger logger = LoggerFactory.getLogger(ReportService.class.getName());

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private TransactionMapper transactionMapper;

    public ReportDTO generateReport(String cnp, String iban){
        ReportDTO result = new ReportDTO();
        Optional<Customer> customer;
        try {
            customer = customerRepository.findOneByCnp(cnp);
        } catch (NonUniqueResultException nre) {
            logger.error(nre.getMessage(), nre);
            List<Customer> customers = customerRepository.findAllByCnp(cnp);
            customer = Optional.of(customers.get(0));
        }
        List<Transaction> transactionList = transactionRepository.findAllByPayerIBAN(iban);

        result.setCnp(cnp);
        result.setIban(iban);
        if (customer.isPresent()){
            result.setCustomer(customerMapper.customerToCustomerDTO(customer.get()));
            result.setTransactions(transactionMapper.transactionsToTransactionDTOs(transactionList));
        }

        return result;
    }
}
