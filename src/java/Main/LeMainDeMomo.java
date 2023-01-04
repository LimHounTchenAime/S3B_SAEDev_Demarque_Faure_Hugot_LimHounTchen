package java.Main;

public class LeMainDeMomo {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c = Class.forName("Main");
        System.out.println(c.getTypeName());
    }
}
