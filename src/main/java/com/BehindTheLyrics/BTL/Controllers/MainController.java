package com.BehindTheLyrics.BTL.Controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.BehindTheLyrics.BTL.Controllers.model.album.AlbumService;
import com.BehindTheLyrics.BTL.Controllers.model.album.Albuns;
import com.BehindTheLyrics.BTL.Controllers.model.band.Banda;
import com.BehindTheLyrics.BTL.Controllers.model.band.BandaService;
import com.BehindTheLyrics.BTL.Controllers.model.msc.MusicaService;
import com.BehindTheLyrics.BTL.Controllers.model.msc.Musicas;

/**
 *
 * @author Santos
 */

@Controller
public class MainController {

    @Autowired
    private ApplicationContext context;

    @GetMapping("/")
    public String index(Model model){
        BandaService bs = context.getBean(BandaService.class);
        List<Map<String, Object>> lb = bs.puxarTop3Bandas();
        List<Banda> bc = Banda.converterNBandas(lb);
        model.addAttribute("bandas", bc);

        MusicaService ms = context.getBean(MusicaService.class);
        List<Map<String, Object>> lm = ms.puxar5Musicas();
        List<Musicas> mc = Musicas.converterNMusicas(lm);
        model.addAttribute("musicas", mc);
        return "index";
    }

    @GetMapping("/sucesso")
    public String sucesso(){
        return "sucesso";
    }

    @GetMapping("/musicas")
    public String musicas(@RequestParam(required = false) Integer bandaId, Model model){
    MusicaService ms = context.getBean(MusicaService.class);
    BandaService bs = context.getBean(BandaService.class);

    List<Map<String,Object>> lm;

    if (bandaId != null) {
        lm = ms.puxarMusicasPorBanda(bandaId);
    } else {
        lm = ms.puxarTodasMusicas();
    }

    List<Musicas> mc = Musicas.converterNMusicas(lm);
    model.addAttribute("musicas", mc);
    model.addAttribute("bandaSelecionada", bandaId);
    model.addAttribute("bandas", bs.puxarTodasBandas());

    return "musicas";
    }

    // @GetMapping("/musicas")
    // public String musicas(Model model){
    //     MusicaService ms = context.getBean(MusicaService.class);
    //     List<Map<String,Object>>lm = ms.puxarTodasMusicas();
    //     List<Musicas> mc = Musicas.converterNMusicas(lm);
    //     model.addAttribute("musicas", mc);
    //     return "musicas";
    // }

    @GetMapping("/addmsc")
        public String addmsc(Model model){
        model.addAttribute("musicas", new Musicas());
        model.addAttribute("link", "/addmsc");
        model.addAttribute("nomePag", "ADICIONAR MÚSICA");
        model.addAttribute("valorBtn", "Adicionar");
        BandaService bs = context.getBean(BandaService.class);
        List<Map<String,Object>> lb = bs.puxarTodasBandas();
        List<Banda> bandas = Banda.converterNBandas(lb);
        model.addAttribute("bandas", bandas);
        AlbumService as = context.getBean(AlbumService.class);
        List<Map<String,Object>> la = as.puxarTodosAlbuns();
        model.addAttribute("albuns", Albuns.converterNAlbuns(la));
        return "addmsc";
    }

    @PostMapping("/addmsc")
    public String adicionarMusica(Model model, @ModelAttribute Musicas msc){
        MusicaService ms = context.getBean(MusicaService.class);
        ms.adicionarMusica(msc);
            return
            "redirect:sucesso";
    }

    @GetMapping("/musicas/{id}")
    public String detalhesMusica(@PathVariable int id, Model model){
        MusicaService ms = context.getBean(MusicaService.class);
        Map<String, Object> reg = ms.puxarMusicaComImagens(id);
        Musicas musicas = Musicas.converterUmaMusica(reg);
        model.addAttribute("musicas", musicas);
        model.addAttribute("nome_banda", reg.get("nome_banda"));
        model.addAttribute("imagem_banda", reg.get("imagem_banda"));
        model.addAttribute("nome_album", reg.get("nome_album"));
        model.addAttribute("imagem_album", reg.get("imagem_album"));
        return "detalheMusicas";
    }

