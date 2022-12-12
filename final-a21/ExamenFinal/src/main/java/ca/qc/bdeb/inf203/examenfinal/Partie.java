package ca.qc.bdeb.inf203.examenfinal;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;

public class Partie {
    private final Gnome gnome;
    private final Poule[] poules;
    private final Cochon[] cochons;
    private final ArrayList<Oeuf> oeufs=new ArrayList<>();
    private static double timerTroisSecondes;
    private double timerTroisSecondesMessage;
    private static int score,vies;

    public Partie() {
        oeufs.add(new Oeuf());
        gnome = new Gnome();
        poules = new Poule[]{new Poule(), new Poule(), new Poule()};
        cochons = new Cochon[]{new Cochon(), new Cochon()};
        timerTroisSecondes = 3;
        timerTroisSecondesMessage=3;
        score=0;
        vies=3;
    }

    public void update(double deltaTemps) {
        if (vies!=0) {
            if (timerTroisSecondes > 0) {
                timerTroisSecondes -= deltaTemps;
            } else {
                timerTroisSecondes = 3;
                oeufs.add(new Oeuf());
            }
            gnome.update(deltaTemps);
            for (Poule poule : poules)
                poule.update(deltaTemps);
            for (Cochon cochon : cochons)
                cochon.update(deltaTemps);
            for (Oeuf oeuf : oeufs)
                oeuf.update(deltaTemps);
            for (int i = 0; i < oeufs.size(); i++) {
                if (Math.sqrt(Math.pow(gnome.getCentreX() - oeufs.get(i).getCentreX(), 2) + Math.pow(gnome.getCentreY() - oeufs.get(i).getCentreY(), 2)) < 50) {
                    score++;
                    oeufs.remove(oeufs.get(i));
                } else if (oeufs.get(i).getBas() >= Main.HEIGHT) {
                    oeufs.remove(oeufs.get(i));
                    vies--;
                }
            }
        }
        else
            timerTroisSecondesMessage-=deltaTemps;
    }

    public void draw(GraphicsContext context) {
        context.drawImage(new Image("arriere-plan.png"), 0, 0, Main.WIDTH, Main.HEIGHT);
        if (vies!=0) {
            context.setFont(Font.font("calibri", 25));
            context.setFill(Color.BLACK);
            context.fillText("Score : " + score, 25, 25);
            for (int i = 0; i < vies; i++) {
                context.drawImage(new Image("coeur.png"), 25 + 34 * i, 50);
            }
            gnome.draw(context);
            for (Poule poule : poules)
                poule.draw(context);
            for (Cochon cochon : cochons)
                cochon.draw(context);
            for (Oeuf oeuf : oeufs)
                oeuf.draw(context);
        }
        else if (timerTroisSecondesMessage>0){
            context.setFont(Font.font("calibri", 50));
            context.setFill(Color.RED);
            context.fillText("PERDU!", Main.WIDTH / 2-50, Main.HEIGHT / 2);
        }
        else
            oeufs.clear();
    }

    public double getTimerTroisSecondesMessage() {
        return timerTroisSecondesMessage;
    }
}
