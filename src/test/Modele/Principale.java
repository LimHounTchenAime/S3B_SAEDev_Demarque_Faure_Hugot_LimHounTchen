package Modele;

public class Principale {

    /**
     * Programme principal permettant de visualiser l affichage des classes dans un terminal directement
     * @param args
     */
    public static void main(String[] args) {

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
