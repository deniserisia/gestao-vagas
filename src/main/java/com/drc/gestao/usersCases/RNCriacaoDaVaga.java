package com.drc.gestao.usersCases;

import com.drc.gestao.model.entitys.VagaEntity;
import com.drc.gestao.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RNCriacaoDaVaga {

    @Autowired
    private VagaRepository vagaRepository;

    public VagaEntity execute(VagaEntity vagaEntity){
        return this.vagaRepository.save(vagaEntity);
    }
}
