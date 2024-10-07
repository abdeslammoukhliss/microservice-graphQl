package org.example.tp1.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

@Data
public class CompteDTO {
    private String nom;
    private Double solde;
    private String type;
}

