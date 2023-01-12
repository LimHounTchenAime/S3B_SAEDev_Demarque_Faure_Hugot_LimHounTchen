package Vue;

import Controller.EventClickDroit;
import Controller.EventMouseFollow;
import Controller.EventStartDrag;
import Modele.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class General extends Pane {

    Pointeur b;
    PreviewApparence preview;
    ArrayList<String> present;
    public MenuClickDroit mcd;
    ArrayList<ClasseApparence> contenu;
    ArrayList<Fleche> contenuFleche;

    public General(){
        this.contenu=new ArrayList<>();
        this.contenuFleche = new ArrayList<>();
        this.mcd=new MenuClickDroit(this);
        this.getChildren().addAll(this.mcd);
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

    public void dropper(Position p,String m,String n){
        System.out.println(m);
        System.out.println(m+"." + n.replace(".java", ""));
        if(!(this.present.contains(n))) {
            Classe concrete = Classe.creerClasse(m+"." + n.replace(".java", ""));
            ClasseApparence apparence = new ClasseApparence(concrete);
            apparence.setLayoutX(p.X);
            apparence.setLayoutY(p.Y);
            EventStartDrag sd = new EventStartDrag(apparence, this.preview,this);
            apparence.setOnDragDetected(sd);
            apparence.setOnMouseReleased(sd);


            ClasseApparence classeApparenceParent = null;
            Line line = null;
            int a=0;
            while(line==null && a<this.contenu.size()){
                classeApparenceParent = this.contenu.get(a);
                if(classeApparenceParent.getClassic().getNomClasse().equals(concrete.getParents().getNomClasse())){
                    Fleche flecheParent = Fleche.creerFleche(apparence, classeApparenceParent);
                    this.getChildren().add(flecheParent);
                    flecheParent.toBack();
                    this.contenuFleche.add(flecheParent);
                } else { a++; }
            }

            this.getChildren().addAll(apparence);
            this.contenu.add(apparence);
            this.present.add(n);
        }
    }

    public void activerMenu(int num,boolean status){
        for(int i=0;i<this.contenu.size();i++){
            this.contenu.get(i).eteindre(num,status);
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

    public void Updatedepot(String nom){
        if(!this.contenu.isEmpty() && !this.contenuFleche.isEmpty()){
            Fleche f = null;
            int a = 0;
            System.out.println("oui");
            while(a<this.contenuFleche.size() && f == null){
                if(this.contenuFleche.get(a).getClasseParent().getNomClasse().equals(nom)){
                    f = this.contenuFleche.get(a);
                } else {
                    a++;
                }
            }

            System.out.println("oui");
            ClasseApparence cf = null;
            ClasseApparence cp = null;

            int b = 0;

            while(b<this.contenu.size() && cf == null){
                String nomCaf=this.contenu.get(b).getClassic().getNomClasse();
                if(nomCaf.equals(f.getClasseFils().getNomClasse())){
                    cf = this.contenu.get(b);
                } else {
                    b++;
                }
            }

            System.out.println("oui");
            int i = 0;
            while(i<this.contenu.size() && cp == null){
                String nomCap=this.contenu.get(i).getClassic().getNomClasse();
                if(nomCap.equals(f.getClasseParent().getNomClasse())){
                    cp = this.contenu.get(i);
                } else {
                    i++;
                }
            }

            System.out.println("oui");
            f.calculerPosition(cf,cp);
            System.out.println("oui");
            this.contenuFleche.set(a,f);
        }

    }
}

