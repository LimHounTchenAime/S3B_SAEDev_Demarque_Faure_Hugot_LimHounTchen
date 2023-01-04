package Modele;

import java.util.ArrayList;

public class Abstract extends Classe{
    public Abstract() {
        super("","");

        this.typeClasse="Abstract";

        // cette partie sert uniquement aux tests d'affichages et sera éventuellement à enlever
        this.nomClasse="Test";
        this.nomPackage="TestClasse";
        ArrayList<String> a=new ArrayList<String>();
        a.add("int i");
        a.add("String s");
        this.attributs=a;
        ArrayList<String> c=new ArrayList<String>();
        c.add("Test(int i)");
        this.constructeurs=c;
        ArrayList<String> m=new ArrayList<String>();
        m.add("ajouterTest():void");
        m.add("supprimerTest():void");
        this.methodes=m;
    }

    public String toString() {
        return this.typeClasse+"\n"+super.toString();
    }
}
