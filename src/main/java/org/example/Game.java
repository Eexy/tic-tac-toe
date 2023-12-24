package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private final Player p1;
    private final Player p2;
    private final Board board;

    private List<Move> moves;

    private boolean isWon = false;
    public Game(Player p1, Player p2, Board board){
        this.p1 = p1;
        this.p2 = p2;
        this.board = board;
        this.moves = new ArrayList<>();
    }

    public void loop() {
        boolean playerTurn = true;
        Scanner in = new Scanner(System.in);
        while(!board.isFull() && !this.isWon){
            System.out.print(board.toString());
            Player currentPlayer = playerTurn ? this.p1 : this.p2;
            int cell = 0;
            do {
                System.out.print("Choose your cell : ");
                cell = in.nextInt();
            } while (!currentPlayer.play(this.board, cell));
            this.moves.add(new Move(currentPlayer.getName(), cell, currentPlayer.getSymbol()));
            this.isWon = this.board.isWinningCell(cell);
            playerTurn = !playerTurn;
        }
        System.out.println(this.board.toString());

        this.save();
    }

    public void save(){
        try{
            Saver.save(this.moves);
        }catch (IOException ex){
            System.out.println("Unable to save game in file game.txt");
        }
    }
}
