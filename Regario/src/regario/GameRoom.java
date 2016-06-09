/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regario;

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author marvin
 */
class GameRoom {

    ArrayList<GameObject> objects = new ArrayList<GameObject>();
    
    
    void update(long l) {
        for (GameObject o : objects) {
            o.update(l);
        }
    }

    void render(long l, GraphicsContext g) {
        for (GameObject o : objects) {
            o.render(l, g);
        }
    }

    public void addObject(GameObject o) {
        objects.add(o);
    }
    
    
    void init() {
    }
}
