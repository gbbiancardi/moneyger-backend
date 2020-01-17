package br.com.gerenciador.moneyger.model.enums;

public enum TipoDespesa {

	CONTA(1),
	PRODUTO(2),
	SERVICO(3),
	ALIMENTACAO(4),
	TRANSPORTE(5),
	LAZER(6),
	EDUCACAO(7),
	SAUDE(8);
	
	private int code;
	
	private TipoDespesa(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static TipoDespesa valueOf(int code) {
		for (TipoDespesa value : TipoDespesa.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Codigo TipoDespesa invalido.");
	}
}
