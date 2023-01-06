package Modele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractTest {
    @Test
    public void abstractTest(){
        Classe abstraite=Classe.analyserClasse("Modele.ClasseAbstractDeTest");
        System.out.println(abstraite.toString());
        assertEquals("<<Java Abstract>>\n" +
                "ClasseAbstractDeTest\n" +
                "Modele\n" +
                "________________\n" +
                "[String s, int i, private static b:String, protected final c:boolean, public a:int]\n" +
                "________________\n" +
                "[Test(int i), private ClasseAbstractDeTest(int), protected ClasseAbstractDeTest(int,String), public ClasseAbstractDeTest()]\n" +
                "________________\n" +
                "[ajouterTest():void, private f2(int):int, protected f3(int,int,String):String, public f1():void, supprimerTest():void]\n", abstraite.toString());
    }
}