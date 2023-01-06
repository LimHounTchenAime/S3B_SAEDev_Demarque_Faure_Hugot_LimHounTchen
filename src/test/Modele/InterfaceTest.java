package Modele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InterfaceTest {

    @Test
    public void interfaceTest(){
        Classe inter=Classe.creerClasse("Modele.InterfaceDeTest");
        System.out.println(inter.toString());
        assertEquals("<<Java Interface>>\n" +
                "InterfaceDeTest\n" +
                "Modele\n" +
                "________________\n" +
                "[]\n" +
                "________________\n" +
                "[]\n" +
                "________________\n" +
                "[private f2(int):int, private f3(String,int,String):String, public abstract f1():void]\n", inter.toString());
    }
}