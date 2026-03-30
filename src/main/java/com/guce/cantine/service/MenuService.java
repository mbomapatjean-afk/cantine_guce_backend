package com.guce.cantine.service;

import com.guce.cantine.entity.Menu;
import com.guce.cantine.entity.User;
import com.guce.cantine.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public Menu createMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    public List<Menu> getMenusSemaine(LocalDate dateDebutSemaine) {
        return menuRepository.findByDateDebutSemaine(dateDebutSemaine);
    }

    public List<Menu> getMenusByPrestataire(User prestataire) {
        return menuRepository.findByPrestataire(prestataire);
    }
}
