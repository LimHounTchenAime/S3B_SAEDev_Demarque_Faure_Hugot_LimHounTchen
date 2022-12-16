package Modele;

import java.util.ArrayList;
import java.util.List;

public class Classe {

    private String typeClasse;
    private String nomClasse;
    private String nomPackage;
    private List<String> attributs;
    private List<String> constructeurs;
    private List<String> methodes;
    private List<Classe> parents;

    /**
     * Constructeur ayant pour but de tester la méthode toString dans un programme
     * principal.
     * A remplacer par le constructeur utilisant un nom de fichier ayant les
     * informations sur une classe
     */
    public Classe() {
        this.typeClasse="Concrète";
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

    public String getTypeClasse() {
        return this.typeClasse;
    }

    public String getNomClasse() {
        return this.nomClasse;
    }

    public String getNomPackage() {
        return this.nomPackage;
    }

    public List<String> getAttributs() {
        return this.attributs;
    }

    public List<String> getConstructeurs() {
        return this.constructeurs;
    }

    public List<String> getMethodes() {
        return this.methodes;
    }

    public List<Classe> getParents() {
        return this.parents;
    }

    public String toString() {
        String res="Classe " + this.nomClasse + "\n";
        res+=this.typeClasse + "\n";
        res+="dans le package " + this.nomPackage + "\n";
        res+="________________\n";
        res+=this.attributs.toString() + "\n";
        res+="________________\n";
        res+=this.constructeurs.toString() + "\n";
        res+="________________\n";
        res+=this.methodes.toString() + "\n";
        //res+="________________\n";
        //res+="Parents : \n" + this.parents.toString();
        return res;
    }

}
