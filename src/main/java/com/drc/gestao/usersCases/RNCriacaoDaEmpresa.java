package com.drc.gestao.usersCases;

import com.drc.gestao.exception.UserFoundException;
import com.drc.gestao.model.entitys.EmpresaEntity;
import com.drc.gestao.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RNCriacaoDaEmpresa {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public EmpresaEntity execute(EmpresaEntity empresaEntity){
        this.empresaRepository
                .findByUsernameOrEmail(empresaEntity.getUsername(), empresaEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });
        var password = passwordEncoder.encode(empresaEntity.getPassword());
        empresaEntity.setPassword(password);

        return this.empresaRepository.save(empresaEntity);
    }
}
