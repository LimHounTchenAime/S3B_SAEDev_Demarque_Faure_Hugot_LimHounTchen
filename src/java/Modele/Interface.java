package Modele;

import java.util.ArrayList;

public class Interface extends Classe{
    public Interface(String name, String packageName) {
        super(name,packageName);
        this.typeClasse="Interface";
    }

    public String toString() {
        return this.typeClasse+"\n"+super.toString();
    }
}
