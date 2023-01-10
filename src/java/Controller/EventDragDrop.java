package Controller;

import Modele.Position;
import Vue.General;
import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;

/**
 * Classe Controller permettant de gérer lorsque l'utilisateur fait un glisser-déposer (drag and drop) avec sa
 * souris
 */

public class EventDragDrop implements EventHandler<DragEvent> {

    General gen;

    public EventDragDrop(General g){
        this.gen=g;
    }

    public void handle(DragEvent event) {
        String solution=event.getEventType().toString();
        Dragboard db = event.getDragboard();
        // si l'action réalisée est 'glissé vers un autre endroit' (drag)
        if(solution.equals("DRAG_OVER")) {
            // si lorsque l'action a été réalisée avec la souris, il y avait des fichiers sélectionnés
            if (db.hasFiles()) {
                gen.update(db.getFiles().get(0).getName());
                gen.mouvement(true);
                // on récupère la nouvelle position vers laquelle l'on souhaite amener les fichiers
                Position pos = new Position(event.getX(), event.getY());
                gen.actualiser(pos);
            }
            // les fichiers sont transférés ou copiés à cet endroit
            if (event.getGestureSource() != gen && event.getDragboard().hasFiles()) {
                event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
            }
            event.consume();
            // si l'action est 'glissé puis déposer' (drag and drop)
        }else if(solution.equals("DRAG_DROPPED")){
            boolean success = false;
            if (db.hasFiles()) {
                gen.mouvement(false);
                gen.update(db.getFiles().get(0).getName());
                Position pos=new Position(event.getX(),event.getY());
                // les fichiers sont déposés à la nouvelle position
                gen.dropper(pos,db.getFiles().get(0).getName());
                success = true;
            }
            event.setDropCompleted(success);
            event.consume();
        }
    }
}
