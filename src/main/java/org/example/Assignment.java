package org.example;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Assignment {

    private BorderPane main_container;
    private VBox left_container;
    private AnchorPane center_container;
    private HBox top_container;

    private Label msg;

    private ComboBox<String> shapes;
    private ComboBox<String> colorPicker;

    private Shape selectedShape;

    void initialize(){
        main_container = new BorderPane();

        left_container = new VBox();
        left_container.setAlignment(Pos.TOP_CENTER);
        left_container.setSpacing(20);

        center_container = new AnchorPane();

        top_container = new HBox();
        top_container.setAlignment(Pos.CENTER);

        main_container.setLeft(left_container);
        main_container.setCenter(center_container);
        main_container.setTop(top_container);

        msg = new Label();
        msg.setFont(Font.font("Arial",24));

        top_container.getChildren().add(msg);

        shapes = new ComboBox<>();
        shapes.getItems().addAll("Rectangle","Circle","Polygon");

        colorPicker = new ComboBox<>();
        colorPicker.getItems().addAll("Blue","Green","Yellow");

        left_container.getChildren().addAll(shapes,colorPicker);

        colorPicker.valueProperty().addListener((observableValue, color, t1) -> {
            if(selectedShape != null)
                selectedShape.setFill(getColor(t1));
            else
                msg.setText("Please select the shape to fill color.");
        });

        shapes.valueProperty().addListener((observableValue, shape, t1) -> {
            selectedShape = getShape(t1);
            assert selectedShape != null;
            updateShape();
        });
    }

    private void updateShape(){
        center_container.getChildren().clear();
        double x = center_container.getWidth()/2;
        double y = center_container.getHeight()/2;
        System.out.println("Bounds: "+x+","+y);

        selectedShape.setLayoutX(x);
        selectedShape.setLayoutY(y);

        center_container.getChildren().add(selectedShape);
    }

    public void display(Stage stage){
        stage.setTitle("Assignment");
        stage.setScene(new Scene(main_container));
        stage.setWidth(600);
        stage.setHeight(600);
        stage.show();
    }

    private Color getColor(String _input){
        switch (_input){
            case "Blue":
                msg.setText("Blue Color is Selected.");
                return Color.BLUE;
            case "Green":
                msg.setText("Green Color is Selected.");
                return Color.GREEN;
            case "Yellow":
                msg.setText("Yellow Color is Selected.");
                return Color.YELLOW;
            default:
                return Color.BLACK;
        }
    }

    private Shape getShape(String _input){

        switch (_input){
            case "Rectangle":
                Rectangle rectangle = new Rectangle();
                rectangle.setWidth(200);
                rectangle.setHeight(200);
                rectangle.setStroke(Color.BLACK);
                msg.setText("Rectangle Shape is selected.");
                return rectangle;
            case "Circle":
                Circle circle = new Circle();
                circle.setRadius(100);
                circle.setStroke(Color.BLACK);
                msg.setText("Circle Shape is selected.");
                return circle;
            case "Polygon":
                Polygon polygon = new Polygon();
                polygon.setStroke(Color.BLACK);

                polygon.getPoints().addAll(
                        100.0, 50.0,
                        150.0, 50.0,

                        200.0, 100.0,
                        200.0, 150.0,

                        150.0, 200.0,
                        100.0, 200.0,

                        50.0, 150.0,
                        50.0, 100.0
                        );
                msg.setText("Polygon Shape is selected.");
                return polygon;

        }
        return null;
    }

}