    @GetMapping("/musicas/editar/{id}")
    public String editarMusica(Model model, @PathVariable int id){
        MusicaService ms = context.getBean(MusicaService.class);
        Map<String,Object> reg = ms.puxarMusica(id);
        Musicas msc = Musicas.converterUmaMusica(reg);
        model.addAttribute("musicas", msc);
        model.addAttribute("link", "/musicas/editar/" + id);
        model.addAttribute("nomePag", "EDITAR MÚSICAS");
        model.addAttribute("valorBtn", "Atualizar");
        BandaService bs = context.getBean(BandaService.class);
        List<Map<String,Object>> lb = bs.puxarTodasBandas();
        List<Banda> bandas = Banda.converterNBandas(lb);
        AlbumService as = context.getBean(AlbumService.class);
        List<Map<String,Object>> la = as.puxarTodosAlbuns();
        List<Albuns> albuns = Albuns.converterNAlbuns(la);
        model.addAttribute("albuns", albuns);
        model.addAttribute("bandas", bandas);
        return "addmsc";
    }


    @PostMapping("/musicas/editar/{id}")
    public String editarMusica(@ModelAttribute Musicas msc, @PathVariable int id){
        MusicaService ms = context.getBean(MusicaService.class);
        ms.atualizarMusica(msc, id);
        return "redirect:/musicas";
    }

    @PostMapping("/musicas/deletar/{id}")
    public String deletar(@PathVariable int id){
        MusicaService ms = context.getBean(MusicaService.class);
        ms.deletar(id);
        return "redirect:/musicas";
    }

    @GetMapping("/bandas")
    public String bandas(Model model){
        BandaService bs = context.getBean(BandaService.class);
        List<Map<String,Object>>lb = bs.puxarTodasBandas();
        List<Banda> bc = Banda.converterNBandas(lb);
        model.addAttribute("bandas", bc);
        return "bandas";
    }

    @GetMapping("/bandas/{id}")
    public String detalhesBanda(@PathVariable int id, Model model) {
        BandaService bs = context.getBean(BandaService.class);
        Map<String, Object> reg = bs.puxarBanda(id);
        Banda banda = Banda.converterUmaBanda(reg);
        model.addAttribute("banda", banda);


        AlbumService as = context.getBean(AlbumService.class);
        List<Map<String, Object>> la = as.puxarAlbunsPorBanda(id);
        List<Albuns> albuns = Albuns.converterNAlbuns(la);
        model.addAttribute("albuns", albuns);

        MusicaService ms = context.getBean(MusicaService.class);
        List<Map<String, Object>> lm = ms.puxarMusicasPorBanda(id);
        List<Musicas> musicas = Musicas.converterNMusicas(lm);
        model.addAttribute("musicas", musicas);
        return "detalheBandas";
    }

    @GetMapping("/addband")
    public String addband(Model model){
        model.addAttribute("banda", new Banda());
        model.addAttribute("link", "/addband");
        model.addAttribute("nomePag", "ADICIONAR BANDA");
        model.addAttribute("valorBtn", "Adicionar");
        BandaService bs = context.getBean(BandaService.class);
        List<Map<String,Object>> lb = bs.puxarTodasBandas();
        List<Banda> bandas = Banda.converterNBandas(lb);
        model.addAttribute("bandas", bandas);

        return "addband";
    }

    @PostMapping("/addband")
    public String adicionarBanda(Model model, @ModelAttribute Banda band){
        BandaService bs = context.getBean(BandaService.class);
        bs.adicionarBanda(band);
            return
            "redirect:sucesso";
    }

    @GetMapping("/bandas/editar/{id}")
    public String editarBanda(Model model, @PathVariable int id){
        BandaService bs = context.getBean(BandaService.class);
        Map<String,Object> reg = bs.puxarBanda(id);
        Banda band = Banda.converterUmaBanda(reg);
        model.addAttribute("banda", band);
        model.addAttribute("link", "/bandas/editar/" + id);
        model.addAttribute("nomePag", "EDITAR BANDAS");
        model.addAttribute("valorBtn", "Atualizar");
        return "addband";
    }

