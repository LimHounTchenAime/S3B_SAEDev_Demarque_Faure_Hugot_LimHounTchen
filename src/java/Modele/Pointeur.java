package Modele;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * Classe représentant un pointeur dans l'interface graphique
 */

public class Pointeur extends StackPane {

    Circle c;
    Label l;
    public Position p;
    Rectangle t;

    public Pointeur(Position p){
        this.setVisible(false);
        this.p=p;
        this.setLayoutX(this.p.X);
        this.setLayoutY(this.p.Y);
        this.c=new Circle(this.p.X,this.p.Y,20, Color.RED);
        this.l=new Label("Vide");
        this.t=new Rectangle(this.getLayoutX(),this.getLayoutY(),100,100);
        this.t.setFill(Color.TRANSPARENT);
        this.getChildren().addAll(t,c,l);
    }


    /**
     * Méthode permettant de changer le texte du pointeur
     * @param s texte à changer
     */
    public void changerText(String s){
        this.l.setText(s);
        this.t.setWidth(this.getWidth());
        this.t.setWidth(this.getHeight());
    }

    /**
     * Méthode permettant de déplacer le pointeur
     * @param p position à déduire de la position actuelle du pointeur
     */

    public void deplacer(Position p){
        this.p.X=p.X;
        this.p.Y=p.Y;
        double numX=p.X-this.getWidth()/2;
        double numY=p.Y-this.getHeight()/2;
        this.setLayoutX(numX);
        this.setLayoutY(numY);
        this.t.setX(this.getLayoutX());
        this.t.setY(this.getLayoutY());
    }

    public void etat(boolean b){
        this.setVisible(b);
    }
}
