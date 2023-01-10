package ClasseTest;

/**
 * Classe servant au test de l affichage de la methode toString() dans un terminal avec des informations quelconques
 * d une classe Abstraite
 */

public abstract class ClasseAbstractDeTest {

    public int a;
    private static String b;
    protected final boolean c=true;

    public ClasseAbstractDeTest(){}
    private ClasseAbstractDeTest(int a){}
    protected ClasseAbstractDeTest(int a, String b){}

    public void f1(){}
    private int f2(int b){return b;}
    protected String f3(int a, int b, String c){return c;}
}
