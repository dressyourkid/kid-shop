package ru.dressyourkid.kidshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dressyourkid.kidshop.entity.ProductStore;

import java.util.List;
import java.util.Optional;

public interface ProductStoreRepository extends JpaRepository<ProductStore, Long> {

    Optional<List<ProductStore>> findByProductMetaId(Long productMetaId);

}
