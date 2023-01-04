package test.Modele;

import java.Modele.Abstract;
import java.Modele.Concrete;
import java.Modele.Interface;


public class Principale {

    public static void main(String[] args) {

        Concrete conc = new Concrete();
        Abstract abs = new Abstract();
        Interface inter = new Interface();

        System.out.println("Affichage classe Concrete \n");
        System.out.println(conc.toString());

        System.out.println("Affichage classe Abstract \n");
        System.out.println(abs.toString());

        System.out.println("Affichage classe Interface \n");
        System.out.println(inter.toString());
    }
}
