package ru.dressyourkid.kidshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dressyourkid.kidshop.entity.Size;

public interface SizeRepository extends JpaRepository<Size, Long> {
    //empty
}
