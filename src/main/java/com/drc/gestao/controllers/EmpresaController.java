package com.drc.gestao.controllers;

import com.drc.gestao.model.entitys.CandidatoEntity;
import com.drc.gestao.model.entitys.EmpresaEntity;
import com.drc.gestao.usersCases.RNCriacaoDaEmpresa;
import com.drc.gestao.usersCases.RNCriacaoDoCandidato;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    // camada de serviço - RN
    @Autowired
    private RNCriacaoDaEmpresa rnCriacaoDaEmpresa;

    @PostMapping("/cadastrar")
    public ResponseEntity<Object> create(@Valid @RequestBody EmpresaEntity empresaEntity){
        try {
            var result = this.rnCriacaoDaEmpresa.execute(empresaEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
