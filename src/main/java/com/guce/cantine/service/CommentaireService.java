package com.guce.cantine.service;
import com.guce.cantine.entity.Commentaire;
import com.guce.cantine.entity.User;
import com.guce.cantine.repository.CommentaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentaireService {

    @Autowired
    private CommentaireRepository commentaireRepository;

    public Commentaire ajouterCommentaire(Commentaire commentaire) {
        return commentaireRepository.save(commentaire);
    }

    public List<Commentaire> getCommentairesByUser(User user) {
        return commentaireRepository.findByUser(user);
    }
}