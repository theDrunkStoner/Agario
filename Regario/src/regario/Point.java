/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regario;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

/**
 *
 * @author marvin
 */
class Point {
    int x, y;
    Paint color;
    int score;
    
    public Point(int x, int y, Paint color, int score){
        this.x = x;
        this.y = y;
        this.color = color;
        this.score = score;
    }
    
    public void render(GraphicsContext g){
        
    }
}
