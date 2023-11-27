package com.drc.gestao.controllers;

import com.drc.gestao.model.dto.EmpresaDTO;
import com.drc.gestao.service.AuthEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.sasl.AuthenticationException;

@RestController
@RequestMapping("/auth")
public class AuthEmpresaController {

    @Autowired
    private AuthEmpresa authEmpresa;

    @PostMapping("/empresa")
    public ResponseEntity<Object> create(@RequestBody EmpresaDTO empresaDTO){
        try {
            var result = this.authEmpresa.execute(empresaDTO);
            return ResponseEntity.ok().body(result);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
