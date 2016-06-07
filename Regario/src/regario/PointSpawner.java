/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regario;

import java.util.ArrayList;
import javafx.scene.paint.Color;

/**
 *
 * @author marvin
 */
public class PointSpawner {

    RoomGame room;

    public static Color hex(int rgb) {
        java.awt.Color c = new java.awt.Color(rgb);

        double r = c.getRed() / 255.0;
        double g = c.getGreen() / 255.0;
        double b = c.getBlue() / 255.0;
        double a = c.getAlpha() / 255.0;

        return new Color(r, g, b, a);
    }

    Color[] cols = {hex(0xFFF63C),
        hex(0xFF693D),
        hex(0xDBE537),
        hex(0x002D40)};

    public void update() {
        if (Math.random() < 0.2) {
            float angle = (float) (Math.random() * Math.PI * 2);
            float distance = 1000;
            int x = (int) (Math.cos(angle) * distance - room.p.x * 2);
            int y = (int) (Math.sin(angle) * distance - room.p.y * 2);
            int score = 1 + (int) (Math.random() * 10);
            Point p = new Point(x, y, cols[(int) (cols.length * Math.random())], score);
            room.points.add(p);
        }
        while (room.points.size() > 300) {
            room.points.remove(0);
        }
        ArrayList<Point> remove = new ArrayList<Point>();
        double px = -room.p.x * 2;
        double py = -room.p.y * 2;
        for (Point p : room.points) {
            double d = Math.sqrt((px - p.x) * (px - p.x) + (py - p.y) * (py - p.y));
            if( d < 50){
                remove.add(p);
                room.score += p.score;
            }
        }
        for(Point p:remove)
            room.points.remove(p);
    }
}
