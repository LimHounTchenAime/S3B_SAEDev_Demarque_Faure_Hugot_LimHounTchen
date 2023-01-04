package Modele;

import org.junit.jupiter.api.Test;

class ConcreteTest {
    @Test
    public void test() throws ClassNotFoundException{
        Classe concrete=Classe.analyserClasse("Modele.ClasseDeTest");
        System.out.println(concrete.toString());
    }
}