package Modele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestDeterminerParent {


    /**
     * Test permettant de verifer que la methode determinerParent() d'une classe retourne bien
     * la bonne classe parente, si elle existe
     * @throws ClassNotFoundException
     */
    @Test
    void TestdeterminerParent() throws ClassNotFoundException {
//        Classe c = new Classe("Poisson", "ClasseTest");
        Classe c = Classe.creerClasse("ClasseTest.Poisson");
//        Classe parent = new Classe("Animal", "ClasseTest");
        Classe parent = Classe.creerClasse("ClasseTest.Animal");

        System.out.println("----Classe Parent de Poisson----");
        System.out.println(c.getParents().getNomClasse()+" - "+parent.getNomClasse());
        System.out.println(c.getParents().getNomPackage()+" - "+parent.getNomPackage());

        assertEquals(c.getParents().getNomClasse(), parent.getNomClasse());
        assertEquals(c.getParents().getNomPackage(), parent.getNomPackage());
    }


    /**
     * Test permettant de verifier que la methode determinerParent() de la classe Classe retourne bien
     * la liste des interfaces correspondante, si elle existe
     * @throws ClassNotFoundException
     */
    @Test
    void TestdeterminerInterface() throws ClassNotFoundException{
        Classe c = Classe.creerClasse("ClasseTest.Poisson");
        Classe inter = Classe.creerClasse("ClasseTest.Aquatique");
        System.out.println("----Interfaces de Poisson----");
        System.out.println(c.getInterfaces().get(0).getNomClasse()+" - "+inter.getNomClasse());
        System.out.println(c.getInterfaces().get(0).getNomPackage()+" - "+inter.getNomPackage());
        assertEquals(c.getInterfaces().get(0).getNomClasse(), inter.getNomClasse());
        assertEquals(c.getInterfaces().get(0).getNomPackage(), inter.getNomPackage());
    }
}