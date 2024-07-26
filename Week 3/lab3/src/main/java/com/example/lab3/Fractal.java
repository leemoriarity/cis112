package com.example.lab3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.canvas.*;
import javafx.stage.Stage;
import java.util.Random;

/**
 * @author Lee Moriarity
 */
public class Fractal extends Application {
    static final int X = 150;
    static final int Y = 150;
    static final int SIZE = 500;
    static Random r = new Random();
    private Canvas drawingArea;

    public void start(Stage stage)
    {
        stage.setTitle("Lab #3 - Fractal");
        //Set Size of canvas
        drawingArea = new Canvas(600,600);
        GraphicsContext gc = drawingArea.getGraphicsContext2D();
        //Draw square
        drawSquare(X, Y, SIZE);
        //Create pane
        Pane pane = new Pane(drawingArea);
        //Create scene
        Scene scene = new Scene(pane, 600, 600);
        //Set scene
        stage.setScene(scene);
        //Show scene
        stage.show();
    }

    public void drawSquare(int x, int y, int size)
    {   //Recursion loop
        if (x<=2) {
            return;
        } else {
            GraphicsContext gc = drawingArea.getGraphicsContext2D();
            gc.setFill(Color.rgb(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
            gc.fillRect(x, y, size, size);
            drawSquare(x / 2, y / 2, size / 2);
        }
    }

    public static void main(String args[])
    {
        //Launch the application
        launch(args);
    }
}