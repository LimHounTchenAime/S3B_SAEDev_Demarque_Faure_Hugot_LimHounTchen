package Modele;

public class Abstract extends Classe{

    /**
     * Constructeur creant un objet classe abstraite
     * @param name nom de la classe
     * @param packageName nom du package de la classe
     */
    public Abstract(String name, String packageName) {
        super(name,packageName);
        this.typeClasse="Abstract";
    }
}
