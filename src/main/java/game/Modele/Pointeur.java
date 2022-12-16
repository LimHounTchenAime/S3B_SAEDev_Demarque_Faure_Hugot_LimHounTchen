package game.Modele;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Pointeur extends StackPane {

    Circle c;
    Label l;
    public Position p;
    Rectangle t;

    public Pointeur(Position p){
        this.p=p;
        this.setLayoutX(this.p.X);
        this.setLayoutY(this.p.Y);
        this.c=new Circle(this.p.X,this.p.Y,20, Color.RED);
        this.l=new Label("Vide");
        this.t=new Rectangle(this.getLayoutX(),this.getLayoutY(),100,100);
        this.t.setFill(Color.TRANSPARENT);
        this.getChildren().addAll(t,c,l);
    }

    public void changerText(String s){
        this.l.setText(s);
        this.t.setWidth(this.getWidth());
        this.t.setWidth(this.getHeight());
    }

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
        if(b){
            this.c.setFill(Color.RED);
            this.c.setRadius(20);
            this.t.setWidth(this.getWidth());
            this.t.setWidth(this.getHeight());
        }else{
            this.c.setFill(Color.BLUE);
            this.c.setRadius(40);
            this.t.setWidth(this.getWidth());
            this.t.setWidth(this.getHeight());
        }
    }
}
