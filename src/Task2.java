import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Pos;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.awt.event.ActionListener;

import static javafx.scene.paint.Color.TRANSPARENT;

public class Task2 extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create a new vertical box to make it easier to have children in a vertical column.
        VBox vBox = new VBox(5);
        vBox.setAlignment(Pos.CENTER);

        // Create three empty circles.
        Circle circle1 = getCircle();
        Circle circle2 = getCircle();
        Circle circle3 = getCircle();
        // Set the bottom circle to red.
        circle3.setFill(Color.RED);

        // Add all the circles to the vertical box.
        vBox.getChildren().addAll(circle1, circle2, circle3);
        // Set 20px spacing between the circles.
        vBox.setSpacing(20);

        // Create a new transparent rectangle.
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(30);
        rectangle.setHeight(120);
        rectangle.setFill(TRANSPARENT);
        StackPane stackPane = new StackPane(rectangle, vBox);

        // Create a new horizontal box for the radio buttons.
        HBox radioButtonBox = new HBox(5);
        radioButtonBox.setAlignment(Pos.CENTER);

        // Create a radio button for each colour.
        RadioButton rbRed = new RadioButton("Red");
        RadioButton rbYellow = new RadioButton("Yellow");
        RadioButton rbGreen = new RadioButton("Green");

        // Create a new toggle group.
        ToggleGroup group = new ToggleGroup();
        // Add all the radioButtons to the toggleGroup.
        rbRed.setToggleGroup(group);
        rbYellow.setToggleGroup(group);
        rbGreen.setToggleGroup(group);
        // Set default selection because the red circle is filled on start.
        rbRed.setSelected(true);
        // Add all the radioButtons to the box.
        radioButtonBox.getChildren().addAll(rbGreen, rbYellow, rbRed);
        radioButtonBox.setPadding(new Insets(15));

        // Create a new BorderPane.
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(stackPane);
        borderPane.setBottom(radioButtonBox);


//        rbRed.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                if (rbRed.isSelected()){
//
//                }
//            }
//        });

        // Create event handlers for all radioButtons.
        rbRed.setOnAction(e -> {
            if (rbRed.isSelected()) {
                circle1.setFill(Color.WHITE);
                circle2.setFill(Color.WHITE);
                circle3.setFill(Color.RED);
            }
        });

        rbYellow.setOnAction(e -> {
            if (rbYellow.isSelected()) {
                circle1.setFill(Color.WHITE);
                circle2.setFill(Color.YELLOW);
                circle3.setFill(Color.WHITE);
            }
        });

        rbGreen.setOnAction(e -> {
            if (rbGreen.isSelected()) {
                circle1.setFill(Color.GREEN);
                circle2.setFill(Color.WHITE);
                circle3.setFill(Color.WHITE);
            }
        });

        // Create a new scene.
        Scene scene = new Scene(borderPane, 200, 250);
        // Set the stage title
        primaryStage.setTitle("Fill up the Circles");
        // Add the scene to the stage.
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    // Quicker to have a constructor function for repeated circle parameters.
    private Circle getCircle() {
        Circle c = new Circle(10);
        c.setFill(Color.WHITE);
        c.setStroke(Color.BLACK);
        return c;
    }

}