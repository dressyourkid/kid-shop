package ru.dressyourkid.kidshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dressyourkid.kidshop.entity.ProductMeta;

public interface ProductMetaRepository extends JpaRepository<ProductMeta, Long> {
}
