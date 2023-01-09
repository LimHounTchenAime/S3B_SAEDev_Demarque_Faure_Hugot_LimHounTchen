package Vue;

import Controller.EventMouseFollow;
import Controller.EventStartDrag;
import Modele.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class General extends Pane {

    Pointeur b;
    PreviewApparence preview;
    ArrayList<String> present;

    public General(){
        this.present=new ArrayList<>();
        this.preview=new PreviewApparence();
        this.b=new Pointeur(new Position(400,300));
        this.getChildren().addAll(this.b,this.preview);
    }

    public PreviewApparence getPreview(){
        return this.preview;
    }

    public void actualiser(Position p){
        this.b.deplacer(p);
    }

    public void dropper(Position p,String n){
        if(!(this.present.contains(n))) {
            Classe concrete = Classe.creerClasse("Main." + n.replace(".java", ""));
            ClasseApparence apparence = new ClasseApparence(concrete.getNomClasse(), concrete.getAttributs(), concrete.getConstructeurs(), concrete.getMethodes());
            apparence.setLayoutX(p.X);
            apparence.setLayoutY(p.Y);
            EventStartDrag sd = new EventStartDrag(apparence, this.preview);
            apparence.setOnDragDetected(sd);
            apparence.setOnMouseReleased(sd);
            this.getChildren().addAll(apparence);
            this.present.add(n);
        }
    }

    public void update(String s){
        this.b.changerText(s);
    }

    public void mouvement(boolean b){
        this.b.etat(b);
    }

    public void updatePreview(){
        this.preview.suivre();
    }
}
