package com.example.atelierrest.service;

import com.example.atelierrest.entity.Logement;

import java.util.List;
import java.util.Optional;

public interface ILogementService {

    Logement saveLogement(Logement logement);

    List<Logement> getAllLogements();

    Optional<Logement> getLogementById(int reference);

    Logement updateLogement(int reference, Logement logement);

    void deleteLogement(int reference);

    List<Logement> getLogementsByGouvernorat(String gouvernorat);

    List<Logement> getLogementsByType(String type);

    List<Logement> getLogementsByMaxPrice(float maxPrix);
}
