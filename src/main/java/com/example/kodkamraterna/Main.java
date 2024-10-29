package com.example.kodkamraterna;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Angela Gustafsson, anggus-1
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Initialize the game logic and UI components
        Game game = new Game();
        GameBoard board = new GameBoard();
        GameController controller = new GameController(game, board);
        board.setup(controller);

        // Set up the scene and stage
        Scene scene = new Scene(board, 320, 320); // Slightly larger scene for more space
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
