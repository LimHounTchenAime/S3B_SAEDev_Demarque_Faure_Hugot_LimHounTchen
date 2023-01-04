package java.Modele;

import java.Modele.Classe;

public class Interface extends Classe{

    public Interface() {
        this.typeClasse="Interface";
    }

    public String toString() {
        return this.typeClasse+"\n"+super.toString();
    }

}
