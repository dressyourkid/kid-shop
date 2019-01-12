package ru.dressyourkid.kidshop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.dressyourkid.kidshop.entity.ProductMeta;

public interface ProductMetaRepository extends JpaRepository<ProductMeta, Long> {
    Page<ProductMeta> findByCategoryId(Long categoryId, Pageable pageable);
}
