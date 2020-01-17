package br.com.gerenciador.moneyger.model.enums;

public enum TipoReceita {

	SALARIO(1),
	TRANSFERENCIA(2),
	ESTORNO(3),
	APLICACAO(4);
	
	private int code;
	
	private TipoReceita(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static TipoReceita valueOf(int code) {
		for (TipoReceita value : TipoReceita.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Codigo TipoReceita invalido.");
	}
}
