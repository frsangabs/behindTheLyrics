package com.BehindTheLyrics.BTL.Controllers.model.album;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {

    @Autowired
    AlbunsDAO adao;

    public void adicionarAlbum(Albuns album){
        adao.adicionarAlbum(album);
    }

    public List<Map<String,Object>> puxarTodosAlbuns(){
        return adao.puxarTodosAlbuns();
    }

    public Map<String,Object> puxarAlbum(int id){
        return adao.puxarAlbum(id);
    }

    public List<Map<String, Object>> puxarAlbunsPorBanda(int id) {
    return adao.puxarAlbunsPorBanda(id);
    }

    public void atualizarAlbum(Albuns alb,int id){
        adao.atualizarAlbum(alb,id);
    }

    public void deletar(int id){
        adao.deletar(id);
    }

}