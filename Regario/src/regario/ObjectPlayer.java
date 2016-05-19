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
class ObjectPlayer extends GameObject {

    GameRoom room;
    
    public ObjectPlayer(double x, double y, GameRoom room) {
        this.x = x;
        this.y = y;
        this.room = room;
    }

    @Override
    void update(long l) {
        RoomGame r = (RoomGame)room;
        int mx = r.mouseX-Regario.WIDTH/2;
        int my = r.mouseY-Regario.HEIGHT/2;
        
        x -= mx/100f;
        y -= my/100f;
        
        super.update(l);
    }

    @Override
    void render(long l, GraphicsContext g) {
        g.setFill(RoomGame.PLAYER_COLOR);
        g.fillOval(x - 50, y - 50, 100, 100);
        g.setLineWidth(5);
        g.setStroke(RoomGame.PLAYER_COLOR_OUTLINE);
        g.strokeOval(x - 50, y - 50, 100, 100);
    }

}
