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

//            Fleche flecheParent = Fleche.creerFleche(concrete,concrete.getParents());
//            ClasseApparence classeApparenceParent = null;
//            Line line = null;
//            int a=0;
//            while(line==null && a<this.contenu.size()){
//                if(this.contenu.get(a).getClassic().getNomClasse() == concrete.getParents().getNomClasse()){
////                    classeApparenceParent = this.contenu.get(a);
//                    double cax = apparence.getLayoutX()+apparence.getTailleX()/2;
//                    double cay = apparence.getLayoutY()+apparence.getTailleY()/2;
//                    double capx = this.contenu.get(a).getLayoutX()+(this.contenu.get(a).getTailleX()/2);
//                    double capy = this.contenu.get(a).getLayoutY()+(this.contenu.get(a).getTailleY()/2);
//                    line = new Line(cax, cay, capx, capy);
//                    this.getChildren().add(line);
//                } else { a++; }
//            }

            if(concrete.getParents()!=null){
                Classe parent = Classe.creerClasse(concrete.getParents().getNomPackage()+"."+concrete.getParents().getNomClasse());
                ClasseApparence cap = new ClasseApparence(parent);
                if(this.contenu.contains(cap)){
                    double cax = apparence.getLayoutX()+apparence.getTailleX()/2;
                    double cay = apparence.getLayoutY()+apparence.getTailleY()/2;
                    double capx = cap.getLayoutX()+(cap.getTailleX()/2);
                    double capy = cap.getLayoutY()+(cap.getTailleY()/2);
                    Line line = new Line(cax, cay, capx, capy);
                    this.getChildren().add(line);
                }

            }

//            if(classeApparenceParent!=null){
//                double cax = apparence.getLayoutX()+apparence.getTailleX()/2;
//                double cay = apparence.getLayoutY()+apparence.getTailleY()/2;
//                double capx = classeApparenceParent.getLayoutX()+(classeApparenceParent.getTailleX()/2);
//                double capy = classeApparenceParent.getLayoutY()+(classeApparenceParent.getTailleY()/2);
//                Line line = new Line(cax, cay, capx, capy);
//                Line line = new Line(50,50,100,50);
//                Polygon triangle = new Polygon(40,40 ,45,55, 55,45);
//                triangle.setStroke(Color.BLACK);
//                triangle.setFill(Color.WHITE);
//                flecheParent.getChildren().addAll(line);


//                this.getChildren().add(line);
//            }

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

    }
}
