package java.Modele;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Classe {

    public Classe(String name, String nomPackage) {
        this.typeClasse="Concrete";
        this.nomClasse=name;
        if(!nomPackage.isEmpty()) {
            this.nomPackage = nomPackage;
            this.fileName = this.nomPackage+".";
        }
        this.fileName+=this.nomClasse;

    }
    protected String fileName;
    protected String typeClasse;
    protected String nomClasse;
    protected String nomPackage;
    protected List<String> attributs;
    protected List<String> constructeurs;
    protected List<String> methodes;
    protected Classe parents;

    protected List<Classe> interfaces;

    /**
     * TODO
     * Constructeur ayant pour but de tester la méthode toString dans un programme
     * principal.
     * A remplacer par le constructeur utilisant un nom de fichier ayant les
     * informations sur une classe
     */

    //public Classe(String nomFichier);

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

    public Classe getParents() {
        return this.parents;
    }

    public String getFileName() { return this.fileName; }

    public List<Classe> getInterfaces(){ return this.interfaces; }

    public String toString() {
        String res="<<Java "+this.typeClasse+">>\n";
        res+=this.nomClasse + "\n";
        res+=this.nomPackage + "\n";
        res+="________________\n";
        res+=this.attributs.toString() + "\n";
        res+="________________\n";
        res+=this.constructeurs.toString() + "\n";
        res+="________________\n";
        res+=this.methodes.toString() + "\n";
        return res;
    }

    public void determinerParent() throws ClassNotFoundException {
        Class c = Class.forName(this.fileName);
        Class p = c.getSuperclass();
        if(p!=null){
            if(p.isInterface()){
                this.parents = new Interface();
            } else {
                if(p.toGenericString().contains("abstract")){
                    this.parents = new Abstract();
                } else {
                    this.parents = new Classe(p.getSimpleName(),p.getPackageName());
                }
            }
        }

        if(c.getInterfaces()!=null){
            for(Class i: c.getInterfaces()){
                this.interfaces.add(new Interface());
            }
        }
    }
}
