package edu.geodani.persitence.mapper;
import java.util.List;

import edu.geodani.persitence.dto.TransactionDTO;
import edu.geodani.persitence.model.Transaction;
import org.mapstruct.Mapper;

import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {CustomerMapper.class})
public interface TransactionMapper {

    @Mapping(source = "payer", target = "payer")
    @Mapping(source = "payer.id", target = "payerId")
    @Mapping(source = "payee", target = "payee")
    @Mapping(source = "payee.id", target = "payeeId")
    TransactionDTO transactionToTransactionDTO(Transaction transaction);

    List<TransactionDTO> transactionsToTransactionDTOs(List<Transaction> transactions);

    @Mapping(source = "payerId", target = "payer")
    @Mapping(source = "payeeId", target = "payee")
    Transaction transactionDTOToTransaction(TransactionDTO transaction);

    List<Transaction> transactionDTOsToTransactions(List<TransactionDTO> transactions);

    default Transaction transactionFromId(Long id) {
        if (id == null) {
            return null;
        }
        Transaction transaction = new Transaction();
        transaction.setId(id);
        return transaction;
    }
}