package org.example.tp1.mappers;

import org.example.tp1.dtos.CompteDTO;
import org.example.tp1.entites.Compte;
import org.springframework.stereotype.Component;

@Component
public class CompteMapper {

    // Method to map from CompteDTO to Compte entity
    public Compte toEntity(CompteDTO dto) {
        if (dto == null) {
            return null;
        }

        Compte compte = new Compte();
        compte.setType(dto.getType());
        compte.setSolde(dto.getSolde());

        return compte;
    }

    // Method to map from Compte entity to CompteDTO
    public CompteDTO toDTO(Compte entity) {
        if (entity == null) {
            return null;
        }

        CompteDTO dto = new CompteDTO();
        dto.setType(entity.getType());
        dto.setSolde(entity.getSolde());

        return dto;
    }

    // Method to update an existing Compte entity from a CompteDTO
    public void updateCompteFromDTO(CompteDTO dto, Compte entity) {
        if (dto == null || entity == null) {
            return;
        }

        entity.setType(dto.getType());
        entity.setSolde(dto.getSolde());
    }
}
