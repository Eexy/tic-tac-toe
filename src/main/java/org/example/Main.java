package org.example;


import org.example.saver.TextSaver;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Player p1 = new Player(PlayerSymbol.CROSS, "Player 1");
        Player p2 = new Player(PlayerSymbol.CIRCLE, "Player 2");
        Board board = new Board();
        Game game = new Game(p1, p2, board, new TextSaver());
        game.loop();
    }
}