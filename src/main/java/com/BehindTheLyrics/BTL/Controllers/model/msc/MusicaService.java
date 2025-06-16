package com.BehindTheLyrics.BTL.Controllers.model.msc;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicaService {

    @Autowired
    MusicaDAO mdao;

    public void adicionarMusica(Musicas msc){
        mdao.adicionarMusica(msc);
    }

    public List<Map<String,Object>> puxarTodasMusicas(){
        return mdao.puxarTodasMusicas();
    }

    public Map<String,Object>puxarMusica(int id){
        return mdao.puxarMusica(id);
    }

    public List<Map<String, Object>> puxarMusicasPorBanda(int id) {
    return mdao.puxarMusicasPorBanda(id); 
    }

    public List<Map<String, Object>> puxarMusicasPorAlbum(int id){
        return mdao.puxarMusicasPorAlbum(id);
    }

    public List<Map<String, Object>> puxar5Musicas(){
        return mdao.puxar5Musicas();
    }

    public Map<String , Object> puxarMusicaComImagens(int id){
        return mdao.puxarMusicaComImagens(id);
    }

    public void atualizarMusica(Musicas msc, int id){
        mdao.atualizarMusica(msc, id);
    }

    public void deletar(int id){
        mdao.deletar(id);
    }
    

}
