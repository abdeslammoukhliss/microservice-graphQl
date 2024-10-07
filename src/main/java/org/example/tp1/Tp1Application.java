package org.example.tp1;

import org.example.tp1.entites.Compte;
import org.example.tp1.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Tp1Application implements CommandLineRunner {
    @Autowired
    private CompteRepository compteRepository;
    public static void main(String[] args) {
        SpringApplication.run(Tp1Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Compte compte=new Compte();
        compte.setNom("compte");
        compte.setSolde(23.0D);
        compteRepository.save(compte);
    }
}
