package br.com.gerenciador.moneyger.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerenciador.moneyger.model.dto.TokenDTO;
import br.com.gerenciador.moneyger.model.form.LoginForm;
import br.com.gerenciador.moneyger.services.TokenServiceImpl;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenServiceImpl tokenService;

    @PostMapping
    public ResponseEntity<?> autenticar(@RequestBody @Valid LoginForm form) {

        UsernamePasswordAuthenticationToken dadosLogin = form.converter();

        //chama a classe SecuriryConfiguration para chamar o service responsavel pelo login do usuário, retorna um objeto do tipo Authentication que comntém as informações do usuário logado
        Authentication authentication = authenticationManager.authenticate(dadosLogin);

        String token = tokenService.gerarToken(authentication);

        return ResponseEntity.status(HttpStatus.OK).body(new TokenDTO(token, "Bearer"));
    }
}
