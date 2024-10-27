package com.example.kodkamraterna;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Angela Gustafsson, anggus-1
 */
class GameTest {
    @Test
    void checkWinner(){
        Game game = new Game(new char[][] {
                {'X','O', 'X'},
                {'X', 'X', 'X'},
                {'O','O', 'X'}
        });
        assertEquals(Optional.of('X'), game.checkWinner());
    }

    @Test
    void checkCells() {
        Game game = new Game();
        assertEquals(Optional.of('X'), game.checkCells('X', 'X', 'X'));
        assertEquals(Optional.of('O'), game.checkCells('O', 'O', 'O'));
        assertEquals(Optional.empty(), game.checkCells('X', '\0', 'X'));
    }
}