package Modele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Classe permettant de tester si une classe externe au projet, se trouvant donc sur le PC
 * à un autre endroit, peut tout de même être affichée
 */

public class TestClasseExterne {
    @Test
    public void test(){
        Classe concrete=Classe.creerClasse("C:\\Users\\Elève\\Desktop\\Classe1.java");
        System.out.println(concrete.toString());
        assertEquals(2, concrete.getAttributs().size());
        assertEquals("<<Java Classe>>\n" +
                "Classe1\n" +
                "ClassesChargees\n" +
                "________________\n" +
                "[ a:int,  b:String]\n" +
                "________________\n" +
                "[ Classe1(int,String)]\n" +
                "________________\n" +
                "[public show():void]\n", concrete.toString());
    }
}
