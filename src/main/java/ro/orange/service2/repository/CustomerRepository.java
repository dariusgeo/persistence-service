package ro.orange.service2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.orange.service2.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findOneById(Long id);

    Optional<Customer> findOneByCnp(String cnp);

    // TODO Acesta metoda este o anomalie - Implementat constrangere
    List<Customer> findAllByCnp(String cnp);

}
