package com.BehindTheLyrics.BTL.Controllers.model.album;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Albuns {

    private int id, ano_lancamento;
    private String nome, nome_banda, imagem_url;
    private Integer id_banda;

    public Albuns() {
    }

    public Albuns(String nome, int ano_lancamento, Integer id_banda, String imagem_url) {
        this.nome = nome;
        this.ano_lancamento = ano_lancamento;
        this.id_banda = id_banda;
        this.imagem_url = imagem_url;
    }

    public Albuns(int id, String nome, int ano_lancamento, Integer id_banda,String imagem_url) {
        this.id = id;
        this.nome = nome;
        this.ano_lancamento = ano_lancamento;
        this.id_banda = id_banda;
        this.imagem_url = imagem_url;
    }

    public String getImagem_url(){
        return imagem_url;
    }

    public void setImagem_url(String imagem_url){
        this.imagem_url = imagem_url;
    }

    public Integer getId_banda(){
        return id_banda;
    }

    public void setId_banda(Integer id_banda){
        this.id_banda = id_banda;
    }

    public String getNome_banda(){
        return nome_banda;
    }

    public void setNome_banda(String nome_banda){
        this.nome_banda = nome_banda;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getAno_lancamento() {
        return ano_lancamento;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAno_lancamento(int ano_lancamento) {
        this.ano_lancamento = ano_lancamento;
    }

    public static Albuns converterUmAlbum(Map<String,Object> registro){
        int id = (Integer) registro.get("id");
        String nome = (String) registro.get("nome");
        int ano_lancamento = (int) registro.get("ano_lancamento");
        Integer id_banda = (Integer) registro.get("id_banda");
        String nome_banda = (String) registro.get("nome_banda");
        String imagem_url = (String) registro.get("imagem_url");
        Albuns alb = new Albuns(id, nome ,ano_lancamento, id_banda, imagem_url);
        alb.setNome_banda(nome_banda);
        return alb;
    }

    public static List<Albuns> converterNAlbuns(List<Map<String,Object>> registros){
        List<Albuns> aux = new ArrayList<Albuns>();
        for(Map<String,Object> reg : registros){
            aux.add(converterUmAlbum(reg));
        }
        return aux;
    }

}
