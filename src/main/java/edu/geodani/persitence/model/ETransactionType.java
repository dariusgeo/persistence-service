package edu.geodani.persitence.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ETransactionType {
    IBAN_TO_IBAN(1, "IBAN_TO_IBAN"),
    IBAN_TO_WALLET(2, "IBAN_TO_WALLET"),
    WALLET_TO_IBAN(3, "WALLET_TO_IBAN"),
    WALLET_TO_WALLET(4, "WALLET_TO_WALLET");

    private final int id;
    private final String name;

    ETransactionType(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() { return name;}

}
