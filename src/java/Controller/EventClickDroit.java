package Controller;

import Modele.Position;
import Vue.General;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Classe Controller permettant de gérer lorsqu'un clic droit est réalisé par l utilisateur
 */

public class EventClickDroit implements EventHandler<MouseEvent> {

    General gen;

    public EventClickDroit(General g){
        this.gen=g;
    }

    public void handle(MouseEvent mouseEvent) {
        String bouton=mouseEvent.getButton().toString();
        // si le bouton pressé est le clic droit
        if(bouton.equals("SECONDARY")){
            // on récupère la position du curseur de la souris de l utilisateur
            Position pos=new Position(mouseEvent.getX(),mouseEvent.getY());
            //event active
        }else{
            //event desactive
        }
    }
}
