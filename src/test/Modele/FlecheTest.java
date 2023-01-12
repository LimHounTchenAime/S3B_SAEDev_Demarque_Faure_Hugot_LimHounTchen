package Modele;

import Vue.Fleche;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FlecheTest {

    /**
     * Test vérifiant l'affichage des flèches dans un terminal avec la méthode toString()
     * @throws Exception
     */
    @Test
    public void testFlecheToString() throws Exception {
        Classe c1 = Classe.creerClasse("ClasseTest.Poisson");
        Classe c2 = Classe.creerClasse("ClasseTest.Animal");
        Classe c3 = Classe.creerClasse("ClasseTest.Aquatique");

        Fleche f1 = Fleche.creerFleche(c1,c2);
        Fleche f2 = Fleche.creerFleche(c1,c3);

        System.out.println(f1+""+f2);

        assertEquals(f1.toString(), "Poisson-->Animal\nPoisson--|>Animal\n");
        assertEquals(f2.toString(), "Poisson..|>Aquatique\n");
    }
}
