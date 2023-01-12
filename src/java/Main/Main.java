package Main;

import Controller.EventCaptureEcran;
import Controller.EventClickDroit;
import Controller.EventDragDrop;
import Controller.EventMouseFollow;
import Vue.General;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static General general;
    private static Scene scene;

    public void start(Stage stage) {

        this.general=new General();
        EventClickDroit ecd=new EventClickDroit(this.general.mcd);
        this.general.setOnMouseClicked(ecd);
        EventDragDrop drag=new EventDragDrop(this.general);
        this.general.setOnDragOver(drag);
        this.general.setOnDragDropped(drag);
        EventMouseFollow mouse=new EventMouseFollow(this.general.getPreview());
        this.scene=new Scene(this.general ,800,600);
        this.scene.setOnMouseDragged(mouse);
        EventCaptureEcran eventCaptureEcran= new EventCaptureEcran(this.general);
        this.scene.setOnKeyPressed(eventCaptureEcran);
        stage.setScene(this.scene);
        stage.show();
        start();
    }

    public static Scene getScene() {
        return scene;
    }

    public void start() {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };
        timer.start();
    }

    public void update(){
        this.general.updatePreview();
    }

    public static General getGeneral() {
        return general;
    }

    public static void main(String[] args) {
        launch(args);
    }
}