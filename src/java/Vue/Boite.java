package Vue;

import Modele.ClasseApparence;
import Modele.Sujet;

public class Boite implements Observateur {
    ClasseApparence ca;

    public Boite(ClasseApparence ca) {
        this.ca = ca;
        ca.tailler();
    }

    @Override
    public void actualiser(Sujet s) {

    }
}
