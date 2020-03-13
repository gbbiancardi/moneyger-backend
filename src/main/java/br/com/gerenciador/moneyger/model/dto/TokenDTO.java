package br.com.gerenciador.moneyger.model.dto;

public class TokenDTO {

    private String token;
    private String authenticationType;

    public TokenDTO(String token, String authenticationType) {
        this.token = token;
        this.authenticationType = authenticationType;
    }

    public String getToken() {
        return token;
    }

    public String getAuthenticationType() {
        return authenticationType;
    }

}
