package org.example.entity;

public enum PlayerSymbol {
    CROSS('X'), CIRCLE('O');

    private final char symbol;
    PlayerSymbol(char symbol){
        this.symbol = symbol;
    }

    public char getSymbol(){
        return this.symbol;
    }
}
