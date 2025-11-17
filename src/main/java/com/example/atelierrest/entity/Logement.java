package com.example.atelierrest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "logements")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Logement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reference;

    @NotBlank(message = "L'adresse est obligatoire")
    @Column(nullable = false)
    private String adresse;

    @NotBlank(message = "La délégation est obligatoire")
    @Column(nullable = false)
    private String delegation;

    @NotBlank(message = "Le gouvernorat est obligatoire")
    @Column(nullable = false)
    private String gouvernorat;

    @NotBlank(message = "Le type est obligatoire")
    @Column(nullable = false)
    private String type;

    @Column(length = 1000)
    private String description;

    @NotNull(message = "Le prix est obligatoire")
    @Positive(message = "Le prix doit être positif")
    @Column(nullable = false)
    private float prix;
}
