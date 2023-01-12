package Controller;

import Vue.General;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class EventCaptureEcran implements EventHandler<KeyEvent> {
    General general;
    public EventCaptureEcran(General general){
        this.general=general;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        //boutton + pour une capture d'ecran
        if(keyEvent.getCode()== KeyCode.ADD)
            general.imprimerImage();
    }
}
