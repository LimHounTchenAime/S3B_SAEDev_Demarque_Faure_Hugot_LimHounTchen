package Modele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InterfaceTest {


    /**
     * Test vérifiant l affichage d une interface dans un terminal avec la methode toString()
     */
    @Test
    public void interfaceTest(){
        Classe inter=Classe.creerClasse("Modele.InterfaceDeTest");
        System.out.println(inter.toString());
        assertEquals("<<Java Interface>>\n" +
                "InterfaceDeTest\n" +
                "Modele\n" +
                "_________\n" +
                "[]\n" +
                "_________\n" +
                "[]\n" +
                "_________\n" +
                "[private f2(int):int, private f3(String,int,String):String, public abstract f1():void]\n", inter.toString());
    }
}