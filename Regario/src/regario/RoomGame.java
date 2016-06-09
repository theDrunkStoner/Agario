package regario;

import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BlendMode;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

class RoomGame extends GameRoom {

    public RoomGame() {
        p = new ObjectPlayer(0, 0, this);
        addObject(p);
        Regario.canvas.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                mouseX = (int) e.getSceneX();
                mouseY = (int) e.getSceneY();
            }
        });
        spawner.room = this;
    }
    
    long starttime = System.currentTimeMillis();

    ArrayList<Point> points = new ArrayList<Point>();
    PointSpawner spawner = new PointSpawner();

    double camX, camY;
    int mouseX;
    int mouseY;

    public static final Color GRID_COLOR = hex(0x33C3D433);
    public static final Color PLAYER_COLOR = hex(0x3390C3D4);
    public static final Color PLAYER_COLOR_OUTLINE = hex(0x33ADEBFF);

    ObjectPlayer p;

    int score = 0;

    @Override
    void render(long l, GraphicsContext g) {
        g.setGlobalBlendMode(BlendMode.SRC_OVER);
        g.setStroke(GRID_COLOR);
        int gridSize = 30;
        g.setLineWidth(0.5);
        for (int x = 0; x <= Regario.WIDTH / gridSize + 1; x++) {
            double ox = ((int) camX) % gridSize * 2;
            g.strokeLine(x * 30 + ox, 0, x * 30 + ox, Regario.HEIGHT);
        }
        for (int y = 0; y <= Regario.HEIGHT / gridSize + 1; y++) {
            double oy = ((int) camY) % gridSize * 2;
            g.strokeLine(0, y * gridSize + oy, Regario.WIDTH, y * gridSize + oy);
        }

        g.translate(camX * 2 + Regario.WIDTH / 2, camY * 2 + Regario.HEIGHT / 2);
        super.render(l, g);
        for (Point p : points) {
            p.render(g);
        }
        g.translate(-camX * 2 - Regario.WIDTH / 2, -camY * 2 - Regario.HEIGHT / 2);
        g.setFill(Color.WHITE);
        if (font == null) {
            font = new Font("Arial", 30);
        }
        g.setFont(font);
        g.fillText("Score: " + score, 20, 50);
        
        long timeLeft = 60000 - System.currentTimeMillis() + starttime;
        g.fillText(String.format("Time left: %2.1fs", timeLeft/1000f), 20, 80);
    }
    Font font;

    public static Color hex(int rgb) {
        java.awt.Color c = new java.awt.Color(rgb);

        double r = c.getRed() / 255.0;
        double g = c.getGreen() / 255.0;
        double b = c.getBlue() / 255.0;
        double a = c.getAlpha() / 255.0;

        return new Color(r, g, b, a);
    }

    @Override
    void update(long l) {
        camX = p.x;
        camY = p.y;
        super.update(l);
        spawner.update();
        long timeLeft = 60000 - System.currentTimeMillis() + starttime;
        if(timeLeft < 0)
            Regario.game.changeRoom(new RoomGameOver(score));
    }

}
