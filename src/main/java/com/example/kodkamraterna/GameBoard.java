package com.example.kodkamraterna;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;

/**
 * @author Angela Gustafsson, anggus-1
 */
public class GameBoard extends Pane {
    public GameBoard() {
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
            }
        }
    }
}
