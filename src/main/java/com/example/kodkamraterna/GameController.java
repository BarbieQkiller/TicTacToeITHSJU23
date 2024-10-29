package com.example.kodkamraterna;

import java.util.Optional;

/**
 * @author Angela Gustafsson, anggus-1
 */
public class GameController {
    private final Game game;
    private final GameBoard board;

    public GameController(Game game, GameBoard board) {
        this.game = game;
        this.board = board;
    }

    public void handleCellClick(int row, int col) {
        try {
            String currentPlayer = String.valueOf(game.getCurrentPlayer());

            game.makeMove(row, col);

            board.updateCell(row, col, currentPlayer);

            Optional<Character> winner = game.checkWinner();
            if (winner.isPresent()) {
                System.out.println(winner.get() + " wins!");
            } else if (game.isBoardFull()) {
                System.out.println("It's a tie!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid move! The cell is already occupied.");
        }
    }


    public void resetGame() {
        //TODO:Implement reset game
        board.resetBoard();
    }
}