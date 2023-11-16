package com.drc.gestao.repository;

import com.drc.gestao.model.entitys.VagaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VagaRepository extends JpaRepository<VagaEntity, UUID> {
}
