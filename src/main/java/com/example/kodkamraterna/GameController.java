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

    // Method to handle a cell click from the GameBoard
    public void handleCellClick(int row, int col) {
        // Check if the cell is empty before making a move
        try {
            // Get the current player (X or O)
            String currentPlayer = String.valueOf(game.getCurrentPlayer());

            // Update the game state by making the move
            game.makeMove(row, col);

            // Update the UI (GameBoard) with the player's mark
            board.updateCell(row, col, currentPlayer);

            // Check if there is a winner
            Optional<Character> winner = game.checkWinner();
            if (winner.isPresent()) {
                // Handle the win (e.g., display a message or reset the game)
                System.out.println(winner.get() + " wins!");
                // Optionally: Add code to handle game over (e.g., restart)
            } else if (game.isBoardFull()) {
                // Handle a tie
                System.out.println("It's a tie!");
                // Optionally: Add code to handle game over (e.g., restart)
            }
        } catch (IllegalArgumentException e) {
            // Optionally: Add some feedback if the player clicks on an occupied cell
            System.out.println("Invalid move! The cell is already occupied.");
            e.printStackTrace();
        }
    }

    // Method to reset the game
    public void resetGame() {
        //game.resetBoard();  // Reset the game logic
        board.resetBoard(); // Clear the UI board (you need to implement this method in GameBoard)
    }
}