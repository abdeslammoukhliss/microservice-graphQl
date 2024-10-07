package org.example.tp1;

import org.example.tp1.entites.Compte;
import org.example.tp1.repositories.CompteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
public class CompteRepositoryTest {

    @Autowired
    private CompteRepository compteRepository;

    @Test
    public void testSaveAndFindAll() {
        Compte compte = new Compte();
        compte.setNom("John Doe");
        compte.setSolde(1000.0);
        compteRepository.save(compte);

        List<Compte> comptes = compteRepository.findAll();
        assert !comptes.isEmpty();
    }
}
