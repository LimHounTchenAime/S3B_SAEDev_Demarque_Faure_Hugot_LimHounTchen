package Modele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestDeterminerParent {


    /**
     * Test permettant de verifer que la methode determinerParent() de la classe Classe retourne bien
     * la(les) bonne(s) classe(s) parente(s), si elle(s) existe(nt)
     * @throws ClassNotFoundException
     */
    @Test
    void TestdeterminerParent() throws ClassNotFoundException {
        Classe c = new Classe("Poisson", "ClasseTest");
        c.determinerParent();
        Classe parent = new Classe("Animal", "ClasseTest");

        System.out.println("----Classe Parent de Poisson----");
        System.out.println(c.getParents().getNomClasse()+" - "+parent.getNomClasse());
        System.out.println(c.getParents().getNomPackage()+" - "+parent.getNomPackage());

        assertEquals(c.getParents().getNomClasse(), parent.getNomClasse());
        assertEquals(c.getParents().getNomPackage(), parent.getNomPackage());
    }


    /**
     * Test permettant de verifier que la methode determinerInterface() de la classe Classe retourne bien
     * la bonne interface correspondante, si elle existe
     * @throws ClassNotFoundException
     */
    @Test
    void TestdeterminerInterface() throws ClassNotFoundException{
        Classe c = new Classe("Poisson", "ClasseTest");
        c.determinerParent();
        Classe inter = new Classe("Aquatique", "ClasseTest");
        System.out.println("----Interfaces de Poisson----");
        System.out.println(c.getInterfaces().get(0).getNomClasse()+" - "+inter.getNomClasse());
        System.out.println(c.getInterfaces().get(0).getNomPackage()+" - "+inter.getNomPackage());
        assertEquals(c.getInterfaces().get(0).getNomClasse(), inter.getNomClasse());
        assertEquals(c.getInterfaces().get(0).getNomPackage(), inter.getNomPackage());
    }
}