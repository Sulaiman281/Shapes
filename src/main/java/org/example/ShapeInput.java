package org.example;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Locale;

public class ShapeInput {

    private VBox container;
    private Label heading;
    private Label shape_label;
    private Label color_label;

    private TextField shape_input;
    private TextField color_input;

    private Shape shape;
    private Color color;

    private Button btn;


    private Stage stage;

    public ShapeInput(){
        initialize();

        btn.setOnAction(e->{
            if(shape_input.getText().isEmpty() || color_input.getText().isEmpty()) return;

            if(shape_validate(shape_input.getText()))
                System.out.println("Shape Verified.");
            else
                return;
            if(color_validate(color_input.getText()))
                System.out.println("Color Verified.");
            else
                return;

            // open new scene. with shape fill the color.
            System.out.println("Working fine. now it's time to display the shape.");

            displayShape();

        });
    }

    public void display(Stage _stage){
        this.stage = _stage;

        _stage.setTitle("Shape Task");
        _stage.setScene(new Scene(container));
        _stage.setWidth(600);
        _stage.setHeight(600);
        _stage.show();
    }

    private boolean shape_validate(String _input){
        _input = _input.toLowerCase(Locale.ROOT);
        switch (_input){
            case "rectangle":
                Rectangle rectangle = new Rectangle();
                rectangle.setWidth(200);
                rectangle.setHeight(200);
                rectangle.setStroke(Color.BLACK);
                shape = rectangle;
                return true;
            case "circle":
                Circle circle = new Circle();
                circle.setRadius(200);
                circle.setStroke(Color.BLACK);
                shape = circle;
                return true;
            case "polygon":
                Polygon polygon = new Polygon();
                polygon.setStroke(Color.BLACK);
                shape = polygon;
                return true;
            case "ellipse":
                Ellipse ellipse = new Ellipse();
                ellipse.setRadiusX(200);
                ellipse.setRadiusY(210);
                ellipse.setStroke(Color.BLACK);
                shape = ellipse;
                return true;
            default:
                shape_label.setText("(Invalid Shape) Try again");
                shape_label.setTextFill(Color.RED);
                return false;
        }
    }

    private boolean color_validate(String _input){

        _input = _input.toLowerCase(Locale.ROOT);

        switch (_input){
            case "red":
                color = Color.RED;
                return true;
            case "green":
                color = Color.GREEN;
                return true;
            case "blue":
                color = Color.BLUE;
                return true;
            default:
                color_label.setTextFill(Color.RED);
                color_label.setText("(Invalid Color) Input Another.");
                return false;
        }
    }

    private void initialize() {
        container = new VBox();
        container.setAlignment(Pos.TOP_CENTER);
        container.setSpacing(20);
        container.setMinWidth(Region.USE_COMPUTED_SIZE);
        container.setMinHeight(Region.USE_COMPUTED_SIZE);
        container.setMaxWidth(Region.USE_COMPUTED_SIZE);
        container.setMaxHeight(Region.USE_COMPUTED_SIZE);

        heading = new Label();
        heading.setText("Welcome To My Program");
        heading.setFont(Font.font("Arial",24));

        shape_label = new Label();
        shape_label.setText("Shape Input");
        shape_label.setFont(Font.font("Arial",18));

        shape_input = new TextField();
        shape_input.setPromptText("rectangle");
        shape_input.setFont(Font.font("Arial",18));
        shape_input.setMaxWidth(Region.USE_PREF_SIZE);
        shape_input.setMaxHeight(Region.USE_PREF_SIZE);
        shape_input.setPrefWidth(300);
        shape_input.setPrefHeight(50);

        color_label = new Label();
        color_label.setText("Color Input");
        color_label.setFont(Font.font("Arial",18));


        color_input = new TextField();
        color_input.setPromptText("red");
        color_input.setFont(Font.font("Arial",18));
        color_input.setMaxWidth(Region.USE_PREF_SIZE);
        color_input.setMaxHeight(Region.USE_PREF_SIZE);
        color_input.setPrefWidth(300);
        color_input.setPrefHeight(50);

        btn = new Button("Enter");
        btn.setFont(Font.font("Arial",18));

        container.getChildren().addAll(heading,shape_label,shape_input,color_label,color_input,btn);
    }

    private void displayShape(){
        container.getChildren().clear();
        container.setAlignment(Pos.CENTER);

        shape.setFill(color);
        shape.setOnMousePressed(e->{
            System.out.println("Shape is here.");
        });

        container.getChildren().add(shape);
    }

}
