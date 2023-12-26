package org.example.entity;

public class Move {
    private final Player player;
    private final int cell;

    private final PlayerSymbol symbol;

    public Move(Player player, int cell, PlayerSymbol symbol ){
        this.player = player;
        this.cell = cell;
        this.symbol = symbol;
    }

    public Player getPlayer(){
        return this.player;
    }

    @Override
    public String toString() {
        return this.player.getName() + " : put " + this.symbol.getSymbol() + " in cell " + this.cell;
    }
}
