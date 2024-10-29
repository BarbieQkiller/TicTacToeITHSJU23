package com.example.kodkamraterna;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Angela Gustafsson, anggus-1
 */
public class Game {
    private final char[][] board;
    private char currentPlayer = 'X';

    public Game() {
        this(new char[][] {
                {'\0','\0', '\0'},
                {'\0', '\0', '\0'},
                {'\0','\0', '\0'}
        });;
    }

    Game(char[][]board) {
        this.board = board;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public void makeMove(int x, int y) {
        // Check if the cell is already occupied
        if (board[x][y] != '\0') {
            throw new IllegalArgumentException("Invalid move! The cell is already occupied.");
        }

        // If the cell is empty, make the move
        board[x][y] = currentPlayer;
        switchPlayer();
    }


    void switchPlayer() {
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

    public Optional<Character> checkWinner() {
        // Check rows
        Optional<Character> row1 = checkCells(board[0][0], board[0][1], board[0][2]);
        if (row1.isPresent()) return row1;

        Optional<Character> row2 = checkCells(board[1][0], board[1][1], board[1][2]);
        if (row2.isPresent()) return row2;

        Optional<Character> row3 = checkCells(board[2][0], board[2][1], board[2][2]);
        if (row3.isPresent()) return row3;

        // Check columns
        Optional<Character> col1 = checkCells(board[0][0], board[1][0], board[2][0]);
        if (col1.isPresent()) return col1;

        Optional<Character> col2 = checkCells(board[0][1], board[1][1], board[2][1]);
        if (col2.isPresent()) return col2;

        Optional<Character> col3 = checkCells(board[0][2], board[1][2], board[2][2]);
        if (col3.isPresent()) return col3;

        // Check diagonals
        Optional<Character> diagonal1 = checkCells(board[0][0], board[1][1], board[2][2]);
        if (diagonal1.isPresent()) return diagonal1;

        Optional<Character> diagonal2 = checkCells(board[0][2], board[1][1], board[2][0]);
        if (diagonal2.isPresent()) return diagonal2;

        // If no winner is found, return Optional.empty()
        return Optional.empty();
    }
    Optional<Character> checkCells(char a, char b, char c) {
        Set<Character> characterSet = Stream.of(a, b, c).collect(Collectors.toSet());
        if (characterSet.contains('\0')||characterSet.size()!=1) {
            return Optional.empty();
        } else {
            return Optional.of(characterSet.iterator().next());
        }

    }
}

