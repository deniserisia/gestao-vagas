package com.drc.gestao.controllers;


import com.drc.gestao.exception.UserFoundException;
import com.drc.gestao.model.entitys.CandidatoEntity;
import com.drc.gestao.repository.CandidatoRepository;
import com.drc.gestao.usersCases.RNCriacaoDoCandidato;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidato")
public class CandidatoController {

    @Autowired
    private RNCriacaoDoCandidato rnCriacaoDoCandidato;
    @PostMapping("/cadastrar")
    public ResponseEntity<Object> create(@Valid @RequestBody CandidatoEntity candidatoEntity){
       try {
          var result = this.rnCriacaoDoCandidato.execute(candidatoEntity);
          return ResponseEntity.ok().body(result);
       } catch (Exception e){
           return ResponseEntity.badRequest().body(e.getMessage());
       }
    }
}
