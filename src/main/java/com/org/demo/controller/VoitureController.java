package com.org.demo.controller;

import com.org.demo.modele.Voiture;
import com.org.demo.repo.VoitureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

import com.org.demo.modele.Voiture;
import com.org.demo.repo.VoitureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RequestMapping("/voitures")
public class VoitureController {

    private static final Logger logger = LoggerFactory.getLogger(VoitureController.class);

    @Autowired
    private VoitureRepo voitureRepo;

    // Lire toutes les voitures
    @GetMapping
    public Iterable<Voiture> getVoitures() {
        logger.info("Récupération de toutes les voitures");
        Iterable<Voiture> voitures = voitureRepo.findAll();
        logger.info("Nombre de voitures récupérées: {}", ((Collection<?>) voitures).size());
        return voitures;
    }

    // Ajouter une nouvelle voiture
    @PostMapping
    public Voiture addVoiture(@RequestBody Voiture voiture) {
        logger.info("Requête pour ajouter une voiture: {}", voiture);
        Voiture savedVoiture = voitureRepo.save(voiture);
        logger.info("Voiture ajoutée avec succès: {}", savedVoiture);
        return savedVoiture;
    }

    // Mettre à jour une voiture existante
    @PutMapping("/{id}")
    public Voiture updateVoiture(@PathVariable Long id, @RequestBody Voiture updatedVoiture) {
        logger.info("Requête de mise à jour pour la voiture avec ID: {}", id);
        Optional<Voiture> voitureOptional = voitureRepo.findById(id);

        if (voitureOptional.isPresent()) {
            Voiture voiture = voitureOptional.get();
            voiture.setMarque(updatedVoiture.getMarque());
            voiture.setModele(updatedVoiture.getModele());
            voiture.setCouleur(updatedVoiture.getCouleur());
            voiture.setImmatricule(updatedVoiture.getImmatricule());
            voiture.setAnnee(updatedVoiture.getAnnee());
            voiture.setPrix(updatedVoiture.getPrix());

            Voiture savedVoiture = voitureRepo.save(voiture);
            logger.info("Voiture mise à jour avec succès: {}", savedVoiture);
            return savedVoiture;
        } else {
            logger.error("Voiture non trouvée avec l'ID: {}", id);
            throw new RuntimeException("Voiture non trouvée avec l'ID: " + id);
        }
    }

    // Supprimer une voiture
    @DeleteMapping("/{id}")
    public void deleteVoiture(@PathVariable Long id) {
        logger.info("Requête de suppression pour la voiture avec ID: {}", id);
        voitureRepo.deleteById(id);
        logger.info("Voiture supprimée avec succès");
    }
}