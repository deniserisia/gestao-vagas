package com.drc.gestao.usersCases;

import com.drc.gestao.exception.UserFoundException;
import com.drc.gestao.model.entitys.CandidatoEntity;
import com.drc.gestao.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RNCriacaoDoCandidato {
// Camada de Negocios - Service

    @Autowired
    private CandidatoRepository candidatoRepository;

    public CandidatoEntity execute(CandidatoEntity candidatoEntity) {
        this.candidatoRepository
                .findByUsernameOrEmail(candidatoEntity.getUsername(), candidatoEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });
        return this.candidatoRepository.save(candidatoEntity);
    }
}
