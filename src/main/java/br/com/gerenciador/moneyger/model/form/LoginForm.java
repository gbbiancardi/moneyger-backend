package br.com.gerenciador.moneyger.model.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginForm {

	@NotNull
	@Email
	private String email;

	@Length(min = 6, max = 18)
	@NotNull
	private String senha;

	public LoginForm() {
		super();
	}

	public LoginForm(@NotNull @Email String email, @Length(min = 6, max = 18) @NotNull String senha) {
		super();
		this.email = email;
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public UsernamePasswordAuthenticationToken converter() {
		return new UsernamePasswordAuthenticationToken(email, senha);
	}

}
