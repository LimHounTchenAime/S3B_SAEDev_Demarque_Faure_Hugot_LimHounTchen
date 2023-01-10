package Modele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClasseExterne {
    @Test
    public void test(){
        Classe concrete=Classe.creerClasse("C:\\Users\\aimel\\Desktop\\tmp\\test\\Classe1.java");
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
