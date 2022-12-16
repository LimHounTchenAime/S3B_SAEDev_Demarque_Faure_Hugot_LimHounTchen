package Vue;

import Modele.Pointeur;
import Modele.Position;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class General extends Pane {

    Pointeur b;
    Rectangle menu;

    public General(){
        this.b=new Pointeur(new Position(400,300));
        this.menu=new Rectangle(0,0,100,200);
        this.menu.setFill(Color.GREEN);
        this.getChildren().addAll(this.b,this.menu);
    }

    public void actualiser(Position p){
        this.b.deplacer(p);
    }

    public void dropper(Position p){
        this.b.deplacer(p);
    }

    public void update(String s){
        this.b.changerText(s);
    }

    public void mouvement(boolean b){
        this.b.etat(b);
    }

    public void menu(boolean v,Position p){
        this.menu.setVisible(v);
        if(v){
            this.menu.setX(p.X);
            this.menu.setY(p.Y);
        }
    }
}
