package org.example.tp1.repositories;
import org.example.tp1.entites.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte, Long> {
}
