package com.BehindTheLyrics.BTL.Controllers.model.band;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Banda {

    private String nome, lore, imagem_url;
    private int id;

    public Banda(){

    }

    public Banda(String nome, String loren, String imagem_url){
        this.nome = nome;
        this.lore = lore;
        this.imagem_url = imagem_url;
    }

        public Banda(String nome, String lore,String imagem_url, int id){
        this.nome = nome;
        this.lore = lore;
        this.imagem_url = imagem_url;
        this.id = id;
    }

    public String getImagem_url(){
        return imagem_url;
    }

    public void setImagem_url(String imagem_url){
        this.imagem_url = imagem_url;
    }

    public String getNome() {
            return nome;
    }

    public String getLore() {
            return lore;
    }

    public int getId() {
            return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLore(String lore) {
        this.lore = lore;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static Banda converterUmaBanda(Map<String,Object> registro){
        int id = (Integer) registro.get("id");
        String nome = (String) registro.get("nome");
        String lore = (String) registro.get("lore");
        String imagem_url = (String) registro.get("imagem_url");
        Banda band = new Banda(nome,lore,imagem_url, id);
        return band;
    }

    public static List<Banda> converterNBandas(List<Map<String,Object>> registros){
        List<Banda> aux = new ArrayList<Banda>();
        for(Map<String,Object> reg : registros){
            aux.add(converterUmaBanda(reg));
        }
        return aux;
    }

}
