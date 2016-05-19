package regario;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Regario extends Application {

    public static final int WIDTH = 1280, HEIGHT = 720;
    public static Canvas canvas;
    public static Stage mainStage;

    @Override
    public void start(Stage stage) {
        mainStage = stage;
        stage.initStyle(StageStyle.TRANSPARENT);

        StackPane stackPane = new StackPane();

        stackPane.setStyle(
                "-fx-background-color: rgba(0,0,0,0.5);"
        );
        canvas = new Canvas(WIDTH, HEIGHT);
        stackPane.getChildren().add(canvas);

        game = new Game(new RoomGame());

        new AnimationTimer() {
            @Override
            public void handle(long l) {
                try {
                    update(l);
                    GraphicsContext g = canvas.getGraphicsContext2D();
                    g.setGlobalBlendMode(BlendMode.SRC_OVER);
                    g.clearRect(0, 0, WIDTH, HEIGHT);
                    render(l, g);
                    Thread.sleep(17);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Regario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();

        Scene scene = new Scene(stackPane, WIDTH, HEIGHT);
        scene.setFill(Color.TRANSPARENT);

        stage.setScene(scene);

        stage.show();
    }

    public static Game game;

    void update(long l) {
        game.update(l);
    }

    void render(long l, GraphicsContext g) {
        game.render(l, g);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
