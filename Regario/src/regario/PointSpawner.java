/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regario;

import javafx.scene.paint.Color;

/**
 *
 * @author marvin
 */
public class PointSpawner {

    public PointSpawner(GameRoom room) {
        this.room = room;
    }

    GameRoom room;

    public static Color hex(int rgb) {
        java.awt.Color c = new java.awt.Color(rgb);

        double r = c.getRed() / 255.0;
        double g = c.getGreen() / 255.0;
        double b = c.getBlue() / 255.0;
        double a = c.getAlpha() / 255.0;

        return new Color(r, g, b, a);
    }
    
    Color[] cols = {};
    
    public void update() {
        if(Math.random() < 0.01){
            float angle = (float)(Math.random()*Math.PI*2);
            float distance = 1000;
            int x = (int)(Math.cos(angle)*distance);
            int y = (int)(Math.sin(angle)*distance);
            Point p = new Point(x, y, null, 1);
        }
    }
}
