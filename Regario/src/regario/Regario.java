/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regario;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author marvin
 */
public class Regario extends Application {

    @Override
    public void start(Stage stage) {
        stage.initStyle(StageStyle.TRANSPARENT);

        StackPane stackPane = new StackPane();

        stackPane.setStyle(
                "-fx-background-color: rgba(0,0,0,0.05);"
                + "-fx-background-insets: 50;"
        );
        final Canvas canvas = new Canvas(450, 450);
        stackPane.getChildren().add(canvas);
        
        new AnimationTimer() {

            @Override
            public void handle(long l) {
                double size = Math.cos(l/100000000f)*10 + 30;
                GraphicsContext g = canvas.getGraphicsContext2D();
                g.clearRect(0, 0, 450, 450);
                g.fillOval(225-size, 225-size, size*2, size*2);
            }
        }.start();

        Scene scene = new Scene(stackPane, 450, 450);
        scene.setFill(Color.TRANSPARENT);

        stage.setScene(scene);

        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
