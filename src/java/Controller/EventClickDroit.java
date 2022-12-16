package Controller;

import Modele.Position;
import Vue.General;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class EventClickDroit implements EventHandler<MouseEvent> {

    General gen;

    public EventClickDroit(General g){
        this.gen=g;
    }

    public void handle(MouseEvent mouseEvent) {
        String bouton=mouseEvent.getButton().toString();
        if(bouton.equals("SECONDARY")){
            Position pos=new Position(mouseEvent.getX(),mouseEvent.getY());
            this.gen.menu(true,pos);
        }else{
            this.gen.menu(false,null);
        }
    }
}
