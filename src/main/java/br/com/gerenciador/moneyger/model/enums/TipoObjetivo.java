package br.com.gerenciador.moneyger.model.enums;

public enum TipoObjetivo {

	TURISMO(1),
	EDUCACAO(2),
	IMOVEL(3),
	AUTOMOVEL(4),
	DIVIDA(5),
	LAZER(6),
	PREVIDENCIA(7);
	
	private int code;
	
	private TipoObjetivo(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static TipoObjetivo valueOf(int code) {
		for (TipoObjetivo value : TipoObjetivo.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Codigo TipoObjetivo invalido.");
	}
}
