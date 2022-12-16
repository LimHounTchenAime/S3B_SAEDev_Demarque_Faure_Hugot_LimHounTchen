package Controller;

import Modele.Position;
import Vue.General;
import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;

public class EventDragDrop implements EventHandler<DragEvent> {

    General gen;

    public EventDragDrop(General g){
        this.gen=g;
    }

    public void handle(DragEvent event) {
        String solution=event.getEventType().toString();
        Dragboard db = event.getDragboard();
        if(solution.equals("DRAG_OVER")) {
            if (db.hasFiles()) {
                gen.update(db.getFiles().get(0).getName());
                gen.mouvement(true);
                Position pos = new Position(event.getX(), event.getY());
                gen.actualiser(pos);
            }
            if (event.getGestureSource() != gen && event.getDragboard().hasFiles()) {
                event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
            }
            event.consume();
        }else if(solution.equals("DRAG_DROPPED")){
            boolean success = false;
            if (db.hasFiles()) {
                gen.mouvement(false);
                gen.update(db.getFiles().get(0).getName());
                Position pos=new Position(event.getX(),event.getY());
                gen.dropper(pos);
                success = true;
            }
            event.setDropCompleted(success);
            event.consume();
        }
    }
}
