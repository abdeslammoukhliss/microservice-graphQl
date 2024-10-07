package org.example.tp1.projections;

import org.example.tp1.entites.Compte;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "compteProjection", types = Compte.class)
public interface CompteProjection {
    String getNom();
    Double getSolde();
}
