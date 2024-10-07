package org.example.tp1.controllers;

import org.example.tp1.dtos.CompteDTO;
import org.example.tp1.entites.Compte;
import org.example.tp1.mappers.CompteMapper;
import org.example.tp1.repositories.CompteRepository;
import org.example.tp1.services.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class CompteGraphqlController {

    @Autowired
    private final CompteRepository compteRepository;

    @Autowired
    private final CompteService compteService;

    @Autowired
    private final CompteMapper compteMapper;

    // Constructor
    public CompteGraphqlController(CompteRepository compteRepository, CompteService compteService, CompteMapper compteMapper) {
        this.compteRepository = compteRepository;
        this.compteService = compteService;
        this.compteMapper = compteMapper;
    }

    // Query to get all comptes
    @QueryMapping
    public Iterable<Compte> comptesList() {
        return compteRepository.findAll();
    }

    // Query to get a specific compte by its ID
    @QueryMapping
    public Compte getCompteById(@Argument Long id) {
        return compteRepository.findById(id).orElseThrow(() -> new RuntimeException("Compte not found with ID: " + id));
    }

    // Mutation to create a new compte
    @MutationMapping
    public Compte saveCompte(@Argument CompteDTO compteDTO) {
        // Map from DTO to entity, then save using the service layer
        return compteMapper.toEntity(compteService.createCompte(compteDTO));
    }

    // Mutation to update an existing compte
    @MutationMapping
    public Compte updateCompte(@Argument Long id, @Argument CompteDTO compteDTO) {
        Compte existingCompte = compteRepository.findById(id).orElseThrow(() -> new RuntimeException("Compte not found with ID: " + id));
        compteMapper.updateCompteFromDTO(compteDTO, existingCompte);  // Assuming update logic is in the mapper
        return compteMapper.toEntity(compteService.createCompte(compteDTO));
    }

    // Mutation to delete a compte by its ID
    @MutationMapping
    public String deleteCompte(@Argument Long id) {
        compteRepository.deleteById(id);
        return "Compte deleted successfully!";
    }
}
