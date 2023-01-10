package Controller;

import Modele.MenuClickDroit;
import Modele.Position;
import Vue.General;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class EventClickDroit implements EventHandler<MouseEvent> {

    MenuClickDroit mcd;

    public EventClickDroit(MenuClickDroit g){
        this.mcd =g;
    }

    public void handle(MouseEvent mouseEvent) {
        String bouton=mouseEvent.getButton().toString();
        if(bouton.equals("SECONDARY")){
            this.mcd.setLayoutX(mouseEvent.getSceneX());
            this.mcd.setLayoutY(mouseEvent.getSceneY());
            this.mcd.inverser(true);
        }else{
            this.mcd.inverser(false);
        }
    }
}
