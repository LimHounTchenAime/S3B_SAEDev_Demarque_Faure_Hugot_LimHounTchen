package Modele;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.List;

public class ClasseApparence extends StackPane {

    Classe classic;
    Boolean suivre;
    int tailleX,tailleY;

    public ClasseApparence(Classe c) {
        this.classic=c;
        this.suivre=false;
        this.generateFont();
        this.generateInside();
    }

    public void tailler(){
        int hauteur = 3;
        int longueur = 0;
        hauteur += this.classic.getAttributs().size();
        hauteur += this.classic.getMethodes().size();
        hauteur += this.classic.getConstructeurs().size();
        //---------------------
        longueur=this.classic.getNomClasse().length();
        for(int i=0;i<this.classic.getAttributs().size();i++){
            if(longueur<this.classic.getAttributs().get(i).length()){
                longueur=this.classic.getAttributs().get(i).length();
            }
        }
        for(int i=0;i<this.classic.getMethodes().size();i++){
            if(longueur<this.classic.getMethodes().get(i).length()){
                longueur=this.classic.getMethodes().get(i).length();
            }
        }
        for(int i=0;i<this.classic.getConstructeurs().size();i++){
            if(longueur<this.classic.getConstructeurs().get(i).length()){
                longueur=this.classic.getConstructeurs().get(i).length();
            }
        }
        this.tailleX=longueur*6;
        this.tailleY=hauteur*18;
    }

    public void generateFont() {
        this.tailler();
        Rectangle font=new Rectangle(0,0,tailleX,tailleY);
        font.setFill(Color.rgb(255,255,151));
        font.setStroke(Color.rgb(0,0,0));
        font.setStrokeWidth(2);
        this.getChildren().addAll(font);
    }

    public void generateInside(){
        VBox pack=new VBox();
        VBox debut=new VBox();
        debut.setAlignment(Pos.CENTER);
        Label name=new Label(" "+this.classic.getNomClasse());
        Label type=new Label(" <<"+this.classic.getTypeClasse()+">>");
        Label sous=new Label(" "+this.classic.getNomPackage());
        Label attri=new Label();
        for(int i=0;i<this.classic.getAttributs().size();i++){
            if(i==0){
                attri.setText(" "+this.classic.getAttributs().get(i));
            }else{
                attri.setText(attri.getText()+"\n "+this.classic.getAttributs().get(i));
            }
        }
        Label constr=new Label();
        for(int i=0;i<this.classic.getConstructeurs().size();i++){
            if(i==0){
                constr.setText(" "+this.classic.getConstructeurs().get(i));
            }else{
                constr.setText(constr.getText()+"\n "+this.classic.getConstructeurs().get(i));
            }
        }
        Label font=new Label();
        for(int i=0;i<this.classic.getMethodes().size();i++){
            if(i==0){
                font.setText(" "+this.classic.getMethodes().get(i));
            }else{
                font.setText(font.getText()+"\n "+this.classic.getMethodes().get(i));
            }
        }
        Rectangle barre=new Rectangle(0,0,tailleX,2);
        barre.setFill(Color.rgb(0,0,0));
        Rectangle barre2=new Rectangle(0,0,tailleX,2);
        barre2.setFill(Color.rgb(0,0,0));
        Rectangle barre3=new Rectangle(0,0,tailleX,2);
        barre3.setFill(Color.rgb(0,0,0));
        debut.getChildren().addAll(type,name,sous);
        pack.getChildren().addAll(debut,barre,attri,barre2,constr,barre3,font);
        this.getChildren().addAll(pack);
    }

    public void changerMod(double X,double Y){
        this.suivre=!this.suivre;
        if(this.suivre){
            this.setVisible(false);
        }else{
            this.setLayoutX(X);
            this.setLayoutY(Y);
            this.setVisible(true);
        }
    }

    public int getTailleX(){
        return this.tailleX;
    }

    public int getTailleY(){
        return this.tailleY;
    }
}
