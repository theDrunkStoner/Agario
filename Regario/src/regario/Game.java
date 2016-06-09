/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regario;

import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author marvin
 */
class Game {

    public Game(GameRoom room) {
        changeRoom(room);
    }
    
    public void update(long l) {
        room.update(l);
    }

    public void render(long l, GraphicsContext g) {
        room.render(l, g);
    }
    
    GameRoom room;

    void changeRoom(GameRoom room) {
        this.room = room;
        room.init();
    }
}
