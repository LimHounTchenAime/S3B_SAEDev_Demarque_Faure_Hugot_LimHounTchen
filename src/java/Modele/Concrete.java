package java.Modele;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.Modele.Classe;

public class Concrete extends Classe {
    public Concrete() {
        this.typeClasse="Concrète";

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

    public static Concrete analyserClasse(String cheminClasse) throws ClassNotFoundException{
        Concrete res=new Concrete();

            Class classe = Class.forName(cheminClasse);
            Field[] attributs = classe.getDeclaredFields();
            Constructor[] constructeurs = classe.getDeclaredConstructors();
            Method[] methodes = classe.getDeclaredMethods();
            Parameter[] parametres;

            res.nomClasse=classe.getName();

            System.out.println("class " + classe.getName() + "\n");
            for (Field field : attributs) {
                res.attributs.add(Modifier.toString(field.getModifiers()) + " " + field.getType() + " " + field.getName());
                System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getType() + " " + field.getName());
            }
            System.out.println();
            for (Constructor constructor : constructeurs) {
                System.out.print(Modifier.toString(constructor.getModifiers()) + " " + constructor.getName() + " (");
                parametres = constructor.getParameters();
                if (parametres != null)
                    res.constructeurs.add(parametres[0].getType()+" "+parametres[0].getName());
                    System.out.print(parametres[0].getType() + " " + parametres[0].getName());
                for (int i = 1; i < parametres.length; i++) {
                    System.out.print(", " + parametres[i].getType() + " " + parametres[i].getName());
                    res.constructeurs.add(parametres[i].getType()+" "+parametres[i].getName());
                }
                System.out.print(")");
            }
            System.out.println();
            for (Method method : methodes) {
                System.out.println(Modifier.toString(method.getModifiers()) + " " + method.getName() + " ");
                parametres = method.getParameters();
                if (parametres != null)
                    System.out.print(parametres[0].getType() + " " + parametres[0].getName());
                    res.methodes.add(parametres[0].getType()+" "+parametres[0].getName());
                for (int i = 1; i < parametres.length; i++) {
                    res.methodes.add(parametres[i].getType()+" "+parametres[i].getName());
                    System.out.print(", " + parametres[i].getType() + " " + parametres[i].getName());
                }
                System.out.print(")");
            }


        return res;
    }

    public String toString() {
        return this.typeClasse+"\n"+super.toString();
    }
}
