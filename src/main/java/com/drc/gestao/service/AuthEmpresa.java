package com.drc.gestao.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.drc.gestao.model.dto.EmpresaDTO;
import com.drc.gestao.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthEmpresa {

    @Value("${security.token.secret}")
    private String secretKey;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String execute(EmpresaDTO empresaDTO){
        var empresa = this.empresaRepository.findByUsername(empresaDTO.getUsername()).orElseThrow(
                () -> {
                    throw new UsernameNotFoundException("Empresa nao encontrado");
                });
        // verificar se as senhas sao iguais
        var passwordMatches = this.passwordEncoder.matches(empresaDTO.getPassword(), empresa.getPassword());
        // se nao for igual -> erro
        if (!passwordMatches){
            throw new ArithmeticException();
        }
        // se for igual -> gerar token
        Algorithm algorithm = Algorithm.HMAC256("secretKey");
       var token = JWT.create().withIssuer("denise_empresa_admin").withSubject(empresa.getId().toString())
                .sign(algorithm);
       return token;
    }
}
