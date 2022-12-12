package ca.qc.bdeb.inf203.examenfinal;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

public class Gnome extends GameObject{
    public Gnome() {
        imageDroite=new Image("gnome-right.png");
        imageGauche=new Image("gnome-left.png");
        imageView=new ImageView(imageDroite);
        w=107;
        h=96;
        ax=ay=vx=vy=0;
        x=(Main.WIDTH-w)/2;
        y=Main.HEIGHT-h;
    }
    public void update(double dt)
    {
        boolean right=Input.isKeyPressed(KeyCode.RIGHT);
        boolean left=Input.isKeyPressed(KeyCode.LEFT);
        if (right)
        {
            imageView.setImage(imageDroite);
            vx=250;
        }
        else if (left)
        {
            imageView.setImage(imageGauche);
            vx=-250;
        }
        else
            vx=0;
        updatePhysique(dt);
        x=Math.min(x,Main.WIDTH-w);
        x=Math.max(0,x);
    }

    @Override
    public void draw(GraphicsContext context) {
        context.drawImage(imageView.getImage(),x,y,w,h);
    }
}
