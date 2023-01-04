package Modele;

public class ClasseDeTest {
    public int a;
    private static String b;
    protected final boolean c=true;

    public ClasseDeTest(){}
    private ClasseDeTest(int a){}
    protected ClasseDeTest(int a, String b){}

    public void f1(){}
    private int f2(int b){return b;}
    protected String f3(int a, int b, String c){return c;}
}
