package com.BehindTheLyrics.BTL.Controllers.model.msc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Musicas {

    private int id, ano_lancamento;
    private String titulo, loreMsc, nomeBanda, nomeAlbum;
    private Integer id_banda, id_album;

    public Musicas(){

    }

    public Musicas( int ano_lancamento, String titulo, String loreMsc, Integer id_banda, Integer id_album){
        this.ano_lancamento = ano_lancamento;
        this.titulo = titulo;
        this.loreMsc = loreMsc;
        this.id_banda = id_banda;
        this.id_album = id_album;
    }

        public Musicas(int id, int ano_lancamento, String titulo, String loreMsc, Integer id_banda, Integer id_album){
        this.id = id;
        this.ano_lancamento = ano_lancamento;
        this.titulo = titulo;
        this.loreMsc = loreMsc;
        this.id_banda = id_banda;
        this.id_album = id_album;
    }

        public Integer getId_album() {
        return id_album;
        }

        public void setId_album(Integer id_album) {
        this.id_album = id_album;
        }

        public Integer getId_banda() {
        return id_banda;
        }

        public void setId_banda(int id_banda) {
        this.id_banda = id_banda;
        }

        public String getNomeBanda() {
        return nomeBanda;
        }

        public void setNomeBanda(String nomeBanda) {
        this.nomeBanda = nomeBanda;
        }

        public String getNomeAlbum() {
        return nomeAlbum;
        }

        public void setNomeAlbum(String nomeAlbum) {
        this.nomeAlbum = nomeAlbum;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public int getAno_lancamento() {
            return ano_lancamento;
        }

        public void setAno_lancamento(int ano_lancamento) {
            this.ano_lancamento = ano_lancamento;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getLoreMsc() {
            return loreMsc;
        }

        public void setLoreMsc(String loreMsc) {
            this.loreMsc = loreMsc;
        }



        public static Musicas converterUmaMusica(Map<String,Object> registro){
            int id = (Integer) registro.get("id");
            String titulo = (String) registro.get("titulo");
            int ano_lancamento = (Integer) registro.get("ano_lancamento");
            String loreMsc = (String) registro.get("loreMsc");
            Integer id_banda =  (Integer) registro.get("id_banda");
            String nome_banda = (String) registro.get("nome_banda");
            Integer id_album = (Integer) registro.get("id_album");
            String nome_album = (String) registro.get("nome_album");
            Musicas msc = new Musicas(id, ano_lancamento, titulo, loreMsc, id_banda, id_album);
            msc.setNomeBanda(nome_banda);
            msc.setNomeAlbum(nome_album);
            return msc;
        }

        public static List<Musicas>converterNMusicas(List<Map<String,Object>>registros){
            List<Musicas> aux = new ArrayList<Musicas>();
            for(Map<String,Object> reg: registros){
                aux.add(converterUmaMusica(reg));
            }
            return aux;
        }

    

    
}
