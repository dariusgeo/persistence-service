package ro.orange.service2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.orange.service2.dto.CustomerDTO;
import ro.orange.service2.dto.TransactionDTO;
import ro.orange.service2.mapper.TransactionMapper;
import ro.orange.service2.model.Transaction;
import ro.orange.service2.repository.TransactionRepository;

@Service
@Transactional
public class TransactionService {
    Logger logger = LoggerFactory.getLogger(TransactionService.class.getName());

    private final CustomerService customerService;
    private final TransactionMapper transactionMapper;
    private final TransactionRepository transactionRepository;

    public TransactionService( TransactionMapper transactionMapper,
                               TransactionRepository transactionRepository,
                               CustomerService customerService){
        this.transactionMapper = transactionMapper;
        this.transactionRepository = transactionRepository;
        this.customerService = customerService;
    }

    public TransactionDTO createTransaction(TransactionDTO transactionDTO) {
        CustomerDTO payer = transactionDTO.getPayer();
        CustomerDTO payee = transactionDTO.getPayee();
        payer = (customerService.findCustomerByCNP(payer.getCnp()) == null) ? customerService.createCustomer(payer) : customerService.findCustomerByCNP(payer.getCnp());
        payee = (customerService.findCustomerByCNP(payee.getCnp()) == null) ? customerService.createCustomer(payee) : customerService.findCustomerByCNP(payee.getCnp());
        transactionDTO.setPayerId(payer.getId());
        transactionDTO.setPayeeId(payee.getId());
        Transaction transaction = transactionMapper.transactionDTOToTransaction(transactionDTO);
        transaction = transactionRepository.save(transaction);
        return transactionMapper.transactionToTransactionDTO(transaction);
    }
}