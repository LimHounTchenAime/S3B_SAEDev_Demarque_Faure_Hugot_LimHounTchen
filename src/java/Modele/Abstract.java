package java.Modele;

import java.Modele.Classe;

import java.util.ArrayList;

public class Abstract extends Classe{
<<<<<<< HEAD
    public Abstract() {
        super("","");
        this.typeClasse="Abstract";
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
=======

    public Abstract() {
        this.typeClasse="Abstract";
    }

    public String toString() {
        return this.typeClasse+"\n"+super.toString();
    }

>>>>>>> c94841da87f9592d6a22732d578e6c279d27eca4
}
