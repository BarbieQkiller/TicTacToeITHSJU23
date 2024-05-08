package com.example.kodkamraterna;

/**
 * @author Angela Gustafsson, anggus-1
 */
public class Game {
    private final char[][] board = new char[3][3];
    private char currentPlayer = 'X';

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public void makeMove(int x, int y) {
        if (board[x][y] == '\0') {
            board[x][y] = currentPlayer;
            switchPlayer();
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public boolean isBoardFull() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == '\0') {
                    return false;
                }
            }
        }
        return true;
    }

    public char checkWinner() {
        // Add logic to check for winner
        return '\0';
    }
}

