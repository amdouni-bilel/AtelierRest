package com.example.atelierrest.controller;


import com.example.atelierrest.entity.Logement;
import com.example.atelierrest.service.ILogementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logements")
@Tag(name = "Logement Management", description = "APIs pour gérer les logements")
public class LogementController {

    private final ILogementService logementService;

    @Autowired
    public LogementController(ILogementService logementService) {
        this.logementService = logementService;
    }

    @PostMapping
    @Operation(summary = "Créer un nouveau logement")
    public ResponseEntity<Logement> createLogement(@Valid @RequestBody Logement logement) {
        return ResponseEntity.ok(logementService.saveLogement(logement));
    }

    @GetMapping
    @Operation(summary = "Récupérer tous les logements")
    public ResponseEntity<List<Logement>> getAllLogements() {
        return ResponseEntity.ok(logementService.getAllLogements());
    }

    @GetMapping("/{reference}")
    @Operation(summary = "Récupérer un logement par sa référence")
    public ResponseEntity<Logement> getLogementById(@PathVariable int reference) {
        return logementService.getLogementById(reference)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/gouvernorat/{gouvernorat}")
    @Operation(summary = "Récupérer les logements par gouvernorat")
    public ResponseEntity<List<Logement>> getLogementsByGouvernorat(@PathVariable String gouvernorat) {
        return ResponseEntity.ok(logementService.getLogementsByGouvernorat(gouvernorat));
    }

    @GetMapping("/type/{type}")
    @Operation(summary = "Récupérer les logements par type")
    public ResponseEntity<List<Logement>> getLogementsByType(@PathVariable String type) {
        return ResponseEntity.ok(logementService.getLogementsByType(type));
    }

    @GetMapping("/prix/{maxPrix}")
    @Operation(summary = "Récupérer les logements avec prix inférieur ou égal")
    public ResponseEntity<List<Logement>> getLogementsByMaxPrice(@PathVariable float maxPrix) {
        return ResponseEntity.ok(logementService.getLogementsByMaxPrice(maxPrix));
    }

    @PutMapping("/{reference}")
    @Operation(summary = "Mettre à jour un logement")
    public ResponseEntity<Logement> updateLogement(@PathVariable int reference,
                                                   @Valid @RequestBody Logement logement) {
        Logement updated = logementService.updateLogement(reference, logement);
        if (updated != null)
            return ResponseEntity.ok(updated);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{reference}")
    @Operation(summary = "Supprimer un logement")
    public ResponseEntity<Void> deleteLogement(@PathVariable int reference) {
        logementService.deleteLogement(reference);
        return ResponseEntity.noContent().build();
    }
}
