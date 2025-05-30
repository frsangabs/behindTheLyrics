package com.BehindTheLyrics.BTL.Controllers.model.band;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BandaService {

    @Autowired //cria a bagaca pra mim!
    BandaDAO cdao;

    public void adicionarBanda(Banda band){
        cdao.adicionarBanda(band);
    }

}
