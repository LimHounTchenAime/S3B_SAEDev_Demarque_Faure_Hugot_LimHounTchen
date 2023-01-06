package Modele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractTest {
    @Test
    public void abstractTest(){
        Classe  abstraite=Classe.creerClasse("Modele.ClasseAbstractDeTest");
        System.out.println(abstraite.toString());
        assertEquals("<<Java Abstract>>\n" +
                "ClasseAbstractDeTest\n" +
                "Modele\n" +
                "________________\n" +
                "[private static b:String, protected final c:boolean, public a:int]\n" +
                "________________\n" +
                "[private ClasseAbstractDeTest(int), protected ClasseAbstractDeTest(int,String), public ClasseAbstractDeTest()]\n" +
                "________________\n" +
                "[private f2(int):int, protected f3(int,int,String):String, public f1():void]\n", abstraite.toString());
    }
}