package Controller;

import Modele.MenuClickDroit;
import Modele.Position;
import Vue.General;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * Classe Controller permettant de gérer la séléction des choix d'un menu lors d'un clic de souris
 */

public class EventSelectMenu implements EventHandler<MouseEvent> {

    StackPane presence;
    String nom;
    String[] liste={"Package","Private","Protected","Public","Static","All","None"};
    MenuClickDroit mcd;

    public EventSelectMenu(StackPane p, String n, MenuClickDroit m){
        this.presence=p;
        this.nom=n;
        this.mcd=m;
    }

    public void handle(MouseEvent mouseEvent) {
        String bouton=mouseEvent.getButton().toString();
        // si un choix du menu est séléctionné (un clic gauche est réalisé sur le bouton correspondant
        if(bouton.equals("PRIMARY")) {
            // selon le nom du bouton, soit le choix séléctionné, une action du menu correspondante est réalisée
            switch(this.nom){
                case "Package":
                    this.mcd.activate(0);
                    break;
                case "Private":
                    this.mcd.activate(1);
                    break;
                case "Protected":
                    this.mcd.activate(2);
                    break;
                case "Public":
                    this.mcd.activate(3);
                    break;
                case "Static":
                    this.mcd.activate(4);
                    break;
                case "All":
                    this.mcd.activate(5);
                    break;
                case "None":
                    this.mcd.activate(6);
                    break;
            }
        }
    }
}
