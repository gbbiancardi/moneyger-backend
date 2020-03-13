package br.com.gerenciador.moneyger.services;

import org.springframework.security.core.Authentication;

public interface TokenService {

    String gerarToken(Authentication authentication);

    boolean isValid(String token);

    Long getIdUsuario(String token);
}
