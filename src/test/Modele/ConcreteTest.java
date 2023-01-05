package Modele;

import org.junit.jupiter.api.Test;

class ConcreteTest {
    @Test
    public void test() {
        Classe concrete=Classe.analyserClasse("Modele.ClasseDeTest");
        System.out.println(concrete.toString());
    }
}