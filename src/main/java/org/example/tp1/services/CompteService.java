package org.example.tp1.services;

import org.example.tp1.dtos.CompteDTO;
import org.example.tp1.mappers.CompteMapper;
import org.example.tp1.repositories.CompteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompteService {
    private final CompteRepository compteRepository;
    private final CompteMapper compteMapper;

    public CompteService(CompteRepository compteRepository, CompteMapper compteMapper) {
        this.compteRepository = compteRepository;
        this.compteMapper = compteMapper;
    }

    public List<CompteDTO> getAllComptes() {
        return compteRepository.findAll().stream()
                .map((e)->compteMapper.toDTO(e))
                .toList();
    }
    public CompteDTO getCompteById(Long id) {
        return compteMapper.toDTO(compteRepository.findById(id).orElse(null));
    }
    public CompteDTO createCompte(CompteDTO compteDTO) {
        return compteMapper.toDTO(compteRepository.save(compteMapper.toEntity(compteDTO)));
    }
}