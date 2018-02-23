import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * Herb Everett
 */
public class EventHandlingProject2 extends Application {
    private CustomPane customPane = new CustomPane();


    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox hBox = new HBox(20);
        hBox.setAlignment(Pos.CENTER);
        Button btFront = new Button("Front");
        Button btBack = new Button("Back");
        Button btSide = new Button("Side");
        hBox.getChildren().addAll(btFront, btBack, btSide);

        btFront.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                customPane.showFront();
            }
        });

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(hBox);
        borderPane.setCenter(customPane);
        BorderPane.setAlignment(hBox, Pos.CENTER);


        Scene scene = new Scene(borderPane, 500, 400);
        primaryStage.setTitle("AT Building Views");
        primaryStage.setScene(scene);
        primaryStage.show();
        BorderPane pane = new BorderPane();



    }
}
class CustomPane extends StackPane {
    public CustomPane() {
//        getChildren().add(new Label("Test"));

    }

    public void showFront() {
        Pane pane = new HBox(10);
        ImageView imageView = new ImageView(new Image("at_ext_front_door.png"));
        pane.getChildren().add(imageView);
    }
}

