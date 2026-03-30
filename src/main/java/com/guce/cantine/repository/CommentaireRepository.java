package com.guce.cantine.repository;

import com.guce.cantine.entity.Commentaire;
import com.guce.cantine.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {
    List<Commentaire> findByUser(User user);
}
