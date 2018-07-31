package ru.dressyourkid.kidshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.dressyourkid.kidshop.entity.StoreItem;

/**
 * Created by lconnected on 04/07/2018.
 */
@RepositoryRestResource(collectionResourceRel = "store", path = "store")
public interface StoreRepository extends JpaRepository<StoreItem, Long> {
    //empty
}
