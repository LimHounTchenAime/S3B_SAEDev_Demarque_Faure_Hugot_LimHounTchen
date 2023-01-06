package Controller;

import Modele.ClasseApparence;
import Modele.PreviewApparence;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class EventStartDrag implements EventHandler<MouseEvent> {

    ClasseApparence app;
    PreviewApparence pre;
    boolean actif;

    public EventStartDrag(ClasseApparence a,PreviewApparence p){
        this.actif=false;
        this.app=a;
        this.pre=p;
    }

    public void handle(MouseEvent event) {
        if (event.getButton().toString().equals("PRIMARY")) {
            if (event.getEventType().toString().equals("DRAG_DETECTED")) {
                if (this.actif == false) {
                    this.app.toFront();
                    this.pre.toFront();
                    this.pre.changerSave(event.getSceneX() - this.app.getLayoutX(), event.getSceneY() - this.app.getLayoutY());
                    this.pre.activerSuivi(app.getTailleX(), app.getTailleY(), true);
                    this.app.changerMod(0, 0);
                    this.actif = true;
                }
            } else if (event.getEventType().toString().equals("MOUSE_RELEASED")) {
                if (this.actif == true) {
                    this.app.toFront();
                    this.pre.toFront();
                    this.pre.activerSuivi(0, 0, false);
                    this.app.changerMod(this.pre.getLayoutX() + 10, this.pre.getLayoutY() + 10);
                    this.actif = false;
                }
            }
        }
    }
}
