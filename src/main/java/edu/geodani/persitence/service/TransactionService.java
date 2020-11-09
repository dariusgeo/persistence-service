package edu.geodani.persitence.service;

import edu.geodani.persitence.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import edu.geodani.persitence.dto.CustomerDTO;
import edu.geodani.persitence.dto.TransactionDTO;
import edu.geodani.persitence.mapper.TransactionMapper;
import edu.geodani.persitence.model.Transaction;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class TransactionService {

    private final CustomerService customerService;
    private final TransactionMapper transactionMapper;
    private final TransactionRepository transactionRepository;

    public TransactionDTO createTransaction(TransactionDTO transactionDTO) {
        log.debug("About to create a new transaction:: ", transactionDTO);
        CustomerDTO payer = transactionDTO.getPayer();
        CustomerDTO payee = transactionDTO.getPayee();
        payer = (customerService.findCustomerByCNP(payer.getCnp()) == null) ? customerService.createCustomer(payer) : customerService.findCustomerByCNP(payer.getCnp());
        payee = (customerService.findCustomerByCNP(payee.getCnp()) == null) ? customerService.createCustomer(payee) : customerService.findCustomerByCNP(payee.getCnp());
        transactionDTO.setPayerId(payer.getId());
        transactionDTO.setPayeeId(payee.getId());
        Transaction transaction = transactionMapper.transactionDTOToTransaction(transactionDTO);
        transaction = transactionRepository.save(transaction);
        log.debug("Transaction succsessfully created:: ", transaction);
        return transactionMapper.transactionToTransactionDTO(transaction);
    }
}