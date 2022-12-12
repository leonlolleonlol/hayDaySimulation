package ca.qc.bdeb.inf203.examenfinal;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    public static final double WIDTH = 640, HEIGHT = 480;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        var root = new Pane();
        var scene = new Scene(root, WIDTH, HEIGHT);
        var canvas = new Canvas(WIDTH, HEIGHT);
        root.getChildren().add(canvas);

        var context = canvas.getGraphicsContext2D();

        final Partie[] partie = {new Partie()};

        scene.setOnKeyPressed((e) -> {
            if (e.getCode() == KeyCode.ESCAPE) {
                Platform.exit();
            } else {
                Input.setKeyPressed(e.getCode(), true);
            }
        });

        scene.setOnKeyReleased((e) -> {
            Input.setKeyPressed(e.getCode(), false);
        });

        var timer = new AnimationTimer() {
            long lastTime = System.nanoTime();

            @Override
            public void handle(long now) {

                double deltaTemps = (now - lastTime) * 1e-9;

                deltaTemps = Math.min(deltaTemps, 1 / 30.0);
                if (partie[0].getTimerTroisSecondesMessage()<=0) {
                    partie[0]=new Partie();
                }
                partie[0].update(deltaTemps);
                partie[0].draw(context);

                lastTime = now;
            }
        };
        timer.start();

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Examen Final");
        primaryStage.show();
    }
}