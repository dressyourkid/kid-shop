package ru.dressyourkid.kidshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dressyourkid.kidshop.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
