package Controller;

import Modele.PreviewApparence;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class EventMouseFollow implements EventHandler<MouseEvent> {

    PreviewApparence preview;

    public EventMouseFollow(PreviewApparence p){
        this.preview=p;
    }

    public void handle(MouseEvent event) {
        this.preview.updatePos(event.getSceneX(),event.getSceneY());
    }
}
