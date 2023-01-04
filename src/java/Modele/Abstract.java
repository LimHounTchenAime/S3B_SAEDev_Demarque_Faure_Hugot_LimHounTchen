package java.Modele;

import java.Modele.Classe;

public class Abstract extends Classe{

    public Abstract() {
        this.typeClasse="Abstract";
    }

    public String toString() {
        return this.typeClasse+"\n"+super.toString();
    }

}
