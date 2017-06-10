package example.springboot.repository;

import example.springboot.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * User : Dongle (Dongkyun)
 * Date : 2016. 12. 19.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);
}
