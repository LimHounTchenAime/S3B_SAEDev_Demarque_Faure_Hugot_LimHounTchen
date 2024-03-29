package Vue;

import Controller.EventStartDrag;
import Main.Main;
import Modele.*;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    public void dropper(Position p,String m,String n) {
        if (!(this.present.contains(n))) {
            Classe concrete = Classe.creerClasse(m + "." + n.replace(".java", ""));
            ClasseApparence apparence = new ClasseApparence(concrete);
            apparence.setLayoutX(p.X);
            apparence.setLayoutY(p.Y);
            EventStartDrag sd = new EventStartDrag(apparence, this.preview, this);
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
            if (!concrete.getParents().getNomClasse().equals("Object")) {
                Classe parent = Classe.creerClasse(concrete.getParents().getNomPackage() + "." + concrete.getParents().getNomClasse());
                ClasseApparence classeApparenceParent = null;
                int a = 0;
                while (classeApparenceParent == null && a < this.contenu.size()) {
                    classeApparenceParent = this.contenu.get(a);
                    if (classeApparenceParent.getClassic().getNomClasse().equals(concrete.getParents().getNomClasse())) {
                        Fleche flecheParent = Fleche.creerFleche(apparence, classeApparenceParent);
                        this.getChildren().add(flecheParent);
                        flecheParent.toBack();
                        this.contenuFleche.add(flecheParent);
                    } else if(classeApparenceParent.getClassic().getParents().getNomClasse().equals(concrete.getNomClasse())){
                        Fleche flecheParent = Fleche.creerFleche(classeApparenceParent, apparence);
                        this.getChildren().add(flecheParent);
                        flecheParent.toBack();
                        this.contenuFleche.add(flecheParent);
                    }else{
                        classeApparenceParent =null;
                        a++;
                    }
                }
            } else {
                ClasseApparence fils = null;
                Fleche f = null;
                int x = 0;
                while (x < this.contenu.size()) {
                    if (this.contenu.get(x).getClassic().getParents().getNomClasse().equals(concrete.getNomClasse())) {
                        fils = this.contenu.get(x);
                        f = Fleche.creerFleche(fils, apparence);
                        this.contenuFleche.add(f);
                        this.getChildren().add(f);
                        f.toBack();
                    }
                    x++;
                }
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
            while(a<this.contenuFleche.size()){
                if((this.contenuFleche.get(a).getClasseParent().getNomClasse().equals(nom))||(this.contenuFleche.get(a).getClasseFils().getNomClasse().equals(nom))){
                    f = this.contenuFleche.get(a);
                    if(f!=null){
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

                        int i = 0;
                        while(i<this.contenu.size() && cp == null){
                            String nomCap=this.contenu.get(i).getClassic().getNomClasse();
                            if(nomCap.equals(f.getClasseParent().getNomClasse())){
                                cp = this.contenu.get(i);
                            } else {
                                i++;
                            }
                        }

                        f.calculerPosition(cf,cp);
                        this.contenuFleche.set(a,f);
                        a++;
                    }
                } else {
                    a++;
                }
            }
        }

    }

    public void imprimerImage() {
            try {
                Robot robot=new Robot();
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH.mm.ss");
                LocalDateTime localDateTime=LocalDateTime.now();
                File outputfile = new File("src\\CapturesEcran\\capture_"+localDateTime.format(dtf)+".jpg");
                int width=(int)Main.getScene().getWidth();
                int height=(int)Main.getScene().getHeight();
                int posX=(int)Main.getScene().getWindow().getX()+9;
                int posY=(int)Main.getScene().getWindow().getY()+5;
                Rectangle rectangle=new Rectangle(posX, posY, width, height);
                BufferedImage b = robot.createScreenCapture(rectangle);
                //WritableImage writableImage=new WritableImage(width, height);
                //Main.getScene().snapshot(writableImage);
                //BufferedImage bufferedImage=new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
                //BufferedImage bufferedImage1= SwingFXUtils.fromFXImage(writableImage, bufferedImage);

                ImageIO.write(b, "jpg", outputfile);
                System.out.println("ecran capture");
            }
            catch (IOException ioException){
                System.out.println("IOException");
            }
            catch (AWTException awtException){
                System.out.println("awt");
            }
    }
}
