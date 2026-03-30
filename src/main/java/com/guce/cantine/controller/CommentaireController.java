package com.guce.cantine.controller;

import com.guce.cantine.entity.Commentaire;
import com.guce.cantine.service.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/commentaires")
@CrossOrigin("*")
public class CommentaireController {

    @Autowired
    private CommentaireService commentaireService;

    @PostMapping
    public Commentaire add(@RequestBody Commentaire commentaire) {
        return commentaireService.ajouterCommentaire(commentaire);
    }
}