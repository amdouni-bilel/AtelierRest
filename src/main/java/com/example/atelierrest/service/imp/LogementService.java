package com.example.atelierrest.service.imp;


import com.example.atelierrest.entity.Logement;
import com.example.atelierrest.repository.LogementRepository;
import com.example.atelierrest.service.ILogementService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LogementService implements ILogementService {

    private final LogementRepository logementRepository;

    public LogementService(LogementRepository logementRepository) {
        this.logementRepository = logementRepository;
    }

    @Override
    public Logement saveLogement(Logement logement) {
        return logementRepository.save(logement);
    }

    @Override
    public List<Logement> getAllLogements() {
        return logementRepository.findAll();
    }

    @Override
    public Optional<Logement> getLogementById(int reference) {
        return logementRepository.findById(reference);
    }

    @Override
    public Logement updateLogement(int reference, Logement logement) {
        if (logementRepository.existsById(reference)) {
            logement.setReference(reference);
            return logementRepository.save(logement);
        }
        return null;
    }

    @Override
    public void deleteLogement(int reference) {
        logementRepository.deleteById(reference);
        System.out.println("Logement avec référence " + reference + " a été supprimé.");
    }

    @Override
    public List<Logement> getLogementsByGouvernorat(String gouvernorat) {
        return logementRepository.findByGouvernorat(gouvernorat);
    }

    @Override
    public List<Logement> getLogementsByType(String type) {
        return logementRepository.findByType(type);
    }

    @Override
    public List<Logement> getLogementsByMaxPrice(float maxPrix) {
        return logementRepository.findByPrixLessThanEqual(maxPrix);
    }
}
