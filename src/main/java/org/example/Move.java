package org.example;

public class Move {
    private final String playerName;
    private final int cell;

    private final PlayerSymbol symbol;

    public Move(String playerName, int cell, PlayerSymbol symbol ){
        this.playerName = playerName;
        this.cell = cell;
        this.symbol = symbol;
    }

    public String getPlayerName(){
        return this.playerName;
    }

    @Override
    public String toString() {
        return this.playerName + " : put " + this.symbol.getSymbol() + " in cell " + this.cell;
    }
}
