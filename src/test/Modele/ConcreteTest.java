package Modele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConcreteTest {

    /**
     * Test vérifiant l affichage d une classe Concrete dans un terminal avec la methode toString()
     */
    @Test
    public void test() {
        Classe concrete=Classe.creerClasse("ClasseTest.ClasseConcreteDeTest");
        System.out.println(concrete.toString());
        assertEquals("<<Java Classe>>\n" +
                "ClasseConcreteDeTest\n" +
                "ClasseTest\n" +
                "_________\n" +
                "[private static b:String, protected final c:boolean, public a:int]\n" +
                "_________\n" +
                "[private ClasseConcreteDeTest(int), protected ClasseConcreteDeTest(int,String), public ClasseConcreteDeTest()]\n" +
                "_________\n" +
                "[private f2(int):int, protected f3(int,int,String):String, public f1():void]\n", concrete.toString());
    }
}