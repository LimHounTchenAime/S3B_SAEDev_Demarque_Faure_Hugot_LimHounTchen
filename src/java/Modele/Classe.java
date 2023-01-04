package Modele;

import java.util.List;

public abstract class Classe {

    protected String typeClasse;
    protected String nomClasse;
    protected String nomPackage;
    protected List<String> attributs;
    protected List<String> constructeurs;
    protected List<String> methodes;
    protected List<Classe> parents;

    /**
     * Constructeur ayant pour but de tester la méthode toString dans un programme
     * principal.
     * A remplacer par le constructeur utilisant un nom de fichier ayant les
     * informations sur une classe
     */

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


}
