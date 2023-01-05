package Modele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConcreteTest {
    @Test
    public void test() {
        Classe concrete=Classe.analyserClasse("Modele.ClasseConcreteDeTest");
        System.out.println(concrete.toString());
        assertEquals("<<Java Classe>>\n" +
                "ClasseConcreteDeTest\n" +
                "Modele\n" +
                "________________\n" +
                "[String s, int i, private static b:String, protected final c:boolean, public a:int]\n" +
                "________________\n" +
                "[Test(int i), private ClasseConcreteDeTest(int), protected ClasseConcreteDeTest(int,String), public ClasseConcreteDeTest()]\n" +
                "________________\n" +
                "[ajouterTest():void, private f2(int):int, protected f3(int,int,String):String, public f1():void, supprimerTest():void]\n", concrete.toString());
    }
}