package Modele;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


/**
 * Classe s'occupant de l'apparence graphique d'une classe
 */

public class ClasseApparence extends StackPane {

    Classe classic;
    Boolean suivre;
    int tailleX,tailleY;
    boolean prot,pub,priv;

    public ClasseApparence(Classe c) {
        this.prot=true;
        this.pub=true;
        this.priv=true;
        this.classic=c;
        this.suivre=false;
        this.generateFont();
        this.generateInside();
    }


    /**
     * Méthode permettant d'adapter la taille de la classe dans l'interface graphique suivant la longueur
     * de ses informations
     */
    public void tailler(){
        int hauteur = 3;
        int longueur;
        //---------------------
        System.out.println("---");
        System.out.println("debut attri");
        longueur=this.classic.getNomClasse().length()+1;
        int test;
        if(this.classic.getTypeClasse()!=null){
            test= this.classic.getTypeClasse().length()+5;
        }else{
            test=10;
        }
        int test2= this.classic.getNomPackage().length()+1;
        if(longueur<test){
            longueur=test;
        }
        if(longueur<test2){
            longueur=test2;
        }
        for(int i=0;i<this.classic.getAttributs().size();i++){
            if(longueur<this.classic.getAttributs().get(i).length()+1){
                switch (this.classic.getAttributs().get(i).split(" ")[0]) {
                    case "public":
                        if (this.pub) {
                            longueur = this.classic.getAttributs().get(i).length();
                            hauteur += 1;
                            System.out.println(hauteur);
                        }
                        break;
                    case "protected":
                        if (this.prot) {
                            longueur = this.classic.getAttributs().get(i).length();
                            hauteur += 1;
                            System.out.println(hauteur);
                        }
                        break;
                    case "private":
                        if (this.priv) {
                            longueur = this.classic.getAttributs().get(i).length();
                            hauteur += 1;
                            System.out.println(hauteur);
                        }
                        break;
                }
            }
            else{
                hauteur+=1;
            }
        }
        System.out.println("debut method");
        for(int i=0;i<this.classic.getMethodes().size();i++){
            if(longueur<this.classic.getMethodes().get(i).length()+1){
                switch (this.classic.getMethodes().get(i).split(" ")[0]) {
                    case "public":
                        if (this.pub) {
                            longueur = this.classic.getMethodes().get(i).length();
                            hauteur += 1;
                            System.out.println(hauteur);
                        }
                        break;
                    case "protected":
                        if (this.prot) {
                            longueur = this.classic.getMethodes().get(i).length();
                            hauteur += 1;
                            System.out.println(hauteur);
                        }
                        break;
                    case "private":
                        if (this.priv) {
                            longueur = this.classic.getMethodes().get(i).length();
                            hauteur += 1;
                            System.out.println(hauteur);
                        }
                        break;
                }
            }
            else{
                hauteur+=1;
            }
        }
        System.out.println("debut contru");
        for(int i=0;i<this.classic.getConstructeurs().size();i++){
            if(longueur<this.classic.getConstructeurs().get(i).length()+1){
                switch (this.classic.getConstructeurs().get(i).split(" ")[0]) {
                    case "public":
                        if (this.pub) {
                            longueur = this.classic.getConstructeurs().get(i).length();
                            hauteur += 1;
                            System.out.println(hauteur);
                        }
                        break;
                    case "protected":
                        if (this.prot) {
                            longueur = this.classic.getConstructeurs().get(i).length();
                            hauteur += 1;
                            System.out.println(hauteur);
                        }
                        break;
                    case "private":
                        if (this.priv) {
                            longueur = this.classic.getConstructeurs().get(i).length();
                            hauteur += 1;
                            System.out.println(hauteur);
                        }
                        break;
                }
            }
            else{
                hauteur+=1;
            }
        }
        System.out.println("fin");
        if(!this.prot){
            hauteur+=1;
        }
        if(!this.pub){
            hauteur+=1;
        }
        if(!this.priv){
            hauteur+=1;
        }
        this.tailleX=longueur*6;
        this.tailleY=hauteur*18;
        System.out.println(hauteur+" : "+longueur);
    }


    /**
     * Methode permettant de générer le fond de la classe sur l'interface graphique
     */
    public void generateFont() {
        this.tailler();
        Rectangle font=new Rectangle(0,0,tailleX,tailleY);
        font.setFill(Color.rgb(255,255,151));
        font.setStroke(Color.rgb(0,0,0));
        font.setStrokeWidth(2);
        this.getChildren().addAll(font);
    }


