package org.example.entity;

public class Player {
    private final PlayerSymbol symbol;

    private final String name;

    public Player(PlayerSymbol symbol, String name){
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public PlayerSymbol getSymbol() {
        return symbol;
    }

    public boolean play(Board board, int cell){
        try{
            board.draw(this.symbol.getSymbol(), cell);
        }catch (RuntimeException ex){
            return false;
        }

        return true;
    }
}
