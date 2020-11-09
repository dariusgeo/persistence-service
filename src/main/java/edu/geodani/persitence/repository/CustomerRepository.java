package edu.geodani.persitence.repository;

import edu.geodani.persitence.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findOneById(Long id);

    Optional<Customer> findOneByCnp(String cnp);

}
