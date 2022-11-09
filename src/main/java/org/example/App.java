package org.example;

import javafx.application.Application;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
//        ShapeInput shapeInput = new ShapeInput();
//        shapeInput.display(stage);

        Assignment assignment = new Assignment();
        assignment.initialize();
        assignment.display(stage);

    }

    public static void main(String[] args) {
        launch();
    }

}