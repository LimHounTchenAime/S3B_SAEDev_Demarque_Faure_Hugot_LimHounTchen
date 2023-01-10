package Main;

import Controller.EventClickDroit;
import Controller.EventDragDrop;
import Controller.EventMouseFollow;
import Controller.EventStartDrag;
import Modele.Classe;
import Modele.ClasseApparence;
import Modele.PreviewApparence;
import Vue.General;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    General general;
    Scene scene;

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
        stage.setScene(this.scene);
        stage.show();
        start();
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

    public static void main(String[] args) {
        launch(args);
    }
}