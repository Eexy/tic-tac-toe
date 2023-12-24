package org.example.saver;

import org.example.Game;

import java.io.IOException;

public interface Saver {
    public void save(Game game) throws IOException;
}
