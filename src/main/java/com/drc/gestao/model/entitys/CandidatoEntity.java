package com.drc.gestao.model.entitys;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;
@Data
@Entity(name = "candidato")
public class CandidatoEntity {

    private UUID id;
    private String nome;

    @NotBlank()
    @Pattern(regexp = "\\S+", message = "O campo [username] não deve conter espaço.")
    private String username;

    @Email(message = "O campo [email] deve conter um e-mail válido.")
    private String email;

    @Length(min = 4, max = 8, message = "A [senha] deve conter entre 4 a 8 caracteres.")
    private String password;
    private String descricao;
    private String curriculo;
}

