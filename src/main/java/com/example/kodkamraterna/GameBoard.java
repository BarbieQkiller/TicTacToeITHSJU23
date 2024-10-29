package com.example.kodkamraterna;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * @author Angela Gustafsson, anggus-1
 */
public class GameBoard extends Pane {
    private final Text[][] cellTexts = new Text[3][3];
    private GameController controller;

    public GameBoard() {
    }

    //TODO:circle reference between GameController and GameBoard
    public void setup(GameController controller) {
        this.controller = controller;

        // Create 3x3 grid of rectangles and texts
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Rectangle rect = new Rectangle(100, 100);
                rect.setStroke(Color.BLACK);
                rect.setFill(Color.WHITE);
                rect.setX(j * 100);
                rect.setY(i * 100);
                this.getChildren().add(rect);

                Text text = new Text();
                text.setX(j * 100 + 40);
                text.setY(i * 100 + 60);
                text.setText("");
                this.getChildren().add(text);
                cellTexts[i][j] = text;

                final int row = i;
                final int col = j;

                rect.setOnMouseClicked(e -> controller.handleCellClick(row, col));
            }
        }
    }

    public void updateCell(int row, int col, String value) {
        cellTexts[row][col].setText(value);
    }
    public void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cellTexts[i][j].setText("");
            }
        }
    }
}
