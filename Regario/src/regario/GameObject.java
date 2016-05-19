/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regario;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 *
 * @author marvin
 */
class GameObject {

    double x, y;
    double sx, sy;
    double ax, ay;

    double w = -1, h = -1;

    Image img;

    void update(long l) {

    }

    void render(long l, GraphicsContext g) {
        if (img != null) {
            if (w < 0 || h < 0) {
                g.drawImage(img, x, y);
            } else {
                g.drawImage(img, x, y, w, h);
            }
        }
    }

}
