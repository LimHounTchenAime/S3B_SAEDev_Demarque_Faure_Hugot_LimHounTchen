package Vue;

import Modele.Classe;
import Modele.ClasseApparence;
import Modele.Position;
import Modele.Sujet;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;

public class Fleche extends Pane {
    private Classe fils, parent;
    private ClasseApparence caf, cap;
    private boolean isAttribut, isParent, isInterface;
    private String type;

    public Fleche(Classe f, Classe p){
        this.fils = f;
        this.parent = p;
    }

    public static Fleche creerFleche(ClasseApparence f, ClasseApparence p){
        Classe fclasse = Classe.creerClasse(f.getClassic().getNomPackage()+"."+f.getClassic().getNomClasse());
        Classe pclasse = Classe.creerClasse(p.getClassic().getNomPackage()+"."+p.getClassic().getNomClasse());
        Fleche f1 = new Fleche(fclasse,pclasse);
        int a=0;
        while(a<fclasse.getAttributs().size() && !f1.isAttribut){
            if(f1.fils.getAttributs().get(a).endsWith(fclasse.getNomClasse())){
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
        if(f1.fils.getParents().getNomClasse().equals(f1.parent.getNomClasse())){
            f1.isParent = true;
        }

        int i = 0;
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
        double cax = caf.getLayoutX()+caf.getTailleX()/2;
        double cay = caf.getLayoutY()+caf.getTailleY()/2;
        double capx = cap.getLayoutX()+cap.getTailleX()/2;
        double capy = cap.getLayoutY()+cap.getTailleY()/2;
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

}
