package game.Main;

import game.Controller.EventClickDroit;
import game.Controller.EventDragDrop;
import game.Vue.General;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public void start(Stage stage) {
        General general=new General();
        Scene scene=new Scene(general ,800,600);
        EventDragDrop drag=new EventDragDrop(general);
        EventClickDroit click=new EventClickDroit(general);
        general.setOnDragOver(drag);
        general.setOnDragDropped(drag);
        general.setOnMouseClicked(click);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