    /**
     * Methode permettant de générer l'intérieur de la classe dans l'interface graphique
     */
    public void generateInside(){
        VBox pack=new VBox();
        VBox debut=new VBox();
        debut.setAlignment(Pos.CENTER);
        // affichage de ses informations telles que son nom, son type et son package
        Label name=new Label(" "+this.classic.getNomClasse()+" ");
        Label type=new Label(" <<"+this.classic.getTypeClasse()+">> ");
        Label sous=new Label(" "+this.classic.getNomPackage()+" ");
        Label attri=new Label();
        // affichage des attributs
        for(int i=0;i<this.classic.getAttributs().size();i++) {
            switch (this.classic.getAttributs().get(i).split(" ")[0]) {
                case "public":
                    if (this.pub) {
                        if (attri.getText().equals("")) {
                            attri.setText(" " + this.classic.getAttributs().get(i)+" ");
                        } else {
                            attri.setText(attri.getText() + "\n " + this.classic.getAttributs().get(i)+" ");
                        }
                    }
                    break;
                case "protected":
                    if (this.prot) {
                        if (attri.getText().equals("")) {
                            attri.setText(" " + this.classic.getAttributs().get(i)+" ");
                        } else {
                            attri.setText(attri.getText() + "\n " + this.classic.getAttributs().get(i)+" ");
                        }
                    }
                    break;
                case "private":
                    if (this.priv) {
                        if (attri.getText().equals("")) {
                            attri.setText(" " + this.classic.getAttributs().get(i)+" ");
                        } else {
                            attri.setText(attri.getText() + "\n " + this.classic.getAttributs().get(i)+" ");
                        }
                    }
                    break;
            }
        }
        // affichage des constructeurs
        Label constr=new Label();
        for(int i=0;i<this.classic.getConstructeurs().size();i++){
            switch (this.classic.getConstructeurs().get(i).split(" ")[0]) {
                case "public":
                    if (this.pub) {
                        if (constr.getText().equals("")) {
                            constr.setText(" " + this.classic.getConstructeurs().get(i)+" ");
                        } else {
                            constr.setText(constr.getText() + "\n " + this.classic.getConstructeurs().get(i)+" ");
                        }
                    }
                    break;
                case "protected":
                    if (this.prot) {
                        if (constr.getText().equals("")) {
                            constr.setText(" " + this.classic.getConstructeurs().get(i)+" ");
                        } else {
                            constr.setText(constr.getText() + "\n " + this.classic.getConstructeurs().get(i)+" ");
                        }
                    }
                    break;
                case "private":
                    if (this.priv) {
                        if (constr.getText().equals("")) {
                            constr.setText(" " + this.classic.getConstructeurs().get(i)+" ");
                        } else {
                            constr.setText(constr.getText() + "\n " + this.classic.getConstructeurs().get(i)+" ");
                        }
                    }
                    break;
            }
        }
        // affichage de ses methodes
        Label font=new Label();
        for(int i=0;i<this.classic.getMethodes().size();i++){
            switch (this.classic.getMethodes().get(i).split(" ")[0]) {
                case "public":
                    if (this.pub) {
                        if (font.getText().equals("")) {
                            font.setText(" " + this.classic.getMethodes().get(i)+" ");
                        } else {
                            font.setText(font.getText() + "\n " + this.classic.getMethodes().get(i)+" ");
                        }
                    }
                    break;
                case "protected":
                    if (this.prot) {
                        if (font.getText().equals("")) {
                            font.setText(" " + this.classic.getMethodes().get(i)+" ");
                        } else {
                            font.setText(font.getText() + "\n " + this.classic.getMethodes().get(i)+" ");
                        }
                    }
                    break;
                case "private":
                    if (this.priv) {
                        if (font.getText().equals("")) {
                            font.setText(" " + this.classic.getMethodes().get(i)+" ");
                        } else {
                            font.setText(font.getText() + "\n " + this.classic.getMethodes().get(i)+" ");
                        }
                    }
                    break;
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

    public void eteindre(int num,boolean status){
        switch(num){
            case 0:
                this.prot=status;
                break;
            case 1:
                this.pub=status;
                break;
            case 2:
                this.priv=status;
                break;
        }
        this.getChildren().clear();
        this.generateFont();
        this.generateInside();
    }
}
