package com.BehindTheLyrics.BTL.Controllers.model.band;

public class Banda {

    private String nome, lore;
    private int id;

    public Banda(){

    }

    public Banda(String nome, String lore){
        this.nome = nome;
        this.lore = lore;
    }

        public Banda(String nome, String lore, int id){
        this.nome = nome;
        this.lore = lore;
        this.id = id;
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

}
