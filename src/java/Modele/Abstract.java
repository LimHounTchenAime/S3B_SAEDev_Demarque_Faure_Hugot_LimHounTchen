package Modele;

import java.util.ArrayList;

public class Abstract extends Classe{
    public Abstract(String name, String packageName) {
        super(name,packageName);
        this.typeClasse="Abstract";
    }

    public String toString() {
        return this.typeClasse+"\n"+super.toString();
    }
}
