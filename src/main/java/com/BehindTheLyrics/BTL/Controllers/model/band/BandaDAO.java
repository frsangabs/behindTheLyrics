package com.BehindTheLyrics.BTL.Controllers.model.band;

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
        String sql = "INSERT INTO bandas(nome, lore) VALUES(?, ?)";
        Object[] parametros = new Object[2];
        parametros[0] = band.getNome();
        parametros[1] = band.getLore();
        jdbc.update(sql, parametros);
    }

}
