package com.guce.cantine.controller;

import com.guce.cantine.dto.CommandeRequest;
import com.guce.cantine.entity.Commande;
import com.guce.cantine.entity.Menu;
import com.guce.cantine.entity.User;
import com.guce.cantine.repository.MenuRepository;
import com.guce.cantine.repository.UserRepository;
import com.guce.cantine.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commandes")
@CrossOrigin("*")
public class CommandeController {

    @Autowired
    private CommandeService commandeService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MenuRepository menuRepository;

    @PostMapping
    public Commande create(@RequestBody CommandeRequest req) {

        User user = userRepository.findById(req.getUserId())
                .orElseThrow();

        Menu menu = menuRepository.findById(req.getMenuId())
                .orElseThrow();

        return commandeService.create(user, menu);
    }

    @GetMapping("/user/{id}")
    public List<Commande> getByUser(@PathVariable Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User "+id+" introuvable"));

        return commandeService.getCommandesByUser(user);
    }

    @GetMapping
    public List<Commande> getAllCommandes() {
        return commandeService.getAllCommandes();
    }
}