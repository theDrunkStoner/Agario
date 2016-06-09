/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regario;

import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author it130060
 */
class RoomGameOver extends GameRoom {

    int score;

    public RoomGameOver(int score) {
        this.score = score;
        Regario.scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                Regario.game.changeRoom(new RoomGame());
                Regario.scene.setOnKeyPressed(null);
            }
        });
    }

    @Override
    void init() {
        font = new Font("Arial", 60);

    }

    Font font;

    @Override
    void render(long l, GraphicsContext g) {
        g.setFont(font);
        g.setTextAlign(TextAlignment.CENTER);
        g.fillText("Game Over", Regario.WIDTH / 2, Regario.HEIGHT / 3);
        g.fillText(String.format("You reached %d points!", score), Regario.WIDTH / 2, Regario.HEIGHT / 2);
        g.fillText("Press any key to play again", Regario.WIDTH / 2, Regario.HEIGHT / 3 * 2);
    }
}
