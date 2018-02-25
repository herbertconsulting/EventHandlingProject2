/**
 * by Herb Everett
 * created 2/21/2018
 *
 * I agree to abide by the GTCC Student Academic Integrity Policy.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EventHandlingProject2 extends Application {
    private CustomPane customPane = new CustomPane();

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws Exception {

        HBox hBox = new HBox(20);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(15, 15, 15, 15));
        Button btFront = new Button("Front");
        Button btBack = new Button("Back");
        Button btSide = new Button("Side");
        hBox.getChildren().addAll(btFront, btBack, btSide);

        btFront.setOnAction(new EventHandler<ActionEvent>() { // Anonymous inner class handler
            public void handle(ActionEvent e) {
                customPane.showFront();
            }
        });

        btBack.setOnAction(e -> { // Lambda expression for back button
            customPane.showBack();
        });
        btSide.setOnAction(e -> { // Lambda expression for side button
            customPane.showSide();
        });

        // Create the border pane
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(hBox);
        borderPane.setCenter(customPane);
        BorderPane.setAlignment(hBox, Pos.CENTER);

        // Create the Scene and place it in the stage
        Scene scene = new Scene(borderPane, 600, 500);
        primaryStage.setTitle("AT Building Views");
        primaryStage.setScene(scene);
        primaryStage.show();
        BorderPane pane = new BorderPane();
    }
}
// Define a custom pane to hold the images in the center of the pane
class CustomPane extends StackPane {
    public CustomPane() {
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
    }
    // Methods to show the Front, Back and Side images when an action event (button press) takes place
    public void showFront() {
        Label labelF = new Label("This is the front of the AT building");
        labelF.setFont(Font.font("Arial", 18));
        StackPane.setAlignment(labelF, Pos.BOTTOM_CENTER);
        ImageView imageView = new ImageView(new Image("at_ext_front_door.png"));
        getChildren().addAll(imageView, labelF);
    }

    public void showBack() {
        getChildren().clear();
        Label labelB = new Label("This is the back of the AT building");
        labelB.setFont(Font.font("Arial", 18));
        StackPane.setAlignment(labelB, Pos.BOTTOM_CENTER);
        ImageView imageView = new ImageView(new Image("at_ext_back_door.png"));
        getChildren().addAll(imageView, labelB);
    }
    public void showSide() {
        getChildren().clear();
        Label labelS = new Label("This is the side of the AT building");
        labelS.setFont(Font.font("Arial", 18));
        StackPane.setAlignment(labelS, Pos.BOTTOM_CENTER);
        ImageView imageView = new ImageView(new Image("at_ext_side_door.png"));
        getChildren().addAll(imageView, labelS);
    }
}



