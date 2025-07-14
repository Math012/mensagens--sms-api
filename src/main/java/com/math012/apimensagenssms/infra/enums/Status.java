package com.math012.apimensagenssms.infra.enums;

public enum Status {
    ENVIADO("enviado"),
    RECEBIDO("recebido"),
    ERRO_DE_ENVIO("erro de envio");

    private String description;

    Status(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
