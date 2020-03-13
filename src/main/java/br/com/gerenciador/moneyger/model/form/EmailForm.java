package br.com.gerenciador.moneyger.model.form;

public class EmailForm {

	private String assunto;
	private String titulo;
	private String mensagem;
	
	public EmailForm() {
		
	}

	public EmailForm(String assunto, String titulo, String mensagem) {
		super();
		this.assunto = assunto;
		this.titulo = titulo;
		this.mensagem = mensagem;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
