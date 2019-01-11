package ru.dressyourkid.kidshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dressyourkid.kidshop.entity.ProductStore;

public interface ProductStoreRepository extends JpaRepository<ProductStore, Long> {
}
