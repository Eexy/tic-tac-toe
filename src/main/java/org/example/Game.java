package org.example;

import org.example.saver.Saver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Game {
    private final Player p1;
    private final Player p2;
    private final Board board;

    private List<Move> moves;

    private final Saver saver;

    private boolean isWon = false;
    public Game(Player p1, Player p2, Board board, Saver saver){
        this.p1 = p1;
        this.p2 = p2;
        this.board = board;
        this.moves = new ArrayList<>();
        this.saver = saver;
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
            this.moves.add(new Move(currentPlayer, cell, currentPlayer.getSymbol()));
            this.isWon = this.board.isWinningCell(cell);
            playerTurn = !playerTurn;
        }
        System.out.println(this.board.toString());

        this.save();
    }

    public List<Move> getMoves(){
        return this.moves;
    }

    public boolean isWon(){
        return this.isWon;
    }

    public Player getP1(){
        return this.p1;
    }
    public Player getP2(){
        return this.p2;
    }

    public void save(){
        try{
            this.saver.save(this);
        }catch (IOException ex){
            System.out.println("Unable to save game in file game.txt");
        }
    }
}
