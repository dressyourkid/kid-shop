package ru.dressyourkid.kidshop.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.dressyourkid.kidshop.entity.Basket;

@RepositoryRestResource(collectionResourceRel = "basket", path = "basket")
public interface BasketRepository extends JpaRepository<Basket, Long> {
    //empty
}
