package com.example.springbootweb.controller;

import com.example.springbootweb.repository.ItemRepository;
import com.example.springbootweb.service.SupabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @Autowired(required = false)
    private ItemRepository itemRepository;

    @Autowired(required = false)
    private SupabaseService supabaseService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Bienvenido al proyecto web - raíz (/)");
        return "index";
    }

    @GetMapping("/pruebas")
    public String pruebas(Model model) {
        model.addAttribute("title", "Página de pruebas");
        // try to list items from MongoDB if available; otherwise from Supabase
        try {
            if (itemRepository != null) {
                model.addAttribute("items", itemRepository.findAll());
            } else if (supabaseService != null) {
                model.addAttribute("items", supabaseService.listItems());
            } else {
                model.addAttribute("items", java.util.Collections.emptyList());
            }
        } catch (Exception e) {
            model.addAttribute("items", java.util.Collections.emptyList());
            model.addAttribute("error", e.getMessage());
        }
        return "pruebas";
    }
}
