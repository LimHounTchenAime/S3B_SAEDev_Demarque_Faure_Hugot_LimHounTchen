package Modele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConcreteTest {
    @Test
    public void test() {
        Classe concrete=Classe.creerClasse("Modele.ClasseConcreteDeTest");
        System.out.println(concrete.toString());
        assertEquals("<<Java Classe>>\n" +
                "ClasseConcreteDeTest\n" +
                "Modele\n" +
                "________________\n" +
                "[private static b:String, protected final c:boolean, public a:int]\n" +
                "________________\n" +
                "[private ClasseConcreteDeTest(int), protected ClasseConcreteDeTest(int,String), public ClasseConcreteDeTest()]\n" +
                "________________\n" +
                "[private f2(int):int, protected f3(int,int,String):String, public f1():void]\n", concrete.toString());
    }
}