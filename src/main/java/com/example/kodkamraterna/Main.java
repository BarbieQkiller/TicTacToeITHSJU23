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
        Game game = new Game();
        GameBoard board = new GameBoard();
        GameController controller = new GameController(game, board);

        Scene scene = new Scene(board, 300, 300);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
