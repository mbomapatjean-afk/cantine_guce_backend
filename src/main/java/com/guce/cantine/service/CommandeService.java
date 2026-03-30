package com.guce.cantine.service;

import com.guce.cantine.entity.Commande;
import com.guce.cantine.entity.Menu;
import com.guce.cantine.entity.User;
import com.guce.cantine.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    public Commande choisirMenu(User user, Menu menu) {

        // 🔒 règle : avant vendredi 12h
        LocalDateTime now = LocalDateTime.now();

        if (now.getDayOfWeek() == DayOfWeek.FRIDAY && now.getHour() >= 12) {
            throw new RuntimeException("Délai dépassé !");
        }

        if (now.getDayOfWeek().getValue() > DayOfWeek.FRIDAY.getValue()) {
            throw new RuntimeException("Délai dépassé !");
        }

        Commande commande = new Commande();
        commande.setUser(user);
        commande.setMenu(menu);
        commande.setDateChoix(LocalDate.now());

        return commandeRepository.save(commande);
    }

    public List<Commande> getCommandesByUser(User user) {
        return commandeRepository.findByUser(user);
    }

    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }
}