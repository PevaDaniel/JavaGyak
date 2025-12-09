package org.example.beadando_gy.repository;

import org.example.beadando_gy.Entity.Pilota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PilotaRepository extends JpaRepository<Pilota, Integer> {
}
