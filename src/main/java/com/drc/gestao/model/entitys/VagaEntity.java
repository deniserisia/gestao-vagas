package com.drc.gestao.model.entitys;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity(name = "vaga")
public class VagaEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String descricao;
    private String nivel;
    private String beneficios;

    // muitas vagas para 1 empresa
    @ManyToOne()
    @JoinColumn(name = "empresa_id", insertable = false, updatable = false)
    private EmpresaEntity empresaEntity;

    @Column(name = "empresa_id", nullable = false)
    private UUID empresaId;

    @CreationTimestamp
    private LocalDateTime dataDaCriacao;
}
