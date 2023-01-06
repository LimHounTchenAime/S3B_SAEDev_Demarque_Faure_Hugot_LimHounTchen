package Modele;

import Modele.Abstract;
import Modele.Concrete;
import Modele.Interface;

public class Principale {

    public static void main(String[] args) {
//        Avant modification des constructeurs
//        Concrete conc = new Concrete();
//        Abstract abs = new Abstract();
//        Interface inter = new Interface();
//        Apres modification des constructeurs
        Classe conc = Classe.creerClasse("ClasseTest.Test");
        Classe abs = Classe.creerClasse("ClasseTest.TestAbstract");
        Classe inter = Classe.creerClasse("ClasseTest.TestInterface");

        System.out.println("Affichage classe Concrete \n");
        System.out.println(conc.toString());

        System.out.println("Affichage classe Abstract \n");
        System.out.println(abs.toString());

        System.out.println("Affichage classe Interface \n");
        System.out.println(inter.toString());
    }
}
