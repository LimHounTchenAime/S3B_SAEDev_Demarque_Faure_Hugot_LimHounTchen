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
        System.out.println(m);
        System.out.println(m + "." + n.replace(".java", ""));
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

            if (concrete.getParents() != null) {
                Classe parent = Classe.creerClasse(concrete.getParents().getNomPackage() + "." + concrete.getParents().getNomClasse());
                ClasseApparence cap = new ClasseApparence(parent);
                if (this.contenu.contains(cap)) {
                    double cax = apparence.getLayoutX() + apparence.getTailleX() / 2;
                    double cay = apparence.getLayoutY() + apparence.getTailleY() / 2;
                    double capx = cap.getLayoutX() + (cap.getTailleX() / 2);
                    double capy = cap.getLayoutY() + (cap.getTailleY() / 2);
                    Line line = new Line(cax, cay, capx, capy);
                    this.getChildren().add(line);
                }

                ClasseApparence classeApparenceParent = null;
                Line line = null;
                int a = 0;
                while (line == null && a < this.contenu.size()) {
                    classeApparenceParent = this.contenu.get(a);
                    if (classeApparenceParent.getClassic().getNomClasse().equals(concrete.getParents().getNomClasse())) {
                        Fleche flecheParent = Fleche.creerFleche(apparence, classeApparenceParent);
                        this.getChildren().add(flecheParent);
                        flecheParent.toBack();
                        this.contenuFleche.add(flecheParent);
                    } else {
                        a++;
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
