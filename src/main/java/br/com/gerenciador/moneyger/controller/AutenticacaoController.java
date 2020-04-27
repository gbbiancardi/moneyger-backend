package br.com.gerenciador.moneyger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    
    @CrossOrigin
	@PostMapping(value = "/{email}/{senha}")
	public ResponseEntity<?> loginAuth(@PathVariable String email, @PathVariable String senha) throws Exception {
		LoginForm loginForm = new LoginForm(email, senha);
		UsernamePasswordAuthenticationToken dadosLogin = loginForm.converter();
		Authentication authentication = authenticationManager.authenticate(dadosLogin);
		String token = tokenService.gerarToken(authentication);
		return ResponseEntity.ok().body(new TokenDTO(token, "Bearer"));
	}

//    @PostMapping
//    public ResponseEntity<?> autenticar(@RequestBody @Valid LoginForm form) {
//
//        UsernamePasswordAuthenticationToken dadosLogin = form.converter();
//
//        //chama a classe SecuriryConfiguration para chamar o service responsavel pelo login do usuário, retorna um objeto do tipo Authentication que comntém as informações do usuário logado
//        Authentication authentication = authenticationManager.authenticate(dadosLogin);
//
//        String token = tokenService.gerarToken(authentication);
//
//        return ResponseEntity.status(HttpStatus.OK).body(new TokenDTO(token, "Bearer"));
//    }
}
