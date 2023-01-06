package Modele;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.List;

public class ClasseApparence extends StackPane {

    String nom;
    List<String> attribut, constructor, fonction;
    Boolean suivre;
    int tailleX,tailleY;

    public ClasseApparence(String n, List<String> a,List<String> c, List<String> f) {
        this.nom = n;
        this.attribut = a;
        this.constructor = c;
        this.fonction = f;
        this.suivre=false;
        this.generateFont();
        this.generateInside();
    }

    public void tailler(){
        int hauteur = 1;
        int longueur = 0;
        hauteur += this.attribut.size();
        hauteur += this.fonction.size();
        hauteur += this.constructor.size();
        //---------------------
        longueur=this.nom.length();
        for(int i=0;i<this.attribut.size();i++){
            if(longueur<this.attribut.get(i).length()){
                longueur=this.attribut.get(i).length();
            }
        }
        for(int i=0;i<this.fonction.size();i++){
            if(longueur<this.fonction.get(i).length()){
                longueur=this.fonction.get(i).length();
            }
        }
        for(int i=0;i<this.constructor.size();i++){
            if(longueur<this.constructor.get(i).length()){
                longueur=this.constructor.get(i).length();
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
        //pack.setAlignment(Pos.CENTER);
        Label name=new Label(" "+this.nom);
        Label attri=new Label();
        for(int i=0;i<this.attribut.size();i++){
            if(i==0){
                attri.setText(" "+this.attribut.get(i));
            }else{
                attri.setText(attri.getText()+"\n "+this.attribut.get(i));
            }
        }
        Label constr=new Label();
        for(int i=0;i<this.constructor.size();i++){
            if(i==0){
                constr.setText(" "+this.constructor.get(i));
            }else{
                constr.setText(constr.getText()+"\n "+this.constructor.get(i));
            }
        }
        Label font=new Label();
        for(int i=0;i<this.fonction.size();i++){
            if(i==0){
                font.setText(" "+this.fonction.get(i));
            }else{
                font.setText(font.getText()+"\n "+this.fonction.get(i));
            }
        }
        Rectangle barre=new Rectangle(0,0,tailleX,2);
        barre.setFill(Color.rgb(0,0,0));
        Rectangle barre2=new Rectangle(0,0,tailleX,2);
        barre2.setFill(Color.rgb(0,0,0));
        Rectangle barre3=new Rectangle(0,0,tailleX,2);
        barre3.setFill(Color.rgb(0,0,0));
        pack.getChildren().addAll(name,barre,attri,barre2,constr,barre3,font);
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
