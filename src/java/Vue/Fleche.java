package Vue;

import Modele.Classe;
import Modele.ClasseApparence;
import Modele.Position;
import Modele.Sujet;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;

/**
 * Classe graphique affichant une flèche de relation entre les classes dans l'interface graphique
 */

public class Fleche extends Pane {
    private Classe fils, parent;
    private ClasseApparence caf, cap;
    private boolean isAttribut, isParent, isInterface;
    private String type;

    public Fleche(Classe f, Classe p){
        this.fils = f;
        this.parent = p;
    }

<<<<<<< HEAD
    /**
     * Méthode statique permettant de créer une flèche entre deux classes
     * @param f classe fils
     * @param p classe parent
     * @return
     */
    public static Fleche creerFleche(Classe f, Classe p){
        Fleche f1 = null;
        f1.fils = f;
        f1.parent = p;

        int a=0;
        // s'il s'agit d'une flèche reliant deux classes par association
        while(a<f1.fils.getAttributs().size() && !f1.isAttribut){
            if(f1.fils.getAttributs().get(a).endsWith(f1.parent.getNomClasse())){
=======
    public static Fleche creerFleche(ClasseApparence f, ClasseApparence p){
        Classe fclasse = Classe.creerClasse(f.getClassic().getNomPackage()+"."+f.getClassic().getNomClasse());
        Classe pclasse = Classe.creerClasse(p.getClassic().getNomPackage()+"."+p.getClassic().getNomClasse());
        Fleche f1 = new Fleche(fclasse,pclasse);
        int a=0;
        while(a<fclasse.getAttributs().size() && !f1.isAttribut){
            if(f1.fils.getAttributs().get(a).endsWith(fclasse.getNomClasse())){
>>>>>>> bb553757874057fe9afd313f0de28cd4f72c5077
                f1.isAttribut=true;
            } else {
                a++;
            }
        }

        if(f1.isAttribut){
            double cax = f.getLayoutX()+f.getTailleX()/2;
            double cay = f.getLayoutY()+f.getTailleY()/2;
            double capx = p.getLayoutX()+p.getTailleX()/2;
            double capy = p.getLayoutY()+p.getTailleY()/2;
            Line line2 = new Line(cax, cay+10, capx, capy+10);
            f1.getChildren().add(line2);
        }

        f1.isParent = false;
        // s'il s'agit d'une flèche reliant deux classes par héritage
        if(f1.fils.getParents().getNomClasse().equals(f1.parent.getNomClasse())){
            f1.isParent = true;
        }

        int i = 0;
        // s'il s'agit d'une flèche reliant une classe à son interface
        while(i<f1.fils.getInterfaces().size() && !f1.isInterface){
            if(f1.fils.getInterfaces().get(i).getNomClasse().equals(f1.parent.getNomClasse())){
                f1.isInterface = true;
            } else {
                i++;
            }
        }

        double cax = f.getLayoutX()+f.getTailleX()/2;
        double cay = f.getLayoutY()+f.getTailleY()/2;
        double capx = p.getLayoutX()+p.getTailleX()/2;
        double capy = p.getLayoutY()+p.getTailleY()/2;
        Line line = new Line(cax, cay, capx, capy);
        f1.getChildren().add(line);

        return f1;
    }

    public void calculerPosition(ClasseApparence caf, ClasseApparence cap){
        this.caf = caf;
        this.cap = cap;
        double cax = this.caf.getLayoutX()+caf.getTailleX()/2;
        double cay = this.caf.getLayoutY()+caf.getTailleY()/2;
        double capx = this.cap.getLayoutX()+cap.getTailleX()/2;
        double capy = this.cap.getLayoutY()+cap.getTailleY()/2;
        this.getChildren().set(0, new Line(cax,cay,capx,capy));
    }

    /**
     * Méthode toString qui convertie la fleche sous le format PlantUML (Classe-->AutreClasse)
     * @return String
     */
    public String toString(){
        String res = "";

        if(this.isAttribut){
            res += this.fils.getNomClasse() + "-->" + this.parent.getNomClasse()+"\n";
        }

        if(this.isParent){
            res += this.fils.getNomClasse() + "--|>" + this.parent.getNomClasse() + "\n";
        }

        if(this.isInterface){
            res += this.fils.getNomClasse() + "..|>" + this.parent.getNomClasse() + "\n";
        }
        
        return res;
    }

    public String getType(){return type;}
    public Boolean getIsAttribut(){return isAttribut;}
    public Boolean getIsInterface(){return isInterface;}
    public Boolean getIsParent(){return isParent;}

    public Classe getClasseParent(){return this.parent;}
    public Classe getClasseFils(){return this.fils;}

}
