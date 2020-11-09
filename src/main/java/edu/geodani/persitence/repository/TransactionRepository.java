package edu.geodani.persitence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.geodani.persitence.model.Transaction;

import java.util.List;

public interface TransactionRepository  extends JpaRepository<Transaction, Long> {

    List<Transaction> findAllByPayerId(Long id);

    List<Transaction> findAllByPayerIBAN(String iban);
}
