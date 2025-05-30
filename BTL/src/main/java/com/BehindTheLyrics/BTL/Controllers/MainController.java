package com.BehindTheLyrics.BTL.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.BehindTheLyrics.BTL.Controllers.model.band.Banda;
import com.BehindTheLyrics.BTL.Controllers.model.band.BandaService;

/**
 *
 * @author Santos
 */

@Controller
public class MainController {

    @Autowired
    private ApplicationContext context;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/sucesso")
    public String sucesso(){
        return "sucesso";
    }

    @GetMapping("/bandas")
    public String bandas(){
        return "bandas";
    }

    @GetMapping("/musicas")
    public String musicas(){
        return "musicas";
    }

    @GetMapping("/addband")
    public String addmsc(Model model){
        model.addAttribute("bandas", new Banda());
        return "addband";
    }

    @PostMapping("/addband")
    public String adicionarBanda(Model model, @ModelAttribute Banda band){
        BandaService cs = context.getBean(BandaService.class);
        cs.adicionarBanda(band);
            return
            "redirect:sucesso";
    }
}
