package ca.qc.bdeb.inf203.examenfinal;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Poule extends GameObject{
    public Poule() {
        imageDroite=new Image("cotcot-right.png");
        imageGauche=new Image("cotcot-left.png");
        imageView=new ImageView(imageDroite);
        ax=ay=vy=0;
        x=Math.random()*(Main.WIDTH/1.25);
        vx=50;
        w=54;
        h=56;
        y=Main.HEIGHT-h;
    }
    public void update(double dt)
    {
        changerDirection();
        updatePhysique(dt);
    }

    @Override
    public void draw(GraphicsContext context) {
        context.drawImage(imageView.getImage(),x,y,w,h);
    }
}
