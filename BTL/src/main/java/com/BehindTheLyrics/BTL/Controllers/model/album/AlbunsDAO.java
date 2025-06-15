package com.BehindTheLyrics.BTL.Controllers.model.album;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class AlbunsDAO {

    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize(){
        jdbc = new JdbcTemplate(dataSource);
    }

    public void adicionarAlbum(Albuns album){
        String sql = "INSERT INTO albuns(nome, ano_lancamento, id_banda, imagem_url) VALUES (?, ?, ?, ?)";
        Object[] parametros = new Object[4];
        parametros[0] = album.getNome();
        parametros[1] = album.getAno_lancamento();
        parametros[2] = album.getId_banda();
        parametros[3] = album.getImagem_url();
        jdbc.update(sql, parametros);
    }

    public List<Map<String,Object>> puxarTodosAlbuns(){
        String sql = """
            SELECT albuns.id, albuns.nome, albuns.ano_lancamento, albuns.id_banda, albuns.imagem_url,
                bandas.nome AS nome_banda
                FROM albuns
                JOIN bandas ON albuns.id_banda = bandas.id;
            """;
        return jdbc.queryForList(sql);
    } 

    public Map<String,Object> puxarAlbum(int id){
        String sql = "SELECT * FROM albuns WHERE id = ?;";
        return jdbc.queryForMap(sql, id);
    }

    public List<Map<String, Object>> puxarAlbunsPorBanda(int id) {
    String sql = """
        SELECT albuns.id, albuns.nome, albuns.ano_lancamento, albuns.id_banda, albuns.imagem_url,
               bandas.nome AS nome_banda
          FROM albuns
          JOIN bandas ON albuns.id_banda = bandas.id
         WHERE albuns.id_banda = ?;
    """;
    return jdbc.queryForList(sql, id);
    }

    public void deletar(int id){
        String sql = "DELETE FROM albuns where id = ?;";
        jdbc.update(sql, id);
    }

    public void atualizarAlbum(Albuns alb, int id){
        String sql = "UPDATE albuns SET nome = ?, ano_lancamento = ?, id_banda = ?, imagem_url = ? WHERE id = ?";
        Object[] parametros = new Object[5];
        parametros[0] = alb.getNome();
        parametros[1] = alb.getAno_lancamento();
        parametros[2] = alb.getId_banda();
        parametros[3] = alb.getImagem_url();
        parametros[4] = id;
        jdbc.update(sql, parametros);
    }
}