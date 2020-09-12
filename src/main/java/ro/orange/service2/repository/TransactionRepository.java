package ro.orange.service2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.orange.service2.model.Transaction;

import java.util.List;

public interface TransactionRepository  extends JpaRepository<Transaction, Long> {

    List<Transaction> findAllByPayerId(Long id);

    List<Transaction> findAllByPayerIBAN(String iban);
}
