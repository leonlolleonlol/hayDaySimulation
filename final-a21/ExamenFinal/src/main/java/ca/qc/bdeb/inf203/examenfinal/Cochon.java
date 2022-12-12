package ca.qc.bdeb.inf203.examenfinal;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Cochon extends GameObject {
    public Cochon() {
        imageDroite = new Image("pig-right.png");
        imageGauche = new Image("pig-left.png");
        imageView = new ImageView(imageDroite);
        ax = ay = vy = 0;
        x = Math.random() * (Main.WIDTH / 1.25);
        vx = 85;
        w = 90;
        h = 56;
        y = Main.HEIGHT - h;
    }

    public void update(double dt) {
        changerDirection();
        updatePhysique(dt);
    }

    @Override
    public void draw(GraphicsContext context) {
        context.drawImage(imageView.getImage(), x, y, w, h);
    }
}
