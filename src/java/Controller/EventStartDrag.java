package Controller;

import Modele.ClasseApparence;
import Modele.PreviewApparence;
import Vue.General;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Classe Controller permettant de gérer l'action 'glisser' (drag) avec la souris
 */

public class EventStartDrag implements EventHandler<MouseEvent> {

    General gen;
    ClasseApparence app;
    PreviewApparence pre;
    boolean actif;

    public EventStartDrag(ClasseApparence a,PreviewApparence p,General g){
        this.actif=false;
        this.app=a;
        this.gen=g;
        this.pre=p;
    }

    public void handle(MouseEvent event) {
        if (event.getButton().toString().equals("PRIMARY")) {
            // si l'action détectée est 'glisser'
            if (event.getEventType().toString().equals("DRAG_DETECTED")) {
                if (this.actif == false) {
                    this.app.toFront();
                    this.pre.toFront();
                    this.pre.changerSave(event.getSceneX() - this.app.getLayoutX(), event.getSceneY() - this.app.getLayoutY());
                    this.pre.activerSuivi(app.getTailleX(), app.getTailleY(), true);
                    this.app.changerMod(0, 0);
                    // l'action 'glisser' est en cours
                    this.actif = true;
                }
                // si l'appui sur le clic de la souris est relaché
            } else if (event.getEventType().toString().equals("MOUSE_RELEASED")) {
                if (this.actif == true) {
                    this.app.toFront();
                    this.pre.toFront();
                    this.pre.activerSuivi(0, 0, false);
                    this.app.changerMod(this.pre.getLayoutX() + 10, this.pre.getLayoutY() + 10);
                    this.gen.Updatedepot(this.app.getNom());
                    // l'action 'glisser' n'est pas en cours
                    this.actif = false;
                }
            }
        }
    }
}
