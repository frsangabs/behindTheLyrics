package com.BehindTheLyrics.BTL.Controllers.model.band;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class BandaDAO {

    @Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
    private void initialize(){
        jdbc = new JdbcTemplate(dataSource);
    }

    public void adicionarBanda(Banda band){
        String sql = "INSERT INTO bandas(nome, lore, imagem_url) VALUES(?, ?, ?)";
        Object[] parametros = new Object[3];
        parametros[0] = band.getNome();
        parametros[1] = band.getLore();
        parametros[2] = band.getImagem_url();
        jdbc.update(sql, parametros);
    }

    public List<Map<String,Object>> puxarTodasBandas(){
        String sql = "SELECT * FROM bandas;";
        return jdbc.queryForList(sql);
    } 

    public Map<String,Object> puxarBanda(int id){
        String sql = "SELECT * FROM bandas WHERE id = ?;";
        return jdbc.queryForMap(sql, id);
    }

    public List<Map<String, Object>> puxarTop3Bandas() {
    String sql = """
        SELECT b.id, b.nome, b.lore, b.imagem_url, COUNT(m.id) AS total_musicas
        FROM bandas b
        LEFT JOIN musicas m ON b.id = m.id_banda
        GROUP BY b.id
        ORDER BY total_musicas DESC
        LIMIT 3;
    """;
    return jdbc.queryForList(sql);
    }

    public void deletar(int id){
        String sql = "DELETE FROM bandas where id = ?;";
        jdbc.update(sql, id);
    }

    public void atualizarBanda(Banda band, int id){
        String sql = "UPDATE bandas SET nome = ?, lore = ?, imagem_url = ? WHERE id = ?";
        Object[] parametros = new Object[4];
        parametros[0] = band.getNome();
        parametros[1] = band.getLore();
        parametros[2] = band.getImagem_url();
        parametros[3] = id;
        jdbc.update(sql, parametros);
    }
}
