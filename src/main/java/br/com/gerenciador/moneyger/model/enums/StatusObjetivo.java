package br.com.gerenciador.moneyger.model.enums;

public enum StatusObjetivo {

	CHEGOU(1),
	PERTO(2),
	CAMINHANDO(3),
	AFASTANDO(4),
	LONGE(5);
	
	private int code;
	
	private StatusObjetivo(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static StatusObjetivo valueOf(int code) {
		for (StatusObjetivo value : StatusObjetivo.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Codigo StatusObjetivo invalido.");
	}
}
