package ru.dressyourkid.kidshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.dressyourkid.kidshop.entity.Product;

/**
 * Created by lconnected on 04/07/2018.
 */
@RepositoryRestResource(collectionResourceRel = "product", path = "product")
public interface ProductRepository extends JpaRepository<Product, Long> {
    //empty
}
