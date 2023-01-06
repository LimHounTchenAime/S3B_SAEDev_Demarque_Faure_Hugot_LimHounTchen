package Modele;

public class Interface extends Classe{

    /**
     * Constructeur creant un objet interface
     * @param name nom de l interface
     * @param packageName nom du package de l interface
     */
    public Interface(String name, String packageName) {
        super(name, packageName);
        this.typeClasse="Interface";
    }
}
