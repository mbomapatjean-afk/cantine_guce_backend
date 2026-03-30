package com.guce.cantine.controller;

import com.guce.cantine.dto.CommandeDTO;
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
    public Commande choisirMenu(@RequestParam Long userId,
                                @RequestParam Long menuId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User "+userId+" introuvable"));

        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new RuntimeException("Menu "+menuId+" introuvable"));

        return commandeService.choisirMenu(user, menu);
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