package org.example.beadando_gy.repository;

import org.example.beadando_gy.Entity.Eredmeny;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EredmenyRepository extends JpaRepository<Eredmeny, Long> {
}
