package com.guce.cantine.controller;

import com.guce.cantine.entity.Menu;
import com.guce.cantine.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/menus")
@CrossOrigin("*")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping
    public Menu create(@RequestBody Menu menu) {
        return menuService.createMenu(menu);
    }

    @GetMapping
    public List<Menu>  getAllMenus() {
        return menuService.getAllMenus();
    }

    @GetMapping("/semaine")
    public List<Menu> getBySemaine(@RequestParam String date) {
        return menuService.getMenusSemaine(LocalDate.parse(date));
    }
}