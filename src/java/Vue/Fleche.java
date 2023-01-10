package Vue;

import Modele.Classe;
import Modele.Position;
import Modele.Sujet;

public class Fleche implements Observateur {
    Classe fils, parent;
    Position p1,p2;
    public Fleche(Classe f, Classe p){
        this.fils = f;
        this.parent = p;
    }

    /**
     * Méthode toString qui convertie la fleche sous le format PlantUML (Classe-->AutreClasse)
     * @return String
     */
    public String toString(){
        String res = "";

        boolean isAttribut = false;
        int a=0;
        while(a<this.fils.getAttributs().size() && !isAttribut){
            if(this.fils.getAttributs().get(a).endsWith(this.parent.getNomClasse())){
                isAttribut=true;
            } else {
                a++;
            }
        }
        if(isAttribut){
            res += this.fils.getNomClasse() + "-->" + this.parent.getNomClasse()+"\n";
        }

        if(this.fils.getParents().getNomClasse().equals(this.parent.getNomClasse())){
            res += this.fils.getNomClasse() + "--|>" + this.parent.getNomClasse() + "\n";
        }

        boolean isImplement = false;
        int i = 0;
        while(i<this.fils.getInterfaces().size() && !isImplement){
            if(this.fils.getInterfaces().get(i).getNomClasse().equals(this.parent.getNomClasse())){
                isImplement = true;
            } else {
                i++;
            }
        }
        if(isImplement){
            res += this.fils.getNomClasse() + "..|>" + this.parent.getNomClasse() + "\n";
        }
        return res;
    }

    @Override
    public void actualiser(Sujet s) {

    }
}
