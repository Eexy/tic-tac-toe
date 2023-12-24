package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Saver {
    public static void save(List<Move> moves) throws IOException {
        for(Move move: moves){
            Files.write(Paths.get("./game.txt"), (move.toString() + "\n").getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
        }

        Files.write(Paths.get("./game.txt"), "\n".getBytes(),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
    }
}
