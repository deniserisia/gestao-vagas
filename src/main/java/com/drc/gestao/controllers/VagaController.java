package com.drc.gestao.controllers;

import com.drc.gestao.model.entitys.EmpresaEntity;
import com.drc.gestao.model.entitys.VagaEntity;
import com.drc.gestao.usersCases.RNCriacaoDaVaga;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vaga")
public class VagaController {

    @Autowired
    private RNCriacaoDaVaga rnCriacaoDaVaga;

    @PostMapping("/cadastrar")
    public VagaEntity create(@Valid @RequestBody VagaEntity vagaEntity) {
       return this.rnCriacaoDaVaga.execute(vagaEntity);
    }
}
