package com.example.atelierrest.repository;
import com.example.atelierrest.entity.Logement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LogementRepository extends JpaRepository<Logement, Integer> {

    // Méthodes personnalisées optionnelles
    List<Logement> findByGouvernorat(String gouvernorat);
    List<Logement> findByType(String type);
    List<Logement> findByPrixLessThanEqual(float prix);
}
