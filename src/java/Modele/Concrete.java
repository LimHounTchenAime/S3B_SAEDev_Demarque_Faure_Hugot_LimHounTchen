package Modele;

public class Concrete extends Classe {

    /**
     * Constructeur creant un objet classe concrete
     * @param name nom de la classe
     * @param nomPackage nom du package de la classe
     */
    public Concrete(String name, String nomPackage) {
        super(name, nomPackage);
        this.typeClasse="Classe";
    }
}
