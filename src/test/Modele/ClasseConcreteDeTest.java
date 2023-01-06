package Modele;

/**
 * Classe servant au test de l affichage de la methode toString() dans un terminal avec des informations quelconques
 * d une classe Concrete
 */

public class ClasseConcreteDeTest {
    public int a;
    private static String b;
    protected final boolean c=true;

    public ClasseConcreteDeTest(){}
    private ClasseConcreteDeTest(int a){}
    protected ClasseConcreteDeTest(int a, String b){}

    public void f1(){}
    private int f2(int b){return b;}
    protected String f3(int a, int b, String c){return c;}
}
