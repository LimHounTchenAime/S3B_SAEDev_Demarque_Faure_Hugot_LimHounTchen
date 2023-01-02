package Modele;

import org.junit.jupiter.api.Test;

class ConcreteTest {
    @Test
    public void test() throws ClassNotFoundException{
        Concrete concrete=Concrete.analyserClasse("Modele.Tmp");
    }
}