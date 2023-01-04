package Main;

public class LeMainDeMomo {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c = Class.forName("Main.Main");
        System.out.println(c.getModifiers());
        System.out.println(c.toGenericString());
    }
}
