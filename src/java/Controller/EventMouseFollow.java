package Controller;

import Modele.PreviewApparence;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Classe Controller permettant d'actualiser la position de la souris (soit son curseur)
 */

public class EventMouseFollow implements EventHandler<MouseEvent> {

    PreviewApparence preview;

    public EventMouseFollow(PreviewApparence p){
        this.preview=p;
    }

    // on récupère la position dans le cas où la souris réalise un mouvement
    public void handle(MouseEvent event) {
        this.preview.updatePos(event.getSceneX(),event.getSceneY());
    }
}