    @PostMapping("/bandas/editar/{id}")
    public String editarBanda(@ModelAttribute Banda band, @PathVariable int id){
        BandaService bs = context.getBean(BandaService.class);
        bs.atualizarBanda(band, id);
        return "redirect:/bandas";
    }

    @PostMapping("/bandas/deletar/{id}")
    public String deletarBanda(@PathVariable int id){
        BandaService bs = context.getBean(BandaService.class);
        bs.deletar(id);
        return "redirect:/bandas";
    }

    @GetMapping("/albuns")
    public String albuns(Model model){
        AlbumService as = context.getBean(AlbumService.class);
        List<Map<String,Object>>la = as.puxarTodosAlbuns();
        List<Albuns> ac = Albuns.converterNAlbuns(la);
        model.addAttribute("albuns", ac);
        return "albuns";
    }

    @GetMapping("/addalbum")
    public String addalbum(Model model){
    AlbumService as = context.getBean(AlbumService.class);
    BandaService bs = context.getBean(BandaService.class);
    model.addAttribute("albuns", new Albuns());
    List<Map<String, Object>> lb = bs.puxarTodasBandas();
    List<Banda> bandas = Banda.converterNBandas(lb);
    model.addAttribute("bandas", bandas);
    model.addAttribute("nomePag", "ADICIONAR ÁLBUM");
    model.addAttribute("link", "/addalbum");
    model.addAttribute("valorBtn", "Adicionar Álbum");
    return "addalbum";
    }

    @PostMapping("/addalbum")
    public String adicionarAlbum(Model model, @ModelAttribute Albuns album){
    AlbumService as = context.getBean(AlbumService.class);
    as.adicionarAlbum(album);
    return "redirect:sucesso";
    }

    @GetMapping("/albuns/{id}")
    public String detalhesAlbum(@PathVariable int id, Model model) {
    AlbumService as = context.getBean(AlbumService.class);
    Map<String, Object> reg = as.puxarAlbum(id);
    Albuns album = Albuns.converterUmAlbum(reg);
    model.addAttribute("album", album);

    BandaService bs = context.getBean(BandaService.class);
    Map<String, Object> regBanda = bs.puxarBanda(album.getId_banda());
    Banda banda = Banda.converterUmaBanda(regBanda);
    model.addAttribute("banda", banda);

    MusicaService ms = context.getBean(MusicaService.class);
    List<Map<String, Object>> lm = ms.puxarMusicasPorAlbum(id);
    List<Musicas> musicas = Musicas.converterNMusicas(lm);
    model.addAttribute("musicas", musicas);

    return "detalheAlbuns";
}


    @GetMapping("/albuns/editar/{id}")
    public String editarAlbuns(Model model, @PathVariable int id){
        AlbumService as = context.getBean(AlbumService.class);
        Map<String,Object> reg = as.puxarAlbum(id);
        Albuns alb = Albuns.converterUmAlbum(reg);
        model.addAttribute("albuns", alb);
        model.addAttribute("link", "/albuns/editar/" + id);
        model.addAttribute("nomePag", "EDITAR ALBUM");
        model.addAttribute("valorBtn", "Atualizar");
        BandaService bs = context.getBean(BandaService.class);
        List<Map<String,Object>> lb = bs.puxarTodasBandas();
        List<Banda> bandas = Banda.converterNBandas(lb);
        model.addAttribute("bandas", bandas);
        return "addalbum";
    }

    @PostMapping("/albuns/editar/{id}")
    public String editarAlbum(@ModelAttribute Albuns alb, @PathVariable int id){
        AlbumService as = context.getBean(AlbumService.class);
        as.atualizarAlbum(alb, id);
        return "redirect:/albuns";
    }

    @PostMapping("/albuns/deletar/{id}")
    public String deletarAlbum(@PathVariable int id){
        AlbumService as = context.getBean(AlbumService.class);
        as.deletar(id);
        return "redirect:/albuns";
    }
}
