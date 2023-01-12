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
    private boolean isAttribut, isParent, isInterface;
    private String type;

    public Fleche(){

    }

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
                f1.isAttribut=true;
            } else {
                a++;
            }
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
        return f1;
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
