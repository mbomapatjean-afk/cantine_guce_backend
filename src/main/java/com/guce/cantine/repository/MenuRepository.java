package com.guce.cantine.repository;

import com.guce.cantine.entity.Menu;
import com.guce.cantine.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<Menu> findByPrestataire(User prestataire);
    List<Menu> findByDateDebutSemaine(LocalDate date);
}
