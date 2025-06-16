package com.BehindTheLyrics.BTL.Controllers.model.band;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BandaService {

    @Autowired //cria a bagaca pra mim!
    BandaDAO bdao;

    public void adicionarBanda(Banda band){
        bdao.adicionarBanda(band);
    }

    public List<Map<String,Object>> puxarTodasBandas(){
        return bdao.puxarTodasBandas();
    }

    public Map<String,Object> puxarBanda(int id){
        return bdao.puxarBanda(id);
    }

    public List<Map<String,Object>> puxarTop3Bandas(){
        return bdao.puxarTodasBandas();
    }

    public void atualizarBanda(Banda band,int id){
        bdao.atualizarBanda(band,id);
    }

    public void deletar(int id){
        bdao.deletar(id);
    }

}
