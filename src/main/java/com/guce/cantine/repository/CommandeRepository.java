package com.guce.cantine.repository;

import com.guce.cantine.entity.Commande;
import com.guce.cantine.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {
    List<Commande> findByUser(User user);
}
