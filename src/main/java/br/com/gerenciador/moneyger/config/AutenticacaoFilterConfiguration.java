package br.com.gerenciador.moneyger.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.gerenciador.moneyger.model.User;
import br.com.gerenciador.moneyger.repositories.UserRepository;
import br.com.gerenciador.moneyger.services.TokenService;

public class AutenticacaoFilterConfiguration extends OncePerRequestFilter {

    private TokenService tokenService;
    private UserRepository usuarioRepository;

    public AutenticacaoFilterConfiguration(TokenService tokenService, UserRepository usuarioRepository) {
        this.tokenService = tokenService;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = recuperarToken(request);

        boolean tokenIsValid = tokenService.isValid(token);

        if (tokenIsValid){
            autenticarUsuario(token);
        }

        //libera a request para seguir seu fluxo após rodar a lógica do filtro
        filterChain.doFilter(request, response);
    }

    private void autenticarUsuario(String token) {
        Long idUsuario = tokenService.getIdUsuario(token);

        User usuario = usuarioRepository.findById(idUsuario).get();

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
        //Seta no contexto do Spring o usuario autenticado para a requisição atual
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private String recuperarToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
            return null;
        }

        return token.substring(7, token.length());
    }
}
