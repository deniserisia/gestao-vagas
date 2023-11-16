package com.drc.gestao.usersCases;

import com.drc.gestao.exception.UserFoundException;
import com.drc.gestao.model.entitys.EmpresaEntity;
import com.drc.gestao.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RNCriacaoDaEmpresa {

    @Autowired
    private EmpresaRepository empresaRepository;

    public EmpresaEntity execute(EmpresaEntity empresaEntity){
        this.empresaRepository
                .findByUsernameOrEmail(empresaEntity.getUsername(), empresaEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });
        return this.empresaRepository.save(empresaEntity);
    }
}
