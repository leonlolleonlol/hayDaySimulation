package ca.qc.bdeb.inf203.examenfinal;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Oeuf extends GameObject {
    public Oeuf() {
        imageView = new ImageView(new Image("oeuf.png"));
        ax = vx = vy = 0;
        w = 28;
        h = 38;
        x = Math.random() * (Main.WIDTH - w);
        ay = 50;
        y = -h;
    }

    public void update(double dt) {
        updatePhysique(dt);
    }

    @Override
    public void draw(GraphicsContext context) {
        context.drawImage(imageView.getImage(), x, y, w, h);
    }
}
