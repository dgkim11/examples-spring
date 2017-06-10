package example.spring.data.repository;

import example.spring.data.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Create a Repository by extending CrudRepository to enable Spring Data Repository features.
 *
 * User : Dongle (Dongkyun)
 * Date : 2016. 10. 8.
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
