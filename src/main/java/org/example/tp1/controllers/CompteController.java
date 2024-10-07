package org.example.tp1.controllers;

import org.example.tp1.entites.Compte;
import org.example.tp1.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comptes")
public class CompteController {

    @Autowired
    private CompteRepository compteRepository;

    @RequestMapping
    public List<Compte> getComptes() {
        return compteRepository.findAll();
    }

    @PostMapping
    public Compte saveCompte(@RequestBody Compte compte) {
        return compteRepository.save(compte);
    }

    @PutMapping("/{id}")
    public Compte updateCompte(@PathVariable Long id, @RequestBody Compte compteDetails) {
        Compte compte = compteRepository.findById(id).orElseThrow();
        compte.setNom(compteDetails.getNom());
        compte.setSolde(compteDetails.getSolde());
        return compteRepository.save(compte);
    }

    @DeleteMapping("/{id}")
    public void deleteCompte(@PathVariable Long id) {
        compteRepository.deleteById(id);
    }
}
