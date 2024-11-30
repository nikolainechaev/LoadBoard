package org.nikolai.loadboard.repository;

import org.nikolai.loadboard.entity.Load;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoadRepository extends JpaRepository<Load, Long> {
}
