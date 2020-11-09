package edu.geodani.persitence.service;

import edu.geodani.persitence.dto.ReportDTO;
import edu.geodani.persitence.mapper.CustomerMapper;
import edu.geodani.persitence.mapper.TransactionMapper;
import edu.geodani.persitence.model.Customer;
import edu.geodani.persitence.model.Transaction;
import edu.geodani.persitence.repository.CustomerRepository;
import edu.geodani.persitence.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NonUniqueResultException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ReportService {

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    private final TransactionRepository transactionRepository;

    private final TransactionMapper transactionMapper;

    public ReportDTO generateReport(String cnp, String iban){
        ReportDTO result = new ReportDTO();
        List<Transaction> transactionList = transactionRepository.findAllByPayerIBAN(iban);
        log.debug(String.format("Generating report for CNP:: %s , IBAN:: %s", cnp, iban));
        result.setCnp(cnp);
        result.setIban(iban);
        Optional<Customer> customer = customerRepository.findOneByCnp(cnp);
        if (customer.isPresent()){
            result.setCustomer(customerMapper.customerToCustomerDTO(customer.get()));
            result.setTransactions(transactionMapper.transactionsToTransactionDTOs(transactionList));
        }

        return result;
    }
}
