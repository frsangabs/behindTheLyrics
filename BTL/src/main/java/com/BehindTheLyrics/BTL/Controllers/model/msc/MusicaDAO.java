package com.BehindTheLyrics.BTL.Controllers.model.msc;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class MusicaDAO {

    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize(){
        jdbc = new JdbcTemplate(dataSource);
    }

    public void adicionarMusica(Musicas msc){
        String sql = "INSERT INTO musicas(titulo,ano_lancamento, loreMsc, id_banda, id_album) VALUES (?, ?, ?, ?, ?)";
        Object[] parametros = new Object[5];
        parametros[0] = msc.getTitulo();
        parametros[1] = msc.getAno_lancamento();
        parametros[2] = msc.getLoreMsc();
        parametros[3] = msc.getId_banda();
        parametros[4] = msc.getId_album();
        jdbc.update(sql, parametros);
    }

    public List<Map<String,Object>>puxarTodasMusicas(){
        String sql = """
        SELECT m.*, 
           b.nome AS nome_banda,
           a.nome AS nome_album
            FROM musicas m
            JOIN bandas b ON m.id_banda = b.id
            LEFT JOIN albuns a ON m.id_album = a.id;
        """;
        return jdbc.queryForList(sql);
    }
    

    public List<Map<String, Object>> puxarMusicasPorBanda(int id) {
    String sql = """
        SELECT m.*, 
               b.nome AS nome_banda,
               a.nome AS nome_album
          FROM musicas m
          JOIN bandas b ON m.id_banda = b.id
          LEFT JOIN albuns a ON m.id_album = a.id
         WHERE m.id_banda = ?;
    """;
    return jdbc.queryForList(sql, id);
    }

    public List<Map<String, Object>> puxarMusicasPorAlbum(int id) {
    String sql = """
        SELECT m.*, 
               b.nome AS nome_banda,
               a.nome AS nome_album
          FROM musicas m
          JOIN bandas b ON m.id_banda = b.id
          LEFT JOIN albuns a ON m.id_album = a.id
         WHERE m.id_album = ?;
    """;
    return jdbc.queryForList(sql, id);
    }

    public List<Map<String, Object>> puxar5Musicas() {
    String sql = """
        SELECT * FROM musicas
        ORDER BY id DESC
        LIMIT 5;
    """;
    return jdbc.queryForList(sql);
    }

    public Map<String,Object>puxarMusica(int id){
        String sql = "SELECT * FROM musicas WHERE id = ?;";
        return jdbc.queryForMap(sql, id);
    }

    public Map<String,Object> puxarMusicaComImagens(int id){
    String sql = """
        SELECT m.*, 
               b.nome AS nome_banda,
               b.imagem_url AS imagem_banda,
               a.nome AS nome_album,
               a.imagem_url AS imagem_album
          FROM musicas m
          JOIN bandas b ON m.id_banda = b.id
          LEFT JOIN albuns a ON m.id_album = a.id
         WHERE m.id = ?;
        """;
        return jdbc.queryForMap(sql, id);
}

    public void deletar(int id){
        String sql = "DELETE FROM musicas WHERE id = ?;";
        jdbc.update(sql, id);
    }

    public void atualizarMusica(Musicas msc, int id){
        String sql = "UPDATE musicas SET titulo = ?, ano_lancamento = ?, loreMsc = ?, id_banda = ?, id_album = ? WHERE id = ?";
        Object[] parametros = new Object[6];
        parametros[0] = msc.getTitulo();
        parametros[1] = msc.getAno_lancamento();
        parametros[2] = msc.getLoreMsc();
        parametros[3] = msc.getId_banda();
        parametros[4] = msc.getId_album();
        parametros[5] =id;
        jdbc.update(sql, parametros);
    }
}
