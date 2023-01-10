package Modele;

import Vue.Fleche;

class FlecheTest {
    public static void main(String[] args) throws Exception {
        Classe c1 = Classe.creerClasse("ClasseTest.Poisson");
        Classe c2 = Classe.creerClasse("ClasseTest.Animal");
        Classe c3 = Classe.creerClasse("ClasseTest.Aquatique");
        Fleche f1 = new Fleche(c1,c2);
        Fleche f2 = new Fleche(c1, c3);
        System.out.println(f1+""+f2);
    }
}
