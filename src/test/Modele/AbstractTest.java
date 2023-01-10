package Modele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractTest {

    /**
     * Test vérifiant l affichage d une classe Abstraite dans un terminal avec la methode toString()
     */
    @Test
    public void abstractTest(){
        Classe  abstraite=Classe.creerClasse("ClasseTest.ClasseAbstractDeTest");
        System.out.println(abstraite.toString());
        assertEquals("<<Java Abstract>>\n" +
                "ClasseAbstractDeTest\n" +
                "ClasseTest\n" +
                "_________\n" +
                "[private static b:String, protected final c:boolean, public a:int]\n" +
                "_________\n" +
                "[private ClasseAbstractDeTest(int), protected ClasseAbstractDeTest(int,String), public ClasseAbstractDeTest()]\n" +
                "_________\n" +
                "[private f2(int):int, protected f3(int,int,String):String, public f1():void]\n", abstraite.toString());
    }
}