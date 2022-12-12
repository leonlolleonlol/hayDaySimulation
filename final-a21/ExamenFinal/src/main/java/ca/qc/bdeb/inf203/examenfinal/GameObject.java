package ca.qc.bdeb.inf203.examenfinal;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class GameObject {
    protected double x, y, vx, vy, ax, ay, w, h;
    protected ImageView imageView = new ImageView();
    protected Image imageDroite, imageGauche;

    protected void updatePhysique(double deltaTemps) {
        vx += deltaTemps * ax;
        vy += deltaTemps * ay;

        x += deltaTemps * vx;
        y += deltaTemps * vy;
    }

    protected void changerDirection() {
        if (x > Main.WIDTH - w) {
            x--;
            changerImageEtVitesse(imageDroite, imageGauche);
        }
        if (x < 0) {
            x++;
            changerImageEtVitesse(imageDroite, imageGauche);
        }
    }

    private void changerImageEtVitesse(Image img1, Image img2) {
        vx = -vx;
        if (imageView.getImage() != img1)
            imageView.setImage(img1);
        else
            imageView.setImage(img2);
    }
    public double getCentreX()
    {
        return y+h/2;
    }
    public double getCentreY()
    {
        return x+w/2;
    }

    public double getHaut() {
        return y;
    }

    public double getBas() {
        return y + h;
    }

    public double getGauche() {
        return x;
    }

    public double getDroite() {
        return x + w;
    }

    public void update(double deltaTemps) {
        updatePhysique(deltaTemps);
    }

    public abstract void draw(GraphicsContext context);
}
