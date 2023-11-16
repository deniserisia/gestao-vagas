package com.drc.gestao.repository;

import com.drc.gestao.model.entitys.CandidatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CandidatoRepository extends JpaRepository<CandidatoEntity, UUID> {
    // Buscar o email e o username - unicos
    Optional<CandidatoEntity> findByUsernameOrEmail(String username, String email);
}
