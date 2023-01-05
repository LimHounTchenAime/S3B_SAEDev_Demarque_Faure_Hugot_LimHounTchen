package Modele;

public class Principale {

    public static void main(String[] args) {

        /*Il faudrat ajouter manuellement les données des classes (nom et nom de package)
          pour que ça fonctionne comme avant*/
        Concrete conc = new Concrete();
        Abstract abs = new Abstract("","");
        Interface inter = new Interface("","");

        System.out.println("Affichage classe Concrete \n");
        System.out.println(conc.toString());

        System.out.println("Affichage classe Abstract \n");
        System.out.println(abs.toString());

        System.out.println("Affichage classe Interface \n");
        System.out.println(inter.toString());
    }
}
