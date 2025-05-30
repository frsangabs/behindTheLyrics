package com.BehindTheLyrics.BTL.Controllers.model.msc;

public class Musicas {

    private int id, id_banda, id_album, ano_lancamento;
    private String titulo;

    public Musicas(){

    }

    public Musicas(int id_banda, int id_album, int ano_lancamento, String titulo){
        this.id_banda = id_banda;
        this.id_album = id_album;
        this.ano_lancamento = ano_lancamento;
        this.titulo = titulo;
    }

        public Musicas(int id,int id_banda, int id_album, int ano_lancamento, String titulo){
        this.id = id;
        this.id_banda = id_banda;
        this.id_album = id_album;
        this.ano_lancamento = ano_lancamento;
        this.titulo = titulo;
    }

        public int getId() {
            return id;
        }

        public int getId_banda() {
            return id_banda;
        }

        public int getId_album() {
            return id_album;
        }

        public int getAno_lancamento() {
            return ano_lancamento;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setId_banda(int id_banda) {
            this.id_banda = id_banda;
        }

        public void setId_album(int id_album) {
            this.id_album = id_album;
        }

        public void setAno_lancamento(int ano_lancamento) {
            this.ano_lancamento = ano_lancamento;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

}
