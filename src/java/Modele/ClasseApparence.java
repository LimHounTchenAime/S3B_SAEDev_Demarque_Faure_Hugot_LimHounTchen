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
    int tailleX, tailleY;
    boolean prot, pub, priv, pack, stat;


    public ClasseApparence(Classe c) {
        this.prot = true;
        this.pub = true;
        this.priv = true;
        this.pack = true;
        this.stat = true;
        this.classic = c;
        this.suivre = false;
        this.generateFont();
        this.generateInside();
    }


    /**
     * Méthode permettant d'adapter la taille de la classe dans l'interface graphique suivant la longueur
     * de ses informations
     */
    public void tailler() {
        int hauteur = 3;
        int longueur;
        //---------------------
        System.out.println("---" + this.classic.getNomClasse() + "---");
        longueur = this.classic.getNomClasse().length() + 1;
        int test;
        int savestat;
        // La taille est adaptée selon que la classe ait un type spécifié ou non
        if (this.classic.getTypeClasse() != null) {
            test = this.classic.getTypeClasse().length() + 11;
        } else {
            test = 16;
        }
        int test2 = this.classic.getNomPackage().length() + 1;
        if (longueur < test) {
            longueur = test;
        }
        if (longueur < test2) {
            longueur = test2;
        }
        savestat = hauteur;
        // s'il n'y a pas d'attributs à gérer
        if (this.classic.getAttributs().size() == 0) {
            hauteur += 1;
        }
        for (int i = 0; i < this.classic.getAttributs().size(); i++) {
            if (longueur < this.classic.getAttributs().get(i).length() + 1) {
                switch (this.classic.getAttributs().get(i).split(" ")[0]) {
                    // si les attributs de la classe sont publiques
                    case "public":
                    default:
                        if (this.pub) {
                            if (this.classic.getAttributs().get(i).split(" ")[1].equals("static")) {
                                if (this.stat) {
                                    longueur = this.classic.getAttributs().get(i).length();
                                }
                            } else {
                                longueur = this.classic.getAttributs().get(i).length();
                            }
                        }
                        break;
                    // si il sont protégés
                    case "protected":
                        if (this.prot) {
                            if (this.classic.getAttributs().get(i).split(" ")[1].equals("static")) {
                                if (this.stat) {
                                    longueur = this.classic.getAttributs().get(i).length();
                                }
                            } else {
                                longueur = this.classic.getAttributs().get(i).length();
                            }
                        }
                        break;
                    // si ils sont privés
                    case "private":
                        if (this.priv) {
                            if (this.classic.getAttributs().get(i).split(" ")[1].equals("static")) {
                                if (this.stat) {
                                    longueur = this.classic.getAttributs().get(i).length();
                                }
                            } else {
                                longueur = this.classic.getAttributs().get(i).length();
                            }
                        }
                        break;
                }
            }
            switch (this.classic.getAttributs().get(i).split(" ")[0]) {
                default:
                // si les attributs sont publiques
                case "public":
                    if (this.pub) {
                        if (this.classic.getAttributs().get(i).split(" ")[1].equals("static")) {
                            if (this.stat) {
                                hauteur += 1;
                            }
                        } else {
                            hauteur += 1;
                        }
                    }
                    break;
                // s'ils sont protégés
                case "protected":
                    if (this.prot) {
                        if (this.classic.getAttributs().get(i).split(" ")[1].equals("static")) {
                            if (this.stat) {
                                hauteur += 1;
                            }
                        } else {
                            hauteur += 1;
                        }
                    }
                    break;
                // s'ils sont privés
                case "private":
                    if (this.priv) {
                        if (this.classic.getAttributs().get(i).split(" ")[1].equals("static")) {
                            if (this.stat) {
                                hauteur += 1;
                            }
                        } else {
                            hauteur += 1;
                        }
                    }
                    break;
            }
        }
        if (hauteur == savestat) {
            hauteur += 1;
        }
        savestat = hauteur;
        System.out.println("hauteur attribut : " + hauteur);

        // s'il n'y a pas de constructeur à gérer
        if (this.classic.getConstructeurs().size() == 0) {
            hauteur += 1;
        }
        // sinon
        for (int i = 0; i < this.classic.getConstructeurs().size(); i++) {
            if (longueur < this.classic.getConstructeurs().get(i).length() + 1) {
                switch (this.classic.getConstructeurs().get(i).split(" ")[0]) {
                    default:
                    // si les constructeurs sont publiques
                    case "public":
                        if (this.pub) {
                            if (this.classic.getConstructeurs().get(i).split(" ")[1].equals("static")) {
                                if (this.stat) {
                                    longueur = this.classic.getConstructeurs().get(i).length();
                                }
                            } else {
                                longueur = this.classic.getConstructeurs().get(i).length();
                            }
                        }
                        break;
                    // s'ils sont protégés
                    case "protected":
                        if (this.prot) {
                            if (this.classic.getConstructeurs().get(i).split(" ")[1].equals("static")) {
                                if (this.stat) {
                                    longueur = this.classic.getConstructeurs().get(i).length();
                                }
                            } else {
                                longueur = this.classic.getConstructeurs().get(i).length();
                            }
                        }
                        break;
                    // s'ils sont privés
                    case "private":
                        if (this.priv) {
                            if (this.classic.getConstructeurs().get(i).split(" ")[1].equals("static")) {
                                if (this.stat) {
                                    longueur = this.classic.getConstructeurs().get(i).length();
                                }
                            } else {
                                longueur = this.classic.getConstructeurs().get(i).length();
                            }
                        }
                        break;
                }
            }
            switch (this.classic.getConstructeurs().get(i).split(" ")[0]) {
                default:
                // s'ils sont publiques
                case "public":
                    if (this.pub) {
                        if (this.classic.getConstructeurs().get(i).split(" ")[1].equals("static")) {
                            if (this.stat) {
                                hauteur += 1;
                            }
                        } else {
                            hauteur += 1;
                        }
                    }
                    break;
                // s'ils sont protégés
                case "protected":
                    if (this.prot) {
                        if (this.classic.getConstructeurs().get(i).split(" ")[1].equals("static")) {
                            if (this.stat) {
                                hauteur += 1;
                            }
                        } else {
                            hauteur += 1;
                        }
                    }
                    break;
                // s'ils sont privés
                case "private":
                    if (this.priv) {
                        if (this.classic.getConstructeurs().get(i).split(" ")[1].equals("static")) {
                            if (this.stat) {
                                hauteur += 1;
                            }
                        } else {
                            hauteur += 1;
                        }
                    }
                    break;
            }
        }
        if (hauteur == savestat) {
            hauteur += 1;
        }
        savestat = hauteur;
        System.out.println("hauteur constructeur : " + hauteur);
        // s'il n'y a pas de méthodes à gérer
        if (this.classic.getMethodes().size() == 0) {
            hauteur += 1;
        }
        // sinon
        for (int i = 0; i < this.classic.getMethodes().size(); i++) {
            if (longueur < this.classic.getMethodes().get(i).length() + 1) {
                switch (this.classic.getMethodes().get(i).split(" ")[0]) {
                    default:
                    // si les méthodes sont publiques
                    case "public":
                        if (this.pub) {
                            if (this.classic.getMethodes().get(i).split(" ")[1].equals("static")) {
                                if (this.stat) {
                                    longueur = this.classic.getMethodes().get(i).length();
                                }
                            } else {
                                longueur = this.classic.getMethodes().get(i).length();
                            }
                        }
                        break;
                    // si elles sont protégées
                    case "protected":
                        if (this.prot) {
                            longueur = this.classic.getMethodes().get(i).length();
                        }
                        break;
                    // si elles sont privées
                    case "private":
                        if (this.priv) {
                            longueur = this.classic.getMethodes().get(i).length();
                        }
                        break;
                }
            }
            switch (this.classic.getMethodes().get(i).split(" ")[0]) {
                default:
                // si elles sont publiques
                case "public":
                    if (this.pub) {
                        if (this.classic.getMethodes().get(i).split(" ")[1].equals("static")) {
                            if (this.stat) {
                                hauteur += 1;
                            }
                        } else {
                            hauteur += 1;
                        }
                    }
                    break;
                // si elles sont protégées
                case "protected":
                    if (this.prot) {
                        if (this.classic.getMethodes().get(i).split(" ")[1].equals("static")) {
                            if (this.stat) {
                                hauteur += 1;
                            }
                        } else {
                            hauteur += 1;
                        }
                    }
                    break;
                // si elles sont privées
                case "private":
                    if (this.priv) {
                        if (this.classic.getMethodes().get(i).split(" ")[1].equals("static")) {
                            if (this.stat) {
                                hauteur += 1;
                            }
                        } else {
                            hauteur += 1;
                        }
                    }
                    break;
            }
        }
        if (hauteur == savestat) {
            hauteur += 1;
        }
        System.out.println("hauteur methode : " + hauteur);
        this.tailleX = longueur * 6;
        this.tailleY = hauteur * 18;
        System.out.println("Taille finale de la classe");
        System.out.println(hauteur + " : " + longueur);
    }


    /**
     * Methode permettant de générer le fond de la classe sur l'interface graphique
     */
    public void generateFont() {
        this.tailler();
        Rectangle font = new Rectangle(0, 0, tailleX, tailleY);
        font.setFill(Color.rgb(255, 255, 151));
        font.setStroke(Color.rgb(0, 0, 0));
        font.setStrokeWidth(2);
        this.getChildren().addAll(font);
    }


    /**
     * Methode permettant de générer l'intérieur de la classe dans l'interface graphique
     */
    public void generateInside() {
        VBox pack = new VBox();
        VBox debut = new VBox();
        debut.setAlignment(Pos.CENTER);
        // affichage de ses informations telles que son nom, son type et son package
        Label name = new Label(" " + this.classic.getNomClasse() + " ");
        Label type = new Label(" << Java" + this.classic.getTypeClasse() + ">> ");
        Label sous = new Label(" " + this.classic.getNomPackage() + " ");
        Label attri = new Label();
        // affichage des attributs
        for (int i = 0; i < this.classic.getAttributs().size(); i++) {
            switch (this.classic.getAttributs().get(i).split(" ")[0]) {
                default:
                case "public":
                    if (this.pub) {
                        if (this.classic.getAttributs().get(i).split(" ")[1].equals("static")) {
                            if (this.stat) {
                                if (attri.getText().equals("")) {
                                    attri.setText(" " + this.classic.getAttributs().get(i) + " ");
                                } else {
                                    attri.setText(attri.getText() + "\n " + this.classic.getAttributs().get(i) + " ");
                                }
                            }
                        }else{
                            if (attri.getText().equals("")) {
                                attri.setText(" " + this.classic.getAttributs().get(i) + " ");
                            } else {
                                attri.setText(attri.getText() + "\n " + this.classic.getAttributs().get(i) + " ");
                            }
                        }
                    }
                    break;
                case "protected":
                    if (this.prot) {
                        if (this.classic.getAttributs().get(i).split(" ")[1].equals("static")) {
                            if (this.stat) {
                                if (attri.getText().equals("")) {
                                    attri.setText(" " + this.classic.getAttributs().get(i) + " ");
                                } else {
                                    attri.setText(attri.getText() + "\n " + this.classic.getAttributs().get(i) + " ");
                                }
                            }
                        }else{
                            if (attri.getText().equals("")) {
                                attri.setText(" " + this.classic.getAttributs().get(i) + " ");
                            } else {
                                attri.setText(attri.getText() + "\n " + this.classic.getAttributs().get(i) + " ");
                            }
                        }
                    }
                    break;
                case "private":
                    if (this.priv) {
                        if (this.classic.getAttributs().get(i).split(" ")[1].equals("static")) {
                            if (this.stat) {
                                if (attri.getText().equals("")) {
                                    attri.setText(" " + this.classic.getAttributs().get(i) + " ");
                                } else {
                                    attri.setText(attri.getText() + "\n " + this.classic.getAttributs().get(i) + " ");
                                }
                            }
                        }else{
                            if (attri.getText().equals("")) {
                                attri.setText(" " + this.classic.getAttributs().get(i) + " ");
                            } else {
                                attri.setText(attri.getText() + "\n " + this.classic.getAttributs().get(i) + " ");
                            }
                        }
                    }
                    break;
            }
        }
        // affichage des constructeurs
        Label constr = new Label();
        for (int i = 0; i < this.classic.getConstructeurs().size(); i++) {
            switch (this.classic.getConstructeurs().get(i).split(" ")[0]) {
                default:
                case "public":
                    if (this.pub) {
                        if (this.classic.getConstructeurs().get(i).split(" ")[1].equals("static")) {
                            if (this.stat) {
                                if (constr.getText().equals("")) {
                                    constr.setText(" " + this.classic.getConstructeurs().get(i) + " ");
                                } else {
                                    constr.setText(constr.getText() + "\n " + this.classic.getConstructeurs().get(i) + " ");
                                }
                            }
                        }else{
                            if (constr.getText().equals("")) {
                                constr.setText(" " + this.classic.getConstructeurs().get(i) + " ");
                            } else {
                                constr.setText(constr.getText() + "\n " + this.classic.getConstructeurs().get(i) + " ");
                            }
                        }
                    }
                    break;
                case "protected":
                    if (this.prot) {
                            if (this.classic.getConstructeurs().get(i).split(" ")[1].equals("static")) {
                                if (this.stat) {
                                    if (constr.getText().equals("")) {
                                        constr.setText(" " + this.classic.getConstructeurs().get(i) + " ");
                                    } else {
                                        constr.setText(constr.getText() + "\n " + this.classic.getConstructeurs().get(i) + " ");
                                    }
                                }
                            }else{
                                if (constr.getText().equals("")) {
                                    constr.setText(" " + this.classic.getConstructeurs().get(i) + " ");
                                } else {
                                    constr.setText(constr.getText() + "\n " + this.classic.getConstructeurs().get(i) + " ");
                                }
                            }
                    }
                    break;
                case "private":
                    if (this.priv) {
                            if (this.classic.getConstructeurs().get(i).split(" ")[1].equals("static")) {
                                if (this.stat) {
                                    if (constr.getText().equals("")) {
                                        constr.setText(" " + this.classic.getConstructeurs().get(i) + " ");
                                    } else {
                                        constr.setText(constr.getText() + "\n " + this.classic.getConstructeurs().get(i) + " ");
                                    }
                                }
                            }else{
                                if (constr.getText().equals("")) {
                                    constr.setText(" " + this.classic.getConstructeurs().get(i) + " ");
                                } else {
                                    constr.setText(constr.getText() + "\n " + this.classic.getConstructeurs().get(i) + " ");
                                }
                            }
                    }
                    break;
            }
        }
        // affichage de ses methodes
        Label font = new Label();
        for (int i = 0; i < this.classic.getMethodes().size(); i++) {
            switch (this.classic.getMethodes().get(i).split(" ")[0]) {
                default:
                case "public":
                    if (this.pub) {
                            if (this.classic.getMethodes().get(i).split(" ")[1].equals("static")) {
                                if (this.stat) {
                                    if (font.getText().equals("")) {
                                        font.setText(" " + this.classic.getMethodes().get(i) + " ");
                                    } else {
                                        font.setText(font.getText() + "\n " + this.classic.getMethodes().get(i) + " ");
                                    }
                                }
                            }else{
                                if (font.getText().equals("")) {
                                    font.setText(" " + this.classic.getMethodes().get(i) + " ");
                                } else {
                                    font.setText(font.getText() + "\n " + this.classic.getMethodes().get(i) + " ");
                                }
                            }
                        }
                    break;
                case "protected":
                    if (this.prot) {
                        if (this.classic.getMethodes().get(i).split(" ")[1].equals("static")) {
                            if (this.stat) {
                                if (font.getText().equals("")) {
                                    font.setText(" " + this.classic.getMethodes().get(i) + " ");
                                } else {
                                    font.setText(font.getText() + "\n " + this.classic.getMethodes().get(i) + " ");
                                }
                            }
                        }else{
                            if (font.getText().equals("")) {
                                font.setText(" " + this.classic.getMethodes().get(i) + " ");
                            } else {
                                font.setText(font.getText() + "\n " + this.classic.getMethodes().get(i) + " ");
                            }
                        }
                    }
                    break;
                case "private":
                    if (this.priv) {
                        if (this.classic.getMethodes().get(i).split(" ")[1].equals("static")) {
                            if (this.stat) {
                                if (font.getText().equals("")) {
                                    font.setText(" " + this.classic.getMethodes().get(i) + " ");
                                } else {
                                    font.setText(font.getText() + "\n " + this.classic.getMethodes().get(i) + " ");
                                }
                            }
                        }else{
                            if (font.getText().equals("")) {
                                font.setText(" " + this.classic.getMethodes().get(i) + " ");
                            } else {
                                font.setText(font.getText() + "\n " + this.classic.getMethodes().get(i) + " ");
                            }
                        }
                    }
                    break;
            }
        }
        Rectangle barre = new Rectangle(0, 0, tailleX, 2);
        barre.setFill(Color.rgb(0, 0, 0));
        Rectangle barre2 = new Rectangle(0, 0, tailleX, 2);
        barre2.setFill(Color.rgb(0, 0, 0));
        Rectangle barre3 = new Rectangle(0, 0, tailleX, 2);
        barre3.setFill(Color.rgb(0, 0, 0));
        debut.getChildren().addAll(type, name, sous);
        pack.getChildren().addAll(debut, barre, attri, barre2, constr, barre3, font);
        this.getChildren().addAll(pack);
    }

    public void changerMod(double X, double Y) {
        this.suivre = !this.suivre;
        if (this.suivre) {
            this.setVisible(false);
        } else {
            this.setLayoutX(X);
            this.setLayoutY(Y);
            this.setVisible(true);
        }
    }

    public int getTailleX() {
        return this.tailleX;
    }

    public int getTailleY() {
        return this.tailleY;
    }

    public Classe getClassic(){return classic;}

    public void eteindre(int num, boolean status) {
        switch (num) {
            case 2:
                this.prot = status;
                break;
            case 3:
                this.pub = status;
                break;
            case 1:
                this.priv = status;
                break;
            case 0:
                this.pack = status;
                break;
            case 4:
                this.stat = status;
                break;
        }
        this.getChildren().clear();
        this.generateFont();
        this.generateInside();
    }
}
