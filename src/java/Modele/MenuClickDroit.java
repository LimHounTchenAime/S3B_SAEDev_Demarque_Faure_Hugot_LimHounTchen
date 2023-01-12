package Modele;

import Controller.EventSelectMenu;
import Vue.General;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

/**
 * Classe générant un menu avec différentes options qui apparaissent après un clic droit dans l'interface
 * graphique de l'application
 */

public class MenuClickDroit extends VBox {

    String[] liste={"Package","Private","Protected","Public","Static","All","None"};
    ArrayList<CheckBox> packet;
    General gen;

    public MenuClickDroit(General g){
        this.gen=g;
        this.packet=new ArrayList<>();
        String[] liste={"Package","Private","Protected","Public","Static","All","None"};
        for(int i=0;i<7;i++){
            HBox fin=new HBox();
            CheckBox check=new CheckBox();
            check.setDisable(true);
            check.setStyle("-fx-opacity: 1");
            packet.add(check);
            Rectangle font=new Rectangle(0,0,100,20);
            font.setFill(Color.rgb(235,235,235));
            Label premiere=new Label(liste[i]);
            StackPane uno=new StackPane();
            fin.getChildren().addAll(check,premiere);
            uno.getChildren().addAll(font,fin);
            EventSelectMenu es1=new EventSelectMenu(uno,liste[i],this);
            uno.setOnMouseClicked(es1);
            this.getChildren().addAll(uno);
        }
        this.setVisible(false);
    }

    public void inverser(boolean b){
        this.setVisible(b);
    }

    /**
     * Méthode permettant d'activer l'action correspondant au choix parmi les différentes possibilitées du menu
     * @param choix numéro du choix correspondant au menu (dans l'ordre)
     */
    public void activate(int choix){
        this.gen.activerMenu(choix,this.packet.get(choix).isSelected());
        if(choix==6){
            for(int i=0;i<this.packet.size()-1;i++){
                if(this.packet.get(i).isSelected()){
                    this.packet.get(i).setDisable(false);
                    this.packet.get(i).fire();
                    this.packet.get(i).setDisable(true);
                }
            }
        }else if (choix==5){
            for(int i=0;i<this.packet.size()-2;i++){
                if(!this.packet.get(i).isSelected()){
                    this.packet.get(i).setDisable(false);
                    this.packet.get(i).fire();
                    this.packet.get(i).setDisable(true);
                }
            }
        }
        if(this.packet.get(6).isSelected()){
            this.packet.get(6).setDisable(false);
            this.packet.get(6).fire();
            this.packet.get(6).setDisable(true);
        }
        if(this.packet.get(5).isSelected()){
            this.packet.get(5).setDisable(false);
            this.packet.get(5).fire();
            this.packet.get(5).setDisable(true);
        }
        this.packet.get(choix).setDisable(false);
        this.packet.get(choix).fire();
        this.packet.get(choix).setDisable(true);
    }
}
