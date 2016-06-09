/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regario;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author it130060
 */
class RoomGameOver extends GameRoom{

    int score;
    
    public RoomGameOver(int score) {
        this.score = score;
    }

    @Override
    void init() {
        font = new Font("Arial", 50);
    }
    
    

    Font font;
    
    @Override
    void render(long l, GraphicsContext g) {
        g.setFont(font);
        g.setTextAlign(TextAlignment.CENTER);
        g.fillText("Game Over", Regario.WIDTH/2, Regario.HEIGHT/3);
    }
}
