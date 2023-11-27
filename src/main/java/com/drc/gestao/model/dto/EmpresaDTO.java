package com.drc.gestao.model.dto;

// classe onde a gnt cons
// egue passar um argumento de uma classe pra outra, so com informações que preciso

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmpresaDTO {

    private String username;
    private String password;
}
