package org.example.beadando_gy.repository;

import org.example.beadando_gy.Entity.Gp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GpRepository extends JpaRepository<Gp, Long> {
}
