package org.example.saver;

import org.example.Game;
import org.example.entity.Move;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class TextSaver implements Saver{
    @Override
    public void save(Game game) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("GAME BEGIN\n");
        sb.append(this.buildMovesString(game.getMoves()));
        sb.append(this.buildResultString(game));
        sb.append("GAME END\n");

        Files.write(Paths.get("./game.txt"), sb.toString().getBytes(),
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    private String buildMovesString(List<Move> moves){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < moves.size(); i++){
            sb.append(moves.get(i).toString()).append("\n");
        }

        return sb.toString();
    }


    private String buildResultString(Game game){
        StringBuilder sb = new StringBuilder();
        if(!game.isWon()){
            sb.append("Result: DRAW\n");
        }else{
            sb.append("Result: ")
                    .append(game.getMoves().getLast().getPlayer().getName())
                    .append(" WON\n");
        }

        return sb.toString();
    }
}
