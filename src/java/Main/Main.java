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

    PreviewApparence preview;
    Scene scene;

    public void start(Stage stage) {
        General general=new General();
        EventDragDrop drag=new EventDragDrop(general);
        EventClickDroit click=new EventClickDroit(general);
        general.setOnDragOver(drag);
        general.setOnDragDropped(drag);
        general.setOnMouseClicked(click);

        // --------
        Classe concrete=Classe.creerClasse("Main.TestDeClasse");
        ClasseApparence apparence=new ClasseApparence(concrete.getNomClasse(),concrete.getAttributs(),concrete.getConstructeurs(),concrete.getMethodes());

        Classe concrete2=Classe.creerClasse("Main.Main");
        ClasseApparence apparence2=new ClasseApparence(concrete2.getNomClasse(),concrete2.getAttributs(),concrete2.getConstructeurs(),concrete2.getMethodes());

        this.preview=new PreviewApparence();

        EventStartDrag sd=new EventStartDrag(apparence,this.preview);
        apparence.setOnDragDetected(sd);
        apparence.setOnMouseReleased(sd);

        EventStartDrag sd2=new EventStartDrag(apparence2,this.preview);
        apparence2.setOnDragDetected(sd2);
        apparence2.setOnMouseReleased(sd2);

        Pane boite=new Pane();
        boite.setPrefSize(800,600);
        boite.getChildren().addAll(apparence,apparence2,this.preview);
        EventMouseFollow mouse=new EventMouseFollow(this.preview);
        // --------
        this.scene=new Scene(general ,800,600);
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
        this.preview.suivre();
    }

    public static void main(String[] args) {
        launch(args);
    }
}