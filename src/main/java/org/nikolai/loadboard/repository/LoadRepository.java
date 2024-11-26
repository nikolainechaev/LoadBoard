package org.nikolai.loadboard.repository;

import org.nikolai.loadboard.entity.Load;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoadRepository extends JpaRepository<Load, Long> {
    List<Load> findByBookedByIsNull();
    List<Load> findByBookedById(Long userId);
}
