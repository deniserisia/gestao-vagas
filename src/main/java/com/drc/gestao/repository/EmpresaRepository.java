package com.drc.gestao.repository;

import com.drc.gestao.model.entitys.EmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.rmi.server.UID;
import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<EmpresaEntity, UID> {

    Optional<EmpresaEntity> findByUsernameOrEmail(String username, String email);
}
