package ru.dressyourkid.kidshop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.dressyourkid.kidshop.entity.ProductMeta;

public interface ProductMetaRepository extends JpaRepository<ProductMeta, Long> {
    Page<ProductMeta> findByCategoryId(Long categoryId, Pageable pageable);

    @Query("select products " +
            "from ProductMeta products " +
            "where lower(products.name) like lower(concat('%', ?1,'%')) " +
            "or lower(products.description) like lower(concat('%', ?1,'%'))")
    Page<ProductMeta> findBySearchString(String searchString, Pageable pageable);
}
